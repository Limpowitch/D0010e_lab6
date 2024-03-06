package Event;

import View.View;
import General.Event;
import General.EventQueue;
import General.State;

public class EndEvent extends Event{
	private View view;
	public EndEvent(State state, double executeTime, EventQueue eventQueue, View view) {
		super(state, eventQueue, executeTime);
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		//Uppdatera StoreState med relevant information
		state.stopSim();
		
		view.printCloseStore();

		
		
	}

}