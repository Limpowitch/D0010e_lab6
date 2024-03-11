package State;

import General.State;
import State.PickTime;
import State.PayTime;

/**
 * StoreState klassen representerar tillstandet for butiken i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class StoreState extends State {
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private String isOpen = "S";
    private int maxCapacity;
    private int customersInStore = 0;
    private int highestCustomerID = -1;
    private int missedCustomers = 0;
    private int paidCustomers = 0;
    private CheckoutQueue checkoutQueue;
    private int totalCustomersBeenInQueue = 0;
    private int maxCheckoutCapacity;
    private int customersHasCheckedOut;
    private String latestEventName;
    private int currentInCheckout;
    private int latestEventCustomer;
    private int totalCustomers;
    private long seed;
    private double lambda;
    private double pickLow;
    private double pickHigh;
    private double payLow;
    private double payHigh;
    private double populatedQueueTime;
    private double emptyqueueTime;
    protected int printall;

    /**
     * Skapar en ny StoreState instans.
     *
     * @param seed                Seed for slumpgeneratorn.
     * @param lambda              Ankomstfrekvens variabel.
     * @param maxCapacity         Max antal kunder i butiken.
     * @param maxCheckoutCapacity Max antal kassor.
     * @param pickLow             Lagsta plocktid.
     * @param pickHigh            Hogsta plocktid.
     * @param payLow              Lagsta betalningstid.
     * @param payHigh             Hogsta betalningstid.
     */
    public StoreState(int seed, double lambda, int maxCapacity, int maxCheckoutCapacity, double pickLow, double pickHigh, double payLow, double payHigh) {
        super();
        this.lambda = lambda;
        this.seed = seed;
        this.pickLow = pickLow;
        this.pickHigh = pickHigh;
        this.payLow = payLow;
        this.payHigh = payHigh;
        this.maxCapacity = maxCapacity;
        this.latestEventName = "Arrival";
        this.maxCheckoutCapacity = maxCheckoutCapacity;
        checkoutQueue = new CheckoutQueue();
        arrivalTime = new ArrivalTime(lambda, seed);
        pickTime = new PickTime(pickLow, pickHigh, seed);
        payTime = new PayTime(payLow, payHigh, seed);
    }

    /**
     * Hamtar den genererade ankomst tiden for nasta kund.
     *
     * @return Nasta kunds ankomsttid
     */
    public double getArrivalTime() {
        return arrivalTime.generateArrivalTime(returnCurrentTime());
    }

    public void updatePrintAll(int i) {
        this.printall = i;
    }

    /**
     * Hamtar den genererade plocktiden for en kund.
     *
     * @return Nasta kunds plocktid
     */
    public double getPickTime() {
        return pickTime.generatePickTime(returnCurrentTime());
    }

    /**
     * Hamtar den genererade betalningstiden for en kund.
     *
     * @return Nasta kunds betalningstid
     */
    public double getPayTime() {
        return payTime.generatePayTime(returnCurrentTime());
    }

    /**
     * Hamtar ankomstfrekvensne (lambda).
     *
     * @return Ankomstfrekvensen
     */
    public double getLambda() {
        return this.lambda;
    }

    /**
     * Hamtar den lagsta mojliga plocktiden.
     *
     * @return Lagsta plocktid
     */
    public double getPickLow() {
        return this.pickLow;
    }

    /**
     * Hamtar den hogsta mojliga plocktiden.
     *
     * @return Hogsta plocktid
     */
    public double getPickHigh() {
        return this.pickHigh;
    }

    /**
     * Hamtar den lagsta mojliga betalningstiden.
     *
     * @return Lagsta betalningstid
     */
    public double getPayLow() {
        return this.payLow;
    }

    /**
     * Hamtar den hogsta mojliga betalningstiden.
     *
     * @return Hogsta betalningstid
     */
    public double getPayHigh() {
        return this.payHigh;
    }

    /**
     * Hamtar antalet missade kunder.
     *
     * @return Antal missade kunder
     */
    public int getMissedCustomers() {
        return this.missedCustomers;
    }

    /**
     * Hamtar kund ID for den senaste handelsen, om det inte ar stangning. Returnerar null annars.
     *
     * @return Kund ID for den senaste handelsen, eller null om handelsen ar stangning
     */
    public int getLatestEventCustomer() {
        if (this.getLatestEvent() == "close") {
            return (Integer) null;
        }
        return this.latestEventCustomer;
    }

    /**
     * Hamtar antalet kunder i kassan just nu.
     *
     * @return Antal kunder i kassan
     */
    public int getCurrentInCheckout() {
        return this.currentInCheckout;
    }

    /**
     * Hamtar butikens oppetstatus (0 = stangt, 1 = oppet).
     *
     * @return Butikens oppetstatus
     */
    public String getOpenStatus() {
        return this.isOpen;
    }

    /**
     * Hamtar det totala antalet kunder som har varit i kon.
     *
     * @return Totalt antal kunder som varit i kon
     */
    public int getTotalCustomersBeenInQueue() {
        return this.totalCustomersBeenInQueue;
    }

    /**
     * Hamtar seed vardet for slumpgeneratorn.
     *
     * @return Seed vardet
     */
    public long getSeed() {
        return this.seed;
    }

    /**
     * Hamtar antalet kunder i butiken just nu.
     *
     * @return Antal kunder i butiken
     */
    public int getCustomersInStore() {
        return this.customersInStore;
    }

    /**
     * Hamtar butikens maxkapacitet.
     *
     * @return Maxkapaciteten
     */
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Hamtar antalet  kunder som betalat.
     *
     * @return Antal kunder som betalat
     */
    public int getPaidCustomers() {
        return this.paidCustomers;
    }

    /**
     * Hamtar max antal kassakapacitet.
     *
     * @return Kassans maxkapacitet
     */
    public int getMaxCheckoutCapacity() {
        return this.maxCheckoutCapacity;
    }

    /**
     * Hamtar kassakon.
     *
     * @return Kassakon
     */
    public CheckoutQueue getCheckoutQueue() {
        return this.checkoutQueue;
    }

    /**
     * Hamtar namnet pa den senaste handelsen som simulerats.
     *
     * @return Handelsens namn, t.ex, "Arrival" FANNS DET FLERA? KAN INTE HITTA
     */
    public String getLatestEvent() {
        return this.latestEventName;
    }

    /**
     * Hamtar det totala antalet kunder som har skapats i simuleringen.
     *
     * @return Antalet kunder
     */
    public int getTotalCustomers() {
        return this.totalCustomers;
    }

    /**
     * Okar antalet missade kunder med 1.
     */
    public void updateMissedCustomers() {
        this.missedCustomers++;
    }

    /**
     * Okar antalet kunder som betalat med 1.
     */
    public void updatePaidCustomers() {
        this.paidCustomers++;
    }

    /**
     * Okar det totala antalet kunder som har varit i kon med 1.
     */
    public void updateBeenInQueue() {
        this.totalCustomersBeenInQueue++;
    }

    /**
     * Skapar en ny kund med ett nytt ID och returnerar den.
     *
     * @return En ny kundinstans
     */
    public Customer generatedCustomer() {
        int highestCustomerIDHolder = this.highestCustomerID;
        this.highestCustomerID = this.highestCustomerID + 1;
        return new Customer(highestCustomerIDHolder + 1);
    }

    /**
     * Satter butikens oppetstatus.
     *
     * @param string 0 = stangt, 1 = oppet
     */
    public void setOpenStatus(String string) {
        this.isOpen = string;
    }

    /**
     * Uppdaterar senaste handelsens namn med namnet av den nyaste handelsen.
     *
     * @param string Namnet pa handelsen
     */
    public void updateLatestEvent(String string) {
        this.latestEventName = string;
    }

    /**
     * Uppdaterar kund ID for den senaste handelsen.
     *
     * @param customer Kund ID
     */
    public void updateLatestEventCustomer(int customer) {
        latestEventCustomer = customer;
    }

    /**
     * Okar det totala antalet kunder i simuleringen med 1.
     */
    public void updateTotalCustomers() {
        this.totalCustomers++;
    }

    /**
     * Uppdaterar antalet kunder i butiken.
     *
     * @param increase true = oka antalet, false = minska antalet
     */
    public void updateStoreCount(boolean increase) {
        if (increase) {
            this.customersInStore++;
        } else {
            this.customersInStore--;
        }
    }

    /**
     * Uppdaterar tiderna baserat pa om kassan ar tom eller inte.
     */
    public void registersempty() {
        //State checktime = new State();

        if (checkoutQueue.queuetime() == false)  // checks if the queue has people in it and updates time spent in it.
        {
            if (populatedQueueTime == 0.0) {
                populatedQueueTime = super.returnCurrentTime() - super.returnPreviousTime();

            } else {
                //double timetemp =  super.returnCurrentTime() - populatedQueueTime;
                //populatedQueueTime += timetemp; 
                populatedQueueTime = populatedQueueTime + (super.returnCurrentTime() - super.returnPreviousTime());
            }
        } else // if the queue is empty, another timer is started to measure queued time spent in it.
        {
            if (emptyqueueTime == 0.0) {
                emptyqueueTime = super.returnCurrentTime() - super.returnPreviousTime();
            } else {
                //double timetemp = super.returnCurrentTime() - emptyqueueTime;
                //emptyqueueTime += timetemp;
                emptyqueueTime = emptyqueueTime + (super.returnCurrentTime() - super.returnPreviousTime());
            }

        }

    }

    /**
     * Hamtar ackumulerad tid med kunder i kon.
     *
     * @return Tiden.
     */
    public double getPopulatedQueueTime() {
        return populatedQueueTime;
    }

    /**
     * Hamtar ackumulerad tid utan kunder i kon.
     *
     * @return Tiden.
     */
    public double getEmptyQueueTime() {

        return emptyqueueTime;
    }

    /**
     * Uppdaterar antalet kunder i kassan.
     *
     * @param b true = oka antalet, false = minska antalet
     */
    public void updateCurrentInCheckout(boolean b) {
        if (b) {
            this.currentInCheckout++;
        } else {
            this.currentInCheckout--;
        }
    }
}
