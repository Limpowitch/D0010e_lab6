package Event;

import General.Event;
import General.EventQueue;
import General.State;

public class ArrivalEvent extends Event{

	public ArrivalEvent(State state, double executeTime, EventQueue eventQueue) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this); //uppdaterar klockan
		//Lägg till i Queue ett nytt ArrivalEvent
		//Lägg till i Queue ett nytt pickEvent
	}

	
	
}
