package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.NewCustomer;

public class StartEvent extends Event {
	NewCustomer customer;
	
	public StartEvent(State state, double executeTime) {
		super(state, executeTime);
	}
	
	public void execute() {
		super.execute(new ArrivalEvent(state, executeTime, customer));
		state.update(this); // Vi uppdaterar state klockan med executeTime
		//Uppdatera StoreState med relevant information
		//Lägg till ArrivalEvent i Queue
		//ArrivalEvent behöver state, arrivalTime, eventQueue
	}

}
