package State;

import General.State;

public class StoreState extends State{
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private boolean isOpen;
    private int maxCapacity;
    private int customersInStore;
    private int highestCustomerID;
    private int missedCustomers;
	private long seed;
	private double lambda;
	private double pickLow;
	private double pickHigh;
	private double payLow;
	private double payHigh;
	
	//TODO:
	//Skapa alla updates/getter för alla olika store-variabler
	public StoreState(double lambda, long seed, int maxCapacity) {
		super();
		this.seed = seed; 
		this.lambda = lambda; 
		this.isOpen = false;
		this.maxCapacity = maxCapacity;
		this.customersInStore = 0;
		this.missedCustomers = 0;
		highestCustomerID = -1;
        arrivalTime = new ArrivalTime(lambda, seed);
        pickTime = new PickTime(pickLow, pickHigh, seed);
        payTime = new PayTime(payLow, payHigh, seed);
	}
	
	public double returnArrivalTime() {
		return arrivalTime.generateArrivalTime(returnCurrentTime());
	}
	
	public double returnPickTime() {
		return pickTime.generatePickTime(returnCurrentTime());
	}
	
	public double returnpayTime() {
		return payTime.generatePayTime(returnCurrentTime());
	}
	
	public boolean returnOpenStatus() {
		return this.isOpen;
	}
	
	public int returnCustomersInStore() {
		return this.customersInStore;
	}
	
	public int returnMaxCapacity() {
		return this.maxCapacity;
	}
	
	public void updateMissedCustomers() {
		this.missedCustomers++;
	}
	
	public Customer generatedCustomer() {
		return new Customer(this.highestCustomerID + 1);
	}
	
	
	public void setOpenStatus(boolean openStatus) {
			this.isOpen = openStatus;
	}
	
	public void updateStoreCount(boolean increase) {
		if (increase) {
			this.customersInStore++;
		} else {
			this.customersInStore--;
		}
	}
}
