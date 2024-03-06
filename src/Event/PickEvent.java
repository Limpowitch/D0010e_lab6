package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class PickEvent extends Event{
	protected Customer customer;

	public PickEvent(State state, double executeTime, EventQueue eventQueue, Customer customer) {
		super(state, eventQueue, executeTime);
		this.customer = customer;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		state.update(this);

		//Om antalet kunder i kön inte är max capacity
		//TODO: unfucka den här 
		if (((StoreState)state).getCurrentInCheckout() != ((StoreState)state).getMaxCheckoutCapacity()) {
			//TODO: Lägg till relevanta storestate updates
			//Lägg till nytt payEvent
			((StoreState)state).updateCurrentInCheckout(true);
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, customer));
			
		//Om antalet kunder är detsamma som max capacity
		} else {
			//Lägg till kund i kö
			((StoreState)state).updateBeenInQueue(); //ökar antalet som har varit i kön med 1
			((StoreState)state).getCheckoutQueue().addCustomer(customer); // lägger in en kund i kö
		}
		((StoreState)state).updateLatestEventCustomer(customer.customerID);
		((StoreState)state).updateLatestEvent("Pick");
		state.notifyObserver();


	}
}