package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.StoreState;
import View.View;

/**
 * StartEvent klassen representerar en handelse som startar simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class StartEvent extends Event {
    private View view;
    private int printall;

    /**
     * Skapar en ny StartEvent handelse.
     *
     * @param state       Tillstandet for simuleringen.
     * @param executeTime Tidpunkten da handelsen ska intraffa.
     * @param eventQueue  EventQueue som hanterar handelser.
     * @param view        Vyn som anvands for att visa meddelanden.
     */
    public StartEvent(State state, double executeTime, EventQueue eventQueue, View view, int printall) {
        super(state, eventQueue, executeTime);
        this.view = view;
        this.printall = printall;
        // TODO Auto-generated constructor stub
    }

    /**
     * Utfor handelsen.
     * <p>
     * Oppnar butiken, lagger till en ny ArrivalEvent till kon, och visar ett
     * meddelande att simuleringen har startat.
     */
    public void execute() {


        ((StoreState) state).setOpenStatus("Ö");//Oppna affaren i StoreState

        //Lagg till ArrivalEvent i Queue
        eventQueue.addToQueue(new ArrivalEvent((StoreState) state, eventQueue, ((StoreState) state).getArrivalTime(), ((StoreState) state).generatedCustomer(), printall));
        //ArrivalEvent behover state, arrivalTime

        if (printall == 1) {
            view.printBeginStore();

        }


    }

}
