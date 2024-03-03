package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.StoreState;

public class CloseEvent extends Event{

	public CloseEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		((StoreState)state).setOpenStatus(false);
		//Uppdatera StoreState med relevant information
		state.update(this);

	}

}