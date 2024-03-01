package View;

import State.CheckoutQueue;
import State.StoreState;
import General.EventQueue;
import java.util.Observable;

public class View extends Observable {
	public View() {
	}
	// En idé är att Simulator observerar storestate (eller whatever)
	// och när den "upptäcker ändring" anropar den denna metod i vy.
	// Vi tar det på måndag eller över dc.
	private EventQueue eventQueue;
	private CheckoutQueue kassakö;
	private String händelse;
	private String isOpen;
	private int antalKassor;
	private int maxSomRyms;
	private int kund;
	private int led;
	private int I;
	private int dollar;
	private int sadSmiley;
	private int köat;
	private int köra;
	private double plocktid;
	private double betaltid;
	private double köT;
	private double ledTid;
	private double tid;
	private double ankomsttid;
	private long frö;
	public View (StoreState storeState, EventQueue eventQueue) {
		kassakö = storeState.getCheckoutQueue();
		händelse = this.getEventName();
		isOpen = storeState.getOpenStatus()? "Ö" : "S";
		antalKassor = 0;
		maxSomRyms = storeState.getMaxCapacity();
		kund = storeState.getCustomersInStore();
		led = 0;
		I = 0;
		dollar = 0;
		sadSmiley = 0;
		köat = storeState.getCustomersHasCheckedOut();
		köra = 0;
		plocktid = 0;
		betaltid = 0;
		köT = 0;
		ledTid = 0;
		// tid = currentTime(); Vart finns currentTime?
		ankomsttid = storeState.getArrivalTime();
		frö = storeState.getSeed();
	}

	public String getEventName() {
		return eventQueue.get(0).getClass().getSimpleName();
	}
	
	public void printBeginStore() {
		String openingMessage = 
				"PARAMETRAR\n"
				+ "==========\n"
				+ "Antal kassor, N..........: " + antalKassor + "\n"
				+ "Max som ryms, M..........: " + maxSomRyms + "\n"
				+ "Ankomshastighet, lambda..: " + ankomsttid + "\n"
				+ "Plocktider, [P_min..Pmax]: " + plocktid + "\n"
				+ "Betaltider, [K_min..Kmax]: " + betaltid + "\n"
				+ "Frö, f...................: " + frö + "\n\n"
				+ "FÖRLOPP\n"
				+ "=======\n"
				+ "Tid Händelse Kund ? led ledT I $ :-( köat köT köar [Kassakö..]\n";
		System.out.print(openingMessage);
	}
	public void printStoreState() {
		
    }
	public void printEndStore() {
        
    }
	
}
