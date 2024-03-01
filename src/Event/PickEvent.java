package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;

public class PickEvent extends Event{
	protected Customer customer;

	public PickEvent(State state, double executeTime, Customer customer) {
		super(state, executeTime, customer);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this);
		//Uppdatera StoreState med relevant information
		//lägg till i Queue ett nytt PayEvent
	}

}
