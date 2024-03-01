package Event;

import General.Event;
import General.EventQueue;
import General.State;

public class ArrivalEvent extends Event{

	public ArrivalEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute(new PickEvent(state, executeTime, customer, eventQueue));
		state.update(this); //uppdaterar klockan
		//Lägg till i Queue ett nytt ArrivalEvent
		//Lägg till i Queue ett nytt pickEvent
	}

	
	
}
