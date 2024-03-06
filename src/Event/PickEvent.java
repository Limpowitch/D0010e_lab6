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
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		//Om antalet kunder i kön inte är max capacity
		//TODO: unfucka den här 
		if (((StoreState)state).getCheckoutQueue().getSize() != ((StoreState)state).getMaxCheckoutCapacity()) {
			//TODO: Lägg till relevanta storestate updates
			//Lägg till nytt payEvent
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, ((StoreState)state).getCheckoutQueue().getFirstCustomer()));
			
		//Om antalet kunder är detsamma som max capacity
		} else {
			//Lägg till kund i kö
			((StoreState)state).updateBeenInQueue(); //ökar antalet som har varit i kön med 1
			((StoreState)state).getCheckoutQueue().addCustomer(customer); // lägger in en kund i kö
		}
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Pick");
		state.update(this);

	}
}