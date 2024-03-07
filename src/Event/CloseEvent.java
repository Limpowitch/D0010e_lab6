package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class CloseEvent extends Event{

	public CloseEvent(State state, EventQueue eventQueue, double executeTime) {
		super(state, eventQueue, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		state.update(this);

		((StoreState)state).setOpenStatus("S");
		int customer = -1;
		//Uppdatera StoreState med relevant information
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Close");
		
		state.notifyObserver();

	}

}
