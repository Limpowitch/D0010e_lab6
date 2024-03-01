package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;

public class PayEvent extends Event{
	protected Customer customer;


	public PayEvent(State state, double executeTime, Customer customer) {
		super(state, executeTime, customer);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		super.execute(new EndEvent(state, executeTime, customer, eventQueue));
		state.update(this);
		//Uppdatera StoreState med relevant information
	}
}
