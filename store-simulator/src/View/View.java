package View;

import State.CheckoutQueue;
import State.StoreState;
import General.GeneralView;

import java.util.Observable;

import General.EventQueue;
//import Helper_Functions.K;

/**
 * Klassen View ansvarar for att visualisera informationen fran simuleringen.
 * Den implementerar GeneralView och anvander sig av Observer monstret for att lyssna pa uppdateringar fran `StoreState`.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 * @see State.StoreState
 * @see General.GeneralView
 * @see java.util.Observable
 */
public class View extends GeneralView {

    private StoreState storeState;

    /**
     * Skapar en ny instans av klassen View.
     *
     * @param storeState Simuleringsmodellen (`StoreState`) som ska observeras.
     */
    public View(StoreState storeState) {
        this.storeState = storeState;
        // Add View as an observer of StoreState
        this.storeState.addObserver(this);
    }

    /**
     * Implementerar `update`-metoden fran `Observer`-granssnittet.
     * Kallas nar en uppdatering sker i `StoreState`.
     *
     * @param o   Den observerade kallan (i detta fall `StoreState`)
     * @param arg Objektet som skickas med uppdateringen (i detta fall irrelevant)
     */
    public void update(java.util.Observable o, Object arg) {
        // Call printStoreStats method whenever an update notification is received
        printStoreStats();
    }

    /**
     * Skriver ut parametrarna for simuleringsmodellen.
     */
    public void printBeginStore() {
        String openingMessage =
                "PARAMETRAR\n"
                        + "==========\n"
                        + "Antal kassor, N..........: " + storeState.getMaxCheckoutCapacity() + "\n"
                        + "Max som ryms, M..........: " + storeState.getMaxCapacity() + "\n"
                        + "Ankomshastighet, lambda..: " + storeState.getLambda() + "\n"
                        + "Plocktider, [P_min..Pmax]: " + storeState.getPickLow() + " " + storeState.getPickHigh() + "\n"
                        + "Betaltider, [K_min..Kmax]: " + storeState.getPayLow() + " " + storeState.getPayHigh() + "\n"
                        + "Fro, f...................: " + storeState.getSeed() + "\n\n"
                        + "FORLOPP\n"
                        + "=======\n"
                        + "Tid Handelse Kund ? led ledT I  $ :-( koat  koT koar [Kassako..]\n"
                        + "0.00   Start\n";
        System.out.print(openingMessage);
    }

    /**
     * Skriver ut uppdaterad information om simuleringstillstandet.
     */
    public void printStoreStats() {
        String updatingMessage =
                String.format("%.2f", storeState.returnCurrentTime()) + " "
                        + String.format("%7s", storeState.getLatestEvent()) + " "
                        + String.format("%4d", storeState.getLatestEventCustomer()) + " "
                        + storeState.getOpenStatus() + " "
                        + String.format("%3d", (storeState.getMaxCheckoutCapacity() - storeState.getCurrentInCheckout())) + " "
                        + String.format("%.2f", storeState.getEmptyQueueTime()) + " " // Assuming there's a method named getLedigTid in StoreState
                        + storeState.getCustomersInStore() + " "
                        + String.format("%2d", storeState.getPaidCustomers()) + " "
                        + String.format("%3d", storeState.getMissedCustomers()) + " "
                        + String.format("%4d", storeState.getTotalCustomersBeenInQueue()) + " "
                        + String.format("%.2f", storeState.getPopulatedQueueTime()) + " " // Assuming there's a method named getKotid in StoreState
                        + String.format("%4d", storeState.getCheckoutQueue().getSize()) + " "
                        + storeState.getCheckoutQueue().getCurrentQueue() + "\n\n"; // Assuming there's a method named getKasseStringFormat in StoreState
        System.out.print(updatingMessage);
    }

    /**
     * Skriver ut slutresultatet av simuleringsmodellen.
     */
    public void printCloseStore() {
        String closingMessage =
                "999      End\n"
                        + "RESULTAT\n"
                        + "========\n"
                        + "1) Av " + storeState.getTotalCustomers() + " kunder handlade " + storeState.getPaidCustomers() + " medan " + storeState.getMissedCustomers() + " missades.\n"
                        + "2) Total tid " + (storeState.getMaxCheckoutCapacity() - storeState.getCurrentInCheckout()) + " kassor varit lediga: " + String.format("%.2f", storeState.getEmptyQueueTime()) + " te. "
                        + "Genomsnittlig ledig kassatid: " + String.format("%.4s", storeState.getEmptyQueueTime() / storeState.getMaxCheckoutCapacity()) + " te\n"
                        + "3) Total tid " + storeState.getTotalCustomersBeenInQueue() + " kunder tvingats koa: " + String.format("%.2f", storeState.getPopulatedQueueTime()) + " te.\n"
                        + "Genomsnittlig kotid: " + String.format("%.4s", storeState.getPopulatedQueueTime() / storeState.getTotalCustomersBeenInQueue()) + " te.\n";
        System.out.print(closingMessage);
    }

}
