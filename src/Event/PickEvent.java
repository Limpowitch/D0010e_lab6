package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;

public class PickEvent extends Event{
	protected Customer customer;

	public PickEvent(State state, double executeTime, EventQueue eventQueue, Customer customer) {
		super(state, executeTime, eventQueue);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		super.execute();
		state.update(this);
		
		//TODO: Fixa FIFO kö
		// om ((StoreState)state).getCheckoutQueue().size() == ((StoreState)state).getMaxCheckoutCapacity()
			//Lägg till kund i kö
			//Kön hanteras i payEvent
		
		//Annars
			//Skapa payEvent
	}

}
