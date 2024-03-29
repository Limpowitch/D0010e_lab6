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
import java.util.Scanner;


/**
 * RunSim klassen ansvarar for att skapa och starta simulationen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class RunSim {
    private StoreState storeState; // Declare a field to hold the StoreState object
	
    /**
     * Main metoden tar emot anvandarinput och skapar en ny instans av RunSim, och skapar simulatorn baserat pa anvandarinputen.
     *
     * @param args
     */
    public static void main(String[] args) {
	
		
		Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an example to run (1 or 2):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                RunSim runSim1 = new RunSim(1234, 1, 5, 2, 0.5, 1, 2, 3, 10, 1); // ex1
                break;
            case 2:
                RunSim runSim2 = new RunSim(13, 3, 7, 2, 0.6, 0.9, 0.35, 0.6, 8, 1); // ex3
                break;
            default:
                System.out.println("Error: Invalid choice.");
                break;
        }
		
		
	}
	
    /**
     * Skapar en ny instans av RunSim.
     *
     * @param seed
     * @param l
     * @param maxCapacity
     * @param maxCheckoutCapacity
     * @param pickLow
     * @param pickHigh
     * @param payLow
     * @param payHigh
     * @param closeTime
     * @param printall
     */
    public RunSim(int seed, double l, int maxCapacity, int maxCheckoutCapacity, double pickLow, double pickHigh, double payLow, double payHigh, double closeTime, int printall) {
		//State state = new State();
		this.storeState = new StoreState
				(seed, 
				 l, 
				 maxCapacity, 
				 maxCheckoutCapacity, 
				 pickLow, 
				 pickHigh, 
				 payLow, 
				 payHigh);
		EventQueue eventQueue = new EventQueue();
		View view = new View(storeState);
		eventQueue.add(new StartEvent(storeState, 0, eventQueue, view, printall));
		eventQueue.add(new CloseEvent(storeState, eventQueue, closeTime, printall));
		eventQueue.add(new EndEvent(storeState, 999, eventQueue, view, printall));
		Simulator simulator = new Simulator(storeState, eventQueue);
		simulator.run();
	}
	
	 public StoreState getStoreState() {
	        return this.storeState;
	    }
}
