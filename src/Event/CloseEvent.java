package Event;

import General.Event;
import General.EventQueue;
import General.State;

public class CloseEvent extends Event{

	public CloseEvent(State state, double executeTime, EventQueue eventQueue) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this);
		//Uppdatera StoreState med relevant information
	}

}
