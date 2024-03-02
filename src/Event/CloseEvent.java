package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.NewCustomer;

public class CloseEvent extends Event{
	NewCustomer customer;
	
	public CloseEvent(State state, double executeTime, NewCustomer customer) {
		super(state, executeTime);
        this.customer = customer;
	}
	
	public void execute() {
		super.execute(this);
		state.update(this);
		//Uppdatera StoreState med relevant information
	}

}
