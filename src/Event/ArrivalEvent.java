package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class ArrivalEvent extends Event{
	

	public ArrivalEvent(State state, double executeTime, EventQueue eventQueue) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this); //uppdaterar klockan
		
		//Skapa customer
		Customer customer = ((StoreState)state).generatedCustomer();
		
		//Kolla om affär är öppen och att det inte är fullt
		if (((StoreState)state).returnOpenStatus() 
			&& ((StoreState)state).returnCustomersInStore() < ((StoreState)state).returnMaxCapacity() ) {
			
			((StoreState)state).updateStoreCount(true); // ökar antalet i affären med 1
			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, ((StoreState)state).returnArrivalTime(), eventQueue));
			//Lägg till i Queue ett nytt pickEvent
			eventQueue.addToQueue(new PickEvent((StoreState)state, ((StoreState)state).returnPickTime(), eventQueue, customer));
			
		} else if (((StoreState)state).returnOpenStatus() 
			&& ((StoreState)state).returnCustomersInStore() == ((StoreState)state).returnMaxCapacity()) {
			
			((StoreState)state).updateMissedCustomers(); // Ökar missade antalet kunder med 1
			
			//Lägg till i Queue ett nytt arrivalEvent
			eventQueue.addToQueue(new ArrivalEvent((StoreState)state, ((StoreState)state).returnArrivalTime(), eventQueue));
			
		} 
		
	}

	
	
}
