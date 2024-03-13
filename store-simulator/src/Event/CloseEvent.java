package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

/**
 * CloseEvent klassen representerar en handelse for eventcykelns slut.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class CloseEvent extends Event {

    private int printall;

    /**
     * Skapar en ny CloseEvent handelse.
     *
     * @param state       Tillstandet for simuleringen.
     * @param eventQueue  Tidpunkten da handelsen ska intraffa.
     * @param executeTime EventQueue som hanterar handelser.
     * @param printall    Om all information ska skrivas ut.
     */
    public CloseEvent(State state, EventQueue eventQueue, double executeTime, int printall) {
        super(state, eventQueue, executeTime);
        this.printall = printall;
    }

    /**
     * Utfor handelsen.
     * <p>
     * Uppdaterar klockan och uppdaterar den senaste handelsen.
     * Meddelar observatorer om handelsen.
     */
    public void execute() {
		state.update(this);

		((StoreState)state).setOpenStatus("S");
		int customer = -1;
		//Uppdatera StoreState med relevant information
		((StoreState)state).updateLatestEventCustomer(customer);
		((StoreState)state).updateLatestEvent("Close");
		((StoreState)state).registersempty();
		
		if (printall == 1) {
			state.notifyObserver();
		}

	}

}
