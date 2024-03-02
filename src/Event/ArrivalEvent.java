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
		while (true) {
			super.
			state.update(this); //uppdaterar klockan
			super.addEvent(new PickEvent(state, executeTime, customer));
			//Lägg till i Queue ett nytt ArrivalEvent
			//Lägg till i Queue ett nytt pickEvent
		}
	}

	
	
}
