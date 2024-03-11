package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class PayEvent extends Event{
	protected Customer customer;
	private int printall;


	public PayEvent(State state, double executeTime, EventQueue eventQueue, Customer customer, int printall) {
		super(state, eventQueue, executeTime);
		this.customer = customer;
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		state.update(this);
		((StoreState)state).updateRealTime();
		//Uppdatera StoreState med relevant information
		((StoreState)state).registersempty();

		((StoreState)state).updateStoreCount(false); // minskar antalet i affären med 1
		
		if (((StoreState)state).getCheckoutQueue().getSize() > 0) {
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pay");
			if (printall == 1) {
				state.notifyObserver();
			}
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, ((StoreState)state).getCheckoutQueue().getFirstCustomer(), printall));
		} else {
			((StoreState)state).updateCurrentInCheckout(false);
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pay");
			if (printall == 1) {
				state.notifyObserver();
			}
		}
		((StoreState)state).updatePaidCustomers(); // ökar antalet kunder som har betalat med 1

		



	}
}
