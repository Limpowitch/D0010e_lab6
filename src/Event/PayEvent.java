package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class PayEvent extends Event{
	protected Customer customer;


	public PayEvent(State state, double executeTime, EventQueue eventQueue, Customer customer) {
		super(state, eventQueue, executeTime);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		state.update(this);

		//Uppdatera StoreState med relevant information
		
		((StoreState)state).updateStoreCount(false); // minskar antalet i affären med 1
		((StoreState)state).updatePaidCustomers(); // ökar antalet kunder som har betalat med 1
		
		if (((StoreState)state).getCheckoutQueue().getSize() > 0) {
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, ((StoreState)state).getCheckoutQueue().getFirstCustomer()));
		}
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Pay");
		state.notifyObserver();



	}
}
