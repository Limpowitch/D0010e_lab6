package Event;

import General.Event;
import General.State;
import State.NewCustomer;

public class PickEvent extends Event{
	NewCustomer customer;
	
	public PickEvent(State state, double executeTime, NewCustomer customer) {
		super(state, executeTime);
        this.customer = customer;
	}
	
	public void execute() {
		super.execute(new PayEvent(state, executeTime, customer));
		state.update(this);
		//Uppdatera StoreState med relevant information
		//lägg till i Queue ett nytt PayEvent
	}

}
