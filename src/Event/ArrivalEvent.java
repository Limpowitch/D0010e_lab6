package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class ArrivalEvent extends Event{
	

	protected Customer customer;
	private int printall;

	public ArrivalEvent(State state, EventQueue eventQueue, double executeTime, Customer customer, int printall) {
		super(state, eventQueue, executeTime);
		this.customer = customer;
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		//Skapa customer
		state.update(this); //uppdaterar klockan

		//Kolla om affär är öppen och att det inte är fullt
		if (((StoreState)state).getOpenStatus() == "Ö" 
			&& ((StoreState)state).getCustomersInStore() < ((StoreState)state).getMaxCapacity() ) {
			((StoreState)state).registersempty();
			((StoreState)state).updateTotalCustomers();
			((StoreState)state).updateRealTime();

			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime(), ((StoreState)state).generatedCustomer(), printall));
			//Lägg till i Queue ett nytt pickEvent
			eventQueue.addToQueue(new PickEvent((StoreState)state, ((StoreState)state).getPickTime(), eventQueue, customer, printall));
			((StoreState)state).updateStoreCount(true); // ökar antalet i affären med 1

		} else if (((StoreState)state).getOpenStatus() == "Ö" 
			&& ((StoreState)state).getCustomersInStore() == ((StoreState)state).getMaxCapacity()) {
			((StoreState)state).registersempty();
			((StoreState)state).updateTotalCustomers();
			((StoreState)state).updateRealTime();

			
			((StoreState)state).updateMissedCustomers(); // Ökar missade antalet kunder med 1
			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime(), ((StoreState)state).generatedCustomer(), printall));
			
		}
		((StoreState)state).updateLatestEventCustomer(customer.customerID);
		((StoreState)state).updateLatestEvent("Arrival");
		if (printall == 1) {
			state.notifyObserver();
		}
		
		

		
	}

	
	
}
