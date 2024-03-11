package Event;

import View.View;
import General.Event;
import General.EventQueue;
import General.State;

/**
 * EndEvent klassen representerar en handelse som avslutar simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class EndEvent extends Event {
    private View view;
    private int printall;

    /**
     * Skapar en ny EndEvent handeles.
     *
     * @param state       Tillstand for simuleringen.
     * @param executeTime Tidpunkten da handelsen ska intraffa.
     * @param eventQueue  EventQueue som hanterar handelser.
     * @param view        Vyn som anvands for att visa meddelanden.
     * @param printall    Anger om all information ska skrivas ut.
     */
    public EndEvent(State state, double executeTime, EventQueue eventQueue, View view, int printall) {
        super(state, eventQueue, executeTime);
        this.view = view;
        this.printall = printall;
    }

    /**
     * Utfor handelsen.
     * <p>
     * Stoppar simuleringen och visar ett meddelande om att butiken har stangt.
     */
    public void execute() {
        //Uppdatera StoreState med relevant information
        state.stopSim();

        if (printall == 1) {
            view.printCloseStore();

        }


    }

}