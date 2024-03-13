package Event;

import General.Event;
import General.EventQueue;
import General.State;
import State.Customer;
import State.StoreState;

/**
 * PayEvent klassen representerar en händelse där en kund betalar for sina
 * varor.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class PayEvent extends Event {
    protected Customer customer;
    private int printall;


    /**
     * Skapar en ny PayEvent händelse.
     *
     * @param state       Tillstandet for simuleringen.
     * @param executeTime Tidpunkten da händelsen ska inträffa.
     * @param eventQueue  EventQueue som hanterar händelser.
     * @param customer    Kunden som betalar.
     * @param printall    Om printall är 1 sa skrivs all information ut.
     */
    public PayEvent(State state, double executeTime, EventQueue eventQueue, Customer customer, int printall) {
        super(state, eventQueue, executeTime);
        this.customer = customer;
        this.printall = printall;
    }

    /**
     * Utfor händelsen.
     * <p>
     * Uppdaterar klockan, minskar antalet kunder i butiken, okar antalet kunder som
     * har betalat, och hanterar kon vid kassan. Om det finns fler kunder i kassan
     * läggs en ny PayEvent till kon. Uppdaterar den senaste händelsen och meddelar
     * observatorer om händelsen.
     */
    public void execute() {
		state.update(this);
		((StoreState)state).updateRealTime();
		//Uppdatera StoreState med relevant information
		((StoreState)state).registersempty();

		((StoreState)state).updateStoreCount(false); // minskar antalet i affären med 1
		
		if (((StoreState)state).getCheckoutQueue().getSize() > 0) {
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pay");
			if (printall == 1) {
				state.notifyObserver();
			}
			eventQueue.addToQueue(new PayEvent((StoreState)state, ((StoreState)state).getPayTime(), eventQueue, ((StoreState)state).getCheckoutQueue().getFirstCustomer(), printall));
		} else {
			((StoreState)state).updateCurrentInCheckout(false);
			((StoreState)state).updateLatestEventCustomer(customer.customerID);
			((StoreState)state).updateLatestEvent("Pay");
			if (printall == 1) {
				state.notifyObserver();
			}
		}
		((StoreState)state).updatePaidCustomers(); // ökar antalet kunder som har betalat med 1
	}
}
