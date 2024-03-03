package General;

import State.StoreState;
import View.View;

public class Simulator {
	protected State state;
	protected EventQueue eventQueue;
	private String eventName;
	
	public Simulator(State state, EventQueue eventQueue) {
		this.eventQueue = eventQueue;
		this.state = state;
	}
	
	public void initializeEventQueue(Event startEvent, Event endEvent) {
		eventQueue.addToQueue(startEvent);
		eventQueue.addToQueue(endEvent);
	}
	
	public void run() {
		//while !state.isStopped
		while(state.isRunning) {
			eventQueue.get(0).execute();
			eventQueue.remove(0);
		}
		//Plocka ut 0:e Event i Eventqueue, kör execute
		//Ta bort 0:e Event i EventQueuex
		// för kontroll //
		System.out.println("\n" + eventQueue.toString() + "\n");
		while (eventQueue.size() > 0) {
			eventName = eventQueue.get(0).getClass().getSimpleName();
            view.updateCurrentEvent(eventName);
            eventQueue.remove(0);
    		// för kontroll //
    		System.out.println("\n" + eventQueue.toString() + "\n");
		}
		
		/*while (state.isRunning) {
			view.printStoreState();
			if (eventQueue.size() == 0) {
				state.stopSim();
				continue;
			}
			eventName = eventQueue.get(0).getClass().getSimpleName();
			view.updateCurrentEvent(eventName);
			eventQueue.remove(0);
			
		}*/
		view.printCloseStore();
	}
	
	public Simulator getSimulator() {
		return this;
	}
	
	public State getState() {
        return state;
    }

}




