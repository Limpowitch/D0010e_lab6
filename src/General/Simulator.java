package General;

import View.View;
import General.Event;

public class Simulator {
	protected State state;
	protected EventQueue eventQueue;
	protected View view;
	
	public Simulator(State state, EventQueue eventQueue, View view) {
		this.eventQueue = eventQueue;
		this.state = state;
		this.view = view;
	}
	
	public void run() {
		view.printBeginStore();
		// Borde fungera samt snyggare. Men kolla gärna igenom
		// Vi behöver i så fall inte alla grejjer i state
		for (Event event : eventQueue) {
		    event.execute();
		    eventQueue.remove(event);
		}
		
		/*
		while (state.isRunning) {
			if (eventQueue.size() == 0) {
				state.stopSim();
			}  else {
				eventQueue.get(0).execute();
				eventQueue.remove(0);
			}
			
		}*/
		//Plocka ut 0:e Event i Eventqueue, kör execute
		//Ta bort 0:e Event i EventQueue
	}

}




