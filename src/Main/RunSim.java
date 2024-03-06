package Main;

import Event.StartEvent;
import Event.CloseEvent;
import Event.EndEvent;
import General.EventQueue;
import General.Simulator;
//import General.State;
import State.StoreState;
import View.View;
//import Helper_Functions.K;

public class RunSim {
	public static void main(String[] args) {
		RunSim runSim = new RunSim();
	}
	
	public RunSim() {
		//State state = new State();
		StoreState storeState = new StoreState
				(1234, 
				 1, 
				 5, 
				 4, 
				 0.5, 
				 1, 
				 2, 
				 3);
		EventQueue eventQueue = new EventQueue();
		View view = new View(storeState);
		eventQueue.add(new StartEvent(storeState, 0, eventQueue, view));
		eventQueue.add(new CloseEvent(storeState, eventQueue, 10));
		eventQueue.add(new EndEvent(storeState, 999, eventQueue, view));
		Simulator simulator = new Simulator(storeState, eventQueue);
		simulator.run();
	}
}
