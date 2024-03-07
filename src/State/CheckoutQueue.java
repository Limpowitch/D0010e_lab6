package State;

import Helper_Functions.FIFO;
import java.util.ArrayList;

public class CheckoutQueue extends FIFO {
	
	public CheckoutQueue() {
		super();
	}
	
	public void addCustomer(Customer customer) {
		this.add(customer);
	}

	public Customer getFirstCustomer() {
		Customer customer = (Customer) super.getFirst();
		this.removeFirst();
		return customer;
	}
	
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
	
	public boolean queuetime()
	{
		boolean check = false;
		if(super.getSize() == 0) {
			check = true;
			return check;
		}
		return check;
	}
}

