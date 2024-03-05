package View;

<<<<<<< Updated upstream
public class View {
	
	//Ska ha metoderna:
	//writeBeginning, writeState, writeResult
=======
import State.CheckoutQueue;
import State.StoreState;
import General.GeneralView;

import java.util.Observable;

import General.EventQueue;
import Helper_Functions.K;

public class View extends GeneralView {

	private StoreState storeState;

    public View(StoreState storeState) {
        this.storeState = storeState;
        // Add View as an observer of StoreState
        this.storeState.addObserver(this);	
    }
    
    public void update(java.util.Observable o, Object arg) {
        // Call printStoreStats method whenever an update notification is received
        printStoreStats();
    }


	
	public void printBeginStore() {
		String openingMessage = 
				"PARAMETRAR\n"
				+ "==========\n"
				+ "Antal kassor, N..........: " + storeState.getMaxCheckoutCapacity() + "\n"
				+ "Max som ryms, M..........: " + storeState.getMaxCapacity() + "\n"
				+ "Ankomshastighet, lambda..: " + storeState.getLambda() + "\n"
				+ "Plocktider, [P_min..Pmax]: " + storeState.getPickLow() + storeState.getPickHigh() + "\n"
				+ "Betaltider, [K_min..Kmax]: " + storeState.getPayLow() + storeState.getPayHigh() + "\n"
				+ "Frö, f...................: " + storeState.getSeed() + "\n\n"
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
>>>>>>> Stashed changes
	
}
