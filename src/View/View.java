package View;

import State.CheckoutQueue;
import State.StoreState;
import General.EventQueue;
import Helper_Functions.K;
import java.util.Observable;

public class View extends Observable {
	private EventQueue eventQueue;
	// För printBeginStore()
	private int antalKassor;
	private int maxSomRyms;
	private double ankomsttid;
	private double plocktid;
	private double betaltid;
	private long frö;
	// För printStoreStats()
	private int tid;
	private String currentEventName;
	private int kund;
	private String isOpen;
	private int led;
	private double ledT;
	private int I;
	private int dollar;
	private int sadSmiley;
	private int köat;
	private double köT;
	private int köar;
	private CheckoutQueue kassakö;
	// För printEndStore()
	private int totaltAntalKunder;
	private int kunderSomKomIn;
	private int missadeKunder;
	// antalKassor
	
	
	public View (StoreState storeState) {
		kassakö = storeState.getCheckoutQueue();
		isOpen = storeState.getOpenStatus() ? "Ö" : "S";
		antalKassor = 2;
		maxSomRyms = K.M;
		kund = storeState.getCustomersInStore();
		led = 0;
		I = 0;
		dollar = 0;
		sadSmiley = 0;
		köat = storeState.getCustomersHasCheckedOut();
		plocktid = 0;
		betaltid = 0;
		köT = 0;
		ledT = 0;
		ankomsttid = storeState.getArrivalTime();
		frö = 13;// ? storeState.getSeed();
	}

	public void updateCurrentEvent(String eventName) {
		currentEventName = eventName;
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
	public void printStoreStats() {
		String updatingMessage =
				  tid + " "
				+ currentEventName + " " 
				+ kund + " " 
				+ isOpen + " " 
				+ led + " " 
				+ ledT + " " 
				+ I + " " 
				+ dollar + " " 
				+ sadSmiley + " " 
				+ köat + " " 
				+ köT + " " 
				+ köar + " " 
				+ kassakö + "\n\n";
		System.out.print(updatingMessage);
    }
	public void printCloseStore() {
        String closingMessage = 
        		"RESULTAT\n"
        		+ "========\n"
        		+ "1) Av 10 kunder handlade 8 medan 2 missades.\n"
        		+ "2) Total tid 2 kassor varit lediga: 6,11 te.\n"
        		+ "Genomsnittlig ledig kassatid: 3,06 te (dvs 23,03% av tiden från öppning tills sista kunden\n"
        		+ "betalat).\n"
        		+ "3) Total tid 5 kunder tvingats köa: 13,60 te.\n"
        		+ "Genomsnittlig kötid: 2,72 te.\n";
        System.out.print(closingMessage);
    }
	
}
