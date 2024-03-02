package Main;

import General.Simulator;
import General.State;
import General.EventQueue;
import Event.StartEvent;
import Event.EndEvent;
import View.View;

public class RunSim {
	private Simulator simulator;
	
	public RunSim(Simulator simulator) {
		this.simulator = simulator;
	}
	public static void main(String[] args) {
		// Simulator 1 //
		RunSim runSim1 = new RunSim(new Simulator(new State(), new EventQueue(), new View()));
		
		Simulator simulator1 = runSim1.simulator.getSimulator();
		
		simulator1.initializeEventQueue(new StartEvent(simulator1.getState(), 0), 
									   new EndEvent(simulator1.getState(), 999));
		simulator1.run();
		/////////////////
    }
}
