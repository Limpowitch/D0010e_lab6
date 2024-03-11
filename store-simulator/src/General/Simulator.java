package General;

/**
 * Simulator klassen ar ansvarig for att kora simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class Simulator {
    protected State state;
    protected EventQueue eventQueue;

    /**
     * Skapar en ny Simulator.
     *
     * @param state      Tillstandet for simuleringen.
     * @param eventQueue EventQueue som innehaller handelserna i simuleringen.
     */
    public Simulator(State state, EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        this.state = state;
    }

    /**
     * Kor simuleringen.
     * <p>
     * Simulator hamtar och kor handelser fran EventQueue tills simuleringen
     * avslutas.
     */
    public void run() {
        //while !state.isStopped
        while (state.isRunning()) {
            eventQueue.get(0).execute();
            eventQueue.remove(0);

        }
        //Plocka ut 0:e Event i Eventqueue, kor execute
        //Ta bort 0:e Event i EventQueue
    }

}




