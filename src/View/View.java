package View;

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
	            storeState.returnCurrentTime() + " "
	            + storeState.getLatestEvent() + " "
	            + storeState.getLatestEventCustomer() + " "
	            + storeState.getOpenStatus() + " "
	            + storeState.getCurrentCheckoutCapacity() + " "
	            + storeState.getEmptyQueueTime() + " " // Assuming there's a method named getLedigTid in StoreState
	            + storeState.getCustomersInStore() + " "
	            + storeState.getCustomersHasCheckedOut() + " "
	            + storeState.getMissedCustomers() + " "
	            + storeState.getTotalCustomersBeenInQueue() + " "
	            + storeState.getPopulatedQueueTime() + " " // Assuming there's a method named getKötid in StoreState
	            + storeState.getCheckoutQueue().getSize() + " "
	            + storeState.getCheckoutQueue().getCurrentQueue() + "\n\n"; // Assuming there's a method named getKasseStringFormat in StoreState
	    System.out.print(updatingMessage);
	}
	
	public void printCloseStore() {
	    String closingMessage =
	            "RESULTAT\n"
	            + "========\n"
	            + "1) Av " + storeState.getTotalCustomers() + " kunder handlade " + storeState.getCustomersHasCheckedOut() + " medan " + storeState.getMissedCustomers() + " missades.\n"
	            + "2) Total tid " + storeState.getCurrentCheckoutCapacity() + " kassor varit lediga: " + storeState.getEmptyQueueTime() + " te.\n"
	            + "Genomsnittlig ledig kassatid: " + storeState.returnCurrentTime()/storeState.getTotalCustomersBeenInQueue() + " te"
	            + "3) Total tid " + storeState.getTotalCustomersBeenInQueue() + " kunder tvingats köa: " + storeState.getPopulatedQueueTime() + " te.\n"
	            + "Genomsnittlig kötid: " + storeState.getPopulatedQueueTime()/storeState.getTotalCustomersBeenInQueue()+ " te.\n";
	    System.out.print(closingMessage);
	}
	
}
