package General;

/**
 * Event klassen representerar en handelse i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandström.
 */
public abstract class Event {

    protected State state;
    protected EventQueue eventQueue;
    protected double executeTime;

    /**
     * Skapar en ny Event handelse.
     *
     * @param state       Tillstandet för simuleringen.
     * @param eventQueue  EventQueue som hanterar handelser.
     * @param executeTime Tidpunkten da handelsen ska intraffa.
     */
    public Event(State state, EventQueue eventQueue, double executeTime) {
        this.state = state;
        this.executeTime = executeTime;
        this.eventQueue = eventQueue;
    }

    /**
     * Abstrakt metod som underklasser ska implementera för att utföra specifika uppgifter.
     */
    public abstract void execute();

    /**
     * Returnerar tiden da handelsen ska intraffa.
     *
     * @return ExecuteTime för handelsen.
     */
    public double returnExecuteTime() {
        //Returnerar eventets executeTime
        return this.executeTime;
    }
}
