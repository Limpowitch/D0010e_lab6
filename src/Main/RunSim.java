package Main;

import General.Simulator;
import General.State;
import General.EventQueue;
import View.View;

public class RunSim {
	static Simulator simulator;
	private State state;
	private View view;
	private EventQueue eventQueue;
	public static void main(String[] args) {
		simulator = new Simulator(new State(), new EventQueue(), new View());
		simulator.run();
    }
}
