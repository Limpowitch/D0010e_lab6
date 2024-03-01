package General;

import View.View;
import General.Event;

public class Simulator {
	protected State state;
	protected EventQueue eventQueue;
	protected View view;
	private String eventName;
	
	public Simulator(State state, EventQueue eventQueue, View view) {
		this.eventQueue = eventQueue;
		this.state = state;
		this.view = view;
	}
	
	public void run() {
		view.printBeginStore();
		// nu lägger vi till ett startevent
		eventQueue.addToQueue(new Event(state, 0));
		while (state.isRunning) {
			view.printStoreState();
			if (eventQueue.size() == 0) {
				state.stopSim();
				continue;
			}
			eventName = eventQueue.get(0).getClass().getSimpleName();
			view.updateCurrentEvent(eventName);
			eventQueue.remove(0);
			
			view.printEndStore();
		}
		//Plocka ut 0:e Event i Eventqueue, kör execute
		//Ta bort 0:e Event i EventQueue
	}

}




