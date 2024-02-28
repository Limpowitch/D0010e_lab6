package Event;

import General.Event;
import General.EventQueue;
import General.State;

public class StartEvent extends Event {

	public StartEvent(State state, double executeTime, EventQueue eventQueue) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this); // Vi uppdaterar state klockan med executeTime
		//Uppdatera StoreState med relevant information
		//Lägg till ArrivalEvent i Queue
		//ArrivalEvent behöver state, arrivalTime, eventQueue
	}

}
