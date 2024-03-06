package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.StoreState;
import View.View;

public class StartEvent extends Event {
	private View view;
	public StartEvent(State state, double executeTime, EventQueue eventQueue, View view) {
		super(state, eventQueue ,executeTime);
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		
		
		((StoreState)state).setOpenStatus(true);//Öppna affären i StoreState
		
		//Lägg till ArrivalEvent i Queue
		eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime()));
		//ArrivalEvent behöver state, arrivalTime
		
		view.printBeginStore();
		
		
		
	}

}
