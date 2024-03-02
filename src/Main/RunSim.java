package Main;

import General.Simulator;
import General.State;
import General.EventQueue;
import Event.StartEvent;
import Event.EndEvent;
import View.View;

public class RunSim {
	static Simulator simulator;
	
	public RunSim() {
		
	}
	public static void main(String[] args) {
		simulator = new Simulator(new State(), new EventQueue(), new View());
		simulator.initializeEventQueue(new StartEvent(), new EndEvent());
    }
}
