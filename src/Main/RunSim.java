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
		RunSim runSim1 = new RunSim(1234, 1, 5, 4, 0.5, 1, 2, 3, 10); // ex1
		RunSim runSim2 = new RunSim(13, 3, 7, 2, 0.6, 0.9, 0.35, 0.6, 8); // ex3
	}
	
	public RunSim(int seed, int lambda, int maxCapacity, int maxCheckoutCapacity, double pickLow, double pickHigh, double payLow, double payHigh, double closeTime) {
		//State state = new State();
		StoreState storeState = new StoreState
				(seed, 
				 lambda, 
				 maxCapacity, 
				 maxCheckoutCapacity, 
				 pickLow, 
				 pickHigh, 
				 payLow, 
				 payHigh);
		EventQueue eventQueue = new EventQueue();
		View view = new View(storeState);
		eventQueue.add(new StartEvent(storeState, 0, eventQueue, view));
		eventQueue.add(new CloseEvent(storeState, eventQueue, closeTime));
		eventQueue.add(new EndEvent(storeState, 999, eventQueue, view));
		Simulator simulator = new Simulator(storeState, eventQueue);
		simulator.run();
	}
}
