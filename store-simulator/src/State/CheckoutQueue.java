package State;

import Helper_Functions.FIFO;

import java.util.ArrayList;

/**
 * CheckoutQueue-klassen representerar en ko for kunder i en kassalinje.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class CheckoutQueue extends FIFO {

    /**
     * Skapar en ny CheckoutQueue-instans.
     */
    public CheckoutQueue() {
        super();
    }

    /**
     * Lagger till en kund i kon.
     *
     * @param customer Kunden som ska laggas till.
     */
    public void addCustomer(Customer customer) {
        this.add(customer);
    }

    /**
     * Hamtar och tar bort den forsta kunden i kon.
     *
     * @return Kunden som var forst i kon.
     */
    public Customer getFirstCustomer() {
        Customer customer = (Customer) super.getFirst();
        this.removeFirst();
        return customer;
    }

    /**
     * Returnerar en strangrepresentation av kon.
     *
     * @return En strang som visar kunderna i kon.
     */
    public String getCurrentQueue() {
        int size = this.getSize();
        StringBuilder wholequeue = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            Customer customer = (Customer) this.getIndex(i);
            wholequeue.append(customer.getCustomerID());
            if (i < size - 1) {
                wholequeue.append(",");
            }
        }
        wholequeue.append("]");
        return wholequeue.toString();
    }

    /**
     * Returnerar kon som en strang.
     *
     * @return En strang som visar kunderna i kon.
     */
    public boolean queuetime() {
        boolean check = false;
        if (super.getSize() == 0) {
            check = true;
            return check;
        }
        return check;
    }
}

