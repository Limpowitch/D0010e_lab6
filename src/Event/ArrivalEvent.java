package Event;

import General.Event;
import General.State;
import State.NewCustomer;

public class ArrivalEvent extends Event{
	NewCustomer customer;
	
	public ArrivalEvent(State state, double executeTime, NewCustomer customer) {
		super(state, executeTime);
		this.customer = customer;
	}
	
	public void execute() {
		super.execute(new PickEvent(state, executeTime, customer));
		state.update(this); //uppdaterar klockan
		//Lägg till i Queue ett nytt ArrivalEvent
		//Lägg till i Queue ett nytt pickEvent
	}

	
	
}
