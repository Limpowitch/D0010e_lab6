package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

/**
 * PickEvent klassen representerar en handelse dar en kund har plockat sina
 * varor och ska ga till kassan.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class PickEvent extends Event {
    protected Customer customer;
    private int printall;

    /**
     * Skapar en ny PickEvent handelse.
     *
     * @param state       Tillstandet for simuleringen.
     * @param executeTime Tidpunkten da handelsen ska intraffa.
     * @param eventQueue  EventQueue som hanterar handelser.
     * @param customer    Kunden som har plockat sina varor.
     * @param printall    Om printall ar 1 skrivs handelsen ut.
     */
    public PickEvent(State state, double executeTime, EventQueue eventQueue, Customer customer, int printall) {
        super(state, eventQueue, executeTime);
        this.customer = customer;
        this.printall = printall;
    }

    /**
     * Utfor handelsen.
     * <p>
     * Uppdaterar klockan och kontrollerar om det finns lediga kassor. Om det finns
     * lediga kassor lagger till en ny PayEvent for kunden, annars placeras kunden i
     * kon till kassan. Uppdaterar den senaste handelsen och meddelar observatorer
     * om handelsen.
     */
    public void execute() {
		state.update(this);
		((StoreState)state).updateRealTime();
		//Om antalet kunder i kön inte är max capacity
		//TODO: unfucka den här 
		if (((StoreState)state).getCurrentInCheckout() != ((StoreState)state).getMaxCheckoutCapacity()) {
			//TODO: Lägg till relevanta storestate updates
			//Lägg till nytt payEvent
			((StoreState)state).registersempty();
			((StoreState)state).updateCurrentInCheckout(true);
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, customer, printall));
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pick");
			if (printall == 1) {
				state.notifyObserver();
			}
		//Om antalet kunder är detsamma som max capacity
		} else {
			//Lägg till kund i kö
			((StoreState)state).registersempty();
			((StoreState)state).updateBeenInQueue(); //ökar antalet som har varit i kön med 1
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pick");
			if (printall == 1) {
				state.notifyObserver();
			}
			((StoreState)state).getCheckoutQueue().addCustomer(customer); // lägger in en kund i kö
		}
	}
}
