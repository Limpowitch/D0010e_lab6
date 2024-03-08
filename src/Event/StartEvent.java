package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.StoreState;
import View.View;

public class StartEvent extends Event {
	private View view;
	private int printall;
	public StartEvent(State state, double executeTime, EventQueue eventQueue, View view, int printall) {
		super(state, eventQueue ,executeTime);
		this.view = view;
		this.printall = printall;
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		
		
		
		((StoreState)state).setOpenStatus("Ö");//Öppna affären i StoreState
		
		//Lägg till ArrivalEvent i Queue
		eventQueue.addToQueue(new ArrivalEvent((StoreState)state, eventQueue, ((StoreState)state).getArrivalTime(), ((StoreState)state).generatedCustomer(), printall));
		//ArrivalEvent behöver state, arrivalTime
		
		if (printall == 1) {
			view.printBeginStore();

		}
		
		
	}

}
