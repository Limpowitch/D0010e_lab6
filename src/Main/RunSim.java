package Main;

public class RunSim {
<<<<<<< Updated upstream
=======
	/*private Simulator simulator;
	
	public RunSim(Simulator simulator) {
		this.simulator = simulator;
	}*/
	public static void main(String[] args) {
		// Simulator 1 //
		State state1 = new State();
		// StoreState(lambda, seed, maxCapacity, arrivalTime, pickTime, payTime, customersInStore, highest)
		StoreState storeState1 = new StoreState(0.5, K.SEED, 0);
		View view1 = new View(storeState1);
		EventQueue eventQueue1 = new EventQueue();
		Simulator simulator = new Simulator(state1, eventQueue1);
>>>>>>> Stashed changes

}
