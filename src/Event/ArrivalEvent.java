package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class ArrivalEvent extends Event{
	

	public ArrivalEvent(State state, EventQueue eventQueue, double executeTime) {
		super(state, eventQueue, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		//Skapa customer
		Customer customer = ((StoreState)state).generatedCustomer();
		((StoreState)state).updateTotalCustomers();
		
		//Kolla om affär är öppen och att det inte är fullt
		if (((StoreState)state).getOpenStatus() 
			&& ((StoreState)state).getCustomersInStore() < ((StoreState)state).getMaxCapacity() ) {
			
			((StoreState)state).updateStoreCount(true); // ökar antalet i affären med 1
			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime()));
			//Lägg till i Queue ett nytt pickEvent
			eventQueue.addToQueue(new PickEvent((StoreState)state, ((StoreState)state).getPickTime(), eventQueue, customer));
			
		} else if (((StoreState)state).getOpenStatus() 
			&& ((StoreState)state).getCustomersInStore() == ((StoreState)state).getMaxCapacity()) {
			
			((StoreState)state).updateMissedCustomers(); // Ökar missade antalet kunder med 1
			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime()));
			
		}
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Arrival");
		state.update(this); //uppdaterar klockan

		
	}

	
	
}
