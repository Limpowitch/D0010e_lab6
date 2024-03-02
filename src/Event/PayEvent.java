package Event;

import General.Event;
import General.State;
import State.NewCustomer;

public class PayEvent extends Event{
	NewCustomer customer;
	public PayEvent(State state, double executeTime, NewCustomer customer) {
		super(state, executeTime);
		this.customer = customer;
	}

	public void execute() {
		super.execute(new CloseEvent(state, executeTime, customer));
		state.update(this);
		//Uppdatera StoreState med relevant information
	}
}
