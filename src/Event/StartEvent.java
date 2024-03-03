package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.StoreState;

public class StartEvent extends Event {

	public StartEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		((StoreState)state).setOpenStatus(true);//Öppna affären i StoreState
		
		//Lägg till ArrivalEvent i Queue
		eventQueue.addToQueue(new ArrivalEvent((StoreState)state, ((StoreState)state).returnArrivalTime()));
		//ArrivalEvent behöver state, arrivalTime
		state.update(this); // Vi uppdaterar state klockan med executeTime
	}

}