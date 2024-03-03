package Event;

import General.Event;
import General.State;

public class EndEvent extends Event{

	public EndEvent(State state, double executeTime) {
		super(state, executeTime);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
<<<<<<< HEAD
		state.update(this);
=======
>>>>>>> 15e65bb (boom bam fixat majoriteten)
		//Uppdatera StoreState med relevant information
		state.stopSim();
		state.update(this);
	}

}