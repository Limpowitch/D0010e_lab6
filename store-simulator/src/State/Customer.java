package State;

/**
 * En customer ar bara ett customerID for att kunna identifiera vilken kund som "utfor" vilket event.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class Customer {
    public int customerID;

    /**
     * Skapa en customer med ett customerID
     *
     * @param customerID
     */
    public Customer(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Returnera customerID
     *
     * @return
     */
    public int getCustomerID() {
        return this.customerID;
    }
}


