package General;

public class Simulator {
	protected State state;
	protected EventQueue eventQueue;
	
	public Simulator(State state, EventQueue eventQueue) {
		this.eventQueue = eventQueue;
		this.state = state;
	}
	
	public void run() {
		//while !state.isStopped
		//Plocka ut 0:e Event i Eventqueue, kör execute
		//Ta bort 0:e Event i EventQueue
	}

}




