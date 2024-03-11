package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class PickEvent extends Event{
	protected Customer customer;
	private int printall;

	public PickEvent(State state, double executeTime, EventQueue eventQueue, Customer customer, int printall) {
		super(state, eventQueue, executeTime);
		this.customer = customer;
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		state.update(this);
		((StoreState)state).updateRealTime();
		//Om antalet kunder i kön inte är max capacity
		//TODO: unfucka den här 
		if (((StoreState)state).getCurrentInCheckout() != ((StoreState)state).getMaxCheckoutCapacity()) {
			//TODO: Lägg till relevanta storestate updates
			//Lägg till nytt payEvent
			((StoreState)state).registersempty();
			((StoreState)state).updateCurrentInCheckout(true);
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, customer, printall));
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pick");
			if (printall == 1) {
				state.notifyObserver();
			}
		//Om antalet kunder är detsamma som max capacity
		} else {
			//Lägg till kund i kö
			((StoreState)state).registersempty();
			((StoreState)state).updateBeenInQueue(); //ökar antalet som har varit i kön med 1
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pick");
			if (printall == 1) {
				state.notifyObserver();
			}
			((StoreState)state).getCheckoutQueue().addCustomer(customer); // lägger in en kund i kö
		}
		


	}
}