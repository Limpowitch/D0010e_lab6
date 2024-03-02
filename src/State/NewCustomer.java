package State;

import State.Customer;

public class NewCustomer {
	private Customer newCustomer;
	private static int customerID;
	public NewCustomer() {
		newCustomer = new Customer();
		customerID = newCustomer.getCostumerID();
		newCustomer.updateCostumerID();
	}
	
	public int getCustomerID() {
		return customerID;
	}
}
