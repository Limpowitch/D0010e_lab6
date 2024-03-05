package Event;

import General.Event;
import General.EventQueue;
import General.State;

public class EndEvent extends Event{

	public EndEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		//Uppdatera StoreState med relevant information
		state.stopSim();
		state.update(this);
		
		
	}

}