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
	
	public String getCurrentQueue()
	{
		// converting the contents of the FIFO queue to a string that can be printed.
		FIFO queue = new FIFO();
		int size = queue.getSize();
		String wholequeue ="[";
		for(int i=0;i<=size;i++)
		{
			if(size == 0)
			{
				break;
			}
			else
			{
				wholequeue = wholequeue +  (String) queue.getIndex(i)  + ",";	
			}
		}
		if(size == 0)
		{
			wholequeue ="[]";
		}
		else
		{
			wholequeue = wholequeue  + "]";
		}
	
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

