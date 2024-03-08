package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class CloseEvent extends Event{

	private int printall;

	public CloseEvent(State state, EventQueue eventQueue, double executeTime, int printall) {
		super(state, eventQueue, executeTime);
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		state.update(this);

		((StoreState)state).setOpenStatus("S");
		int customer = -1;
		//Uppdatera StoreState med relevant information
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Close");
		
		if (printall == 1) {
			state.notifyObserver();
		}

	}

}
