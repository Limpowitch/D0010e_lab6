package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;

public class StartEvent extends Event {

	public StartEvent(State state, double executeTime, Customer customer, EventQueue eventQueue) {
		super(state, executeTime, customer, eventQueue);
	}
	
	public void execute() {
		super.execute(new ArrivalEvent(state, executeTime, customer, eventQueue));
		state.update(this); // Vi uppdaterar state klockan med executeTime
		//Uppdatera StoreState med relevant information
		//Lägg till ArrivalEvent i Queue
		//ArrivalEvent behöver state, arrivalTime, eventQueue
	}

}
