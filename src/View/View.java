package View;

import State.CheckoutQueue;
import State.StoreState;
import General.GeneralView;

import java.util.Observable;

import General.EventQueue;
//import Helper_Functions.K;

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
				+ "Plocktider, [P_min..Pmax]: " + storeState.getPickLow() + " " +  storeState.getPickHigh() + "\n"
				+ "Betaltider, [K_min..Kmax]: " + storeState.getPayLow() + " " + storeState.getPayHigh() + "\n"
				+ "Frö, f...................: " + storeState.getSeed() + "\n\n"
				+ "FÖRLOPP\n"
				+ "=======\n"
				+ "Tid  Händelse Kund ? led ledT I  $ :-( köat köT köar [Kassakö..]\n"
				+ "0.00    Start\n";
		System.out.print(openingMessage);
	}
	public void printStoreStats() {
	    String updatingMessage =
	    		String.format("%.4s ", storeState.returnCurrentTime()) + " "
	            + String.format("%7s", storeState.getLatestEvent()) + " "
	            + String.format("%4d", storeState.getLatestEventCustomer()) + " "
	            + storeState.getOpenStatus() + " "
	            + String.format("%3d", (storeState.getMaxCheckoutCapacity() - storeState.getCurrentInCheckout())) + " "
	            + String.format("%.4s", storeState.getEmptyQueueTime()) + " " // Assuming there's a method named getLedigTid in StoreState
	            + storeState.getCustomersInStore() + " "
	            + String.format("%2d", storeState.getPaidCustomers()) + " "
	            + String.format("%3d", storeState.getMissedCustomers()) + " "
	            + String.format("%4d", storeState.getTotalCustomersBeenInQueue()) + " "
	            + String.format("%.4s", storeState.getPopulatedQueueTime()) + " " // Assuming there's a method named getKötid in StoreState
	            + String.format("%4d", storeState.getCheckoutQueue().getSize()) + " "
	            + storeState.getCheckoutQueue().getCurrentQueue() + "\n\n"; // Assuming there's a method named getKasseStringFormat in StoreState
	    System.out.print(updatingMessage);
	}
	
	public void printCloseStore() {
	    String closingMessage =
	    		"999       End\n"
	            + "RESULTAT\n"
	            + "========\n"
	            + "1) Av " + storeState.getTotalCustomers() + " kunder handlade " + storeState.getPaidCustomers() + " medan " + storeState.getMissedCustomers() + " missades.\n"
	            + "2) Total tid " + (storeState.getMaxCheckoutCapacity() - storeState.getCurrentInCheckout()) + " kassor varit lediga: " + String.format("%.4s", storeState.getEmptyQueueTime()) + " te. "
	            + "Genomsnittlig ledig kassatid: " + String.format("%.4s", storeState.getEmptyQueueTime()/storeState.getMaxCheckoutCapacity()) + " te\n"
	            + "3) Total tid " + storeState.getTotalCustomersBeenInQueue() + " kunder tvingats köa: " + String.format("%.4s", storeState.getPopulatedQueueTime()) + " te.\n"
	            + "Genomsnittlig kötid: " + String.format("%.4s", storeState.getPopulatedQueueTime()/storeState.getTotalCustomersBeenInQueue())+ " te.\n";
	    System.out.print(closingMessage);
	}
	
}
