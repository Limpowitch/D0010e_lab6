package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

public class CloseEvent extends Event{

	public CloseEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		((StoreState)state).setOpenStatus(false);
		String customer = "---";
		//Uppdatera StoreState med relevant information
		((StoreState)state).updateLatestEvent("Close");
		state.update(this);

	}

}
