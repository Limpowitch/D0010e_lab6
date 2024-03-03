package Main;

import State.StoreState;
import General.Simulator;
import General.State;
import General.EventQueue;
import Event.StartEvent;
import Event.EndEvent;
import View.View;
import Helper_Functions.K;
import Helper_Functions.ExponentialRandomStream;
import Helper_Functions.UniformRandomStream;

public class RunSim {
	/*private Simulator simulator;
	
	public RunSim(Simulator simulator) {
		this.simulator = simulator;
	}*/
	public static void main(String[] args) {
		// Simulator 1 //
		State state1 = new State();
		// StoreState(lambda, seed)
		StoreState storeState1 = new StoreState(0.5, K.SEED);
		View view1 = new View(storeState1);
		EventQueue eventQueue1 = new EventQueue();
		Simulator simulator = new Simulator(state1, eventQueue1);

		view1.printBeginStore();
		eventQueue1.addToQueue(new StartEvent(state1, 0));
		eventQueue1.addToQueue(new EndEvent(state1, 999));
		simulator.run();
		view1.printCloseStore();
		/////////////////
    }
}
