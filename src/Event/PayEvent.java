package Event;

import General.Event;
import General.State;
import State.Customer;
import State.StoreState;

public class PayEvent extends Event{
	protected Customer customer;


	public PayEvent(State state, double executeTime, Customer customer) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		//Uppdatera StoreState med relevant information
		
		((StoreState)state).updateStoreCount(false); // minskar antalet i affären med 1
		((StoreState)state).updatePaidCustomers(); // ökar antalet kunder som har betalat med 1
		
		if (((StoreState)state).getCheckoutQueue().getSize() > 0) {
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).returnPayTime(), ((StoreState)state).getCheckoutQueue().getFirstCustomer()));
		}
		state.update(this);


	}
}
