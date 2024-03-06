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
	
	public String getCurrentQueue()
	{
		FIFO queue = new FIFO();
		
		String wholequeue = queue.toString();
		
			
		return wholequeue;
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
