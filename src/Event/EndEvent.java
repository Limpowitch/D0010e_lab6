package Event;

import View.View;
import General.Event;
import General.EventQueue;
import General.State;

public class EndEvent extends Event{
	private View view;
	private int printall;
	public EndEvent(State state, double executeTime, EventQueue eventQueue, View view, int printall) {
		super(state, eventQueue, executeTime);
		this.view = view;
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		//Uppdatera StoreState med relevant information
		state.stopSim();
		
		if (printall == 1) {
			view.printCloseStore();

		}

		
		
	}

}