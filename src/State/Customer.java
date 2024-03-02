package State;

public class Customer {
	private static int customerID = 1;
	public int getCostumerID () {
		return customerID;
	}
	public void updateCostumerID () {
        customerID++;
    }
}
