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
		// För den Ooptimiserade simuleringen.
		RunSim runSim = new RunSim();
		runSim.startNew();
	}
	
	int startNew (int seed, double lambda, int maxCapacity, int maxCheckoutCapacity, double pickLow, double pickHigh, double payLow, double payHigh) {
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
		eventQueue.add(new CloseEvent(storeState, eventQueue, 10));
		eventQueue.add(new EndEvent(storeState, 999, eventQueue, view));
		Simulator simulator = new Simulator(storeState, eventQueue);
		simulator.run();
		return (storeState.getMissedCustomers();
	}
}
