package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;

public class PayEvent extends Event{
	protected Customer customer;


	public PayEvent(State state, double executeTime, EventQueue eventQueue, Customer customer) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		super.execute();
		state.update(this);
		//Uppdatera StoreState med relevant information
	}
}
