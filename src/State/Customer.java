package State;

public class Customer {
	
	//En customer är bara ett customerID
	public int customerID;
	
	public Customer(int customerID) {
		this.customerID = customerID;
	}
	
	public int customerNumber() {
		return customerID;
	}
}


