package General;

import View.View;

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
	
	public void initializeEventQueue(Event startEvent, Event endEvent) {
		eventQueue.addToQueue(startEvent);
		eventQueue.addToQueue(endEvent);
	}
	
	public void run() {
		//Plocka ut 0:e Event i Eventqueue, kör execute
		//Ta bort 0:e Event i EventQueuex
		view.printBeginStore();
		System.out.println("\n" + eventQueue.toString() + "\n");
		while (state.isRunning) {
			view.printStoreState();
			if (eventQueue.size() == 0) {
				state.stopSim();
				continue;
			}
			eventName = eventQueue.get(0).getClass().getSimpleName();
			view.updateCurrentEvent(eventName);
			eventQueue.remove(0);
			
		}
		view.printEndStore();
	}
	
	public Simulator getSimulator() {
		return this;
	}
	
	public State getState() {
        return state;
    }

}




