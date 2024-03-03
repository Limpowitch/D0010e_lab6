package State;

import Helper_Functions.FIFO;

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
}
