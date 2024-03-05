package State;

import General.State;
import State.PickTime;
import State.PayTime;

public class StoreState extends State {
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private boolean isOpen;
    private int maxCapacity;
    private int customersInStore;
    private int highestCustomerID;
    private int missedCustomers;
    private int paidCustomers;
    private CheckoutQueue checkoutQueue;
    private int totalCustomersBeenInQueue;
    private int customersHasCheckedOut;
    private int maxCheckoutCapacity;
    private String latestEventName;
    private int currentCheckoutCapacity;
    private int latestEventCustomer;
    private int totalCustomers;
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
		this.paidCustomers = 0;
		this.currentCheckoutCapacity = maxCheckoutCapacity;
		this.totalCustomersBeenInQueue = 0;
		highestCustomerID = -1;
        checkoutQueue = new CheckoutQueue();
        arrivalTime = new ArrivalTime(lambda, seed);
        pickTime = new PickTime(pickLow, pickHigh, seed);
        payTime = new PayTime(payLow, payHigh, seed);
	}
	
	public double getArrivalTime() {
		return arrivalTime.generateArrivalTime(returnCurrentTime());
	}
	
	public double getPickTime() {
		return pickTime.generatePickTime(returnCurrentTime());
	}
	
	public double getPayTime() {
		return payTime.generatePayTime(returnCurrentTime());
	}
	
	public double getLambda() {
		return this.lambda;
	}
	
	public double getPickLow() {
		return this.pickLow;
	}
	
	public double getPickHigh() {
		return this.pickHigh;
	}
	
	public double getPayLow() {
		return this.payLow;
	}
	
	public double getPayHigh() {
		return this.payHigh;
	}
	
	public int getMissedCustomers() {
		return this.missedCustomers;
	}
	
	public int getLatestEventCustomer() {
		if(this.getLatestEvent() == "close") {
			return (Integer) null;
		}
		return this.latestEventCustomer;
	}
	
	public int getCurrentCheckoutCapacity() {
		return this.currentCheckoutCapacity;
	}
	
	public boolean getOpenStatus() {
		return this.isOpen;
	}
	
	public int getTotalCustomersBeenInQueue() {
		return this.totalCustomersBeenInQueue;
	}
	
	public long getSeed() {
		return this.seed;
	}
	
	public int getCustomersInStore() {
		return this.customersInStore;
	}
	
	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	public int getCustomersHasCheckedOut() {
		return customersHasCheckedOut;
	}
	
	public int getMaxCheckoutCapacity() {
		return this.maxCheckoutCapacity;
	}
	
	public CheckoutQueue getCheckoutQueue() {
		return this.checkoutQueue;
	}
	
	public String getLatestEvent() {
		return this.latestEventName;
	}
	
	public int getTotalCustomers() {
		return this.totalCustomers;
	}
	
	public void updateMissedCustomers() {
		this.missedCustomers++;
	}
	
	public void updatePaidCustomers() {
		this.paidCustomers++;
	}
	
	public void updateBeenInQueue() {
		this.totalCustomersBeenInQueue++;
	}
	
	public Customer generatedCustomer() {
		return new Customer(this.highestCustomerID + 1);
	}
	
	
	public void setOpenStatus(boolean openStatus) {
			this.isOpen = openStatus;
	}
	
	public void updateLatestEvent(String string) {
		this.latestEventName = string;
	}
	
	public void updateLatestEventCustomer(Customer customer) {
		latestEventCustomer = customer.customerID;
	}
	
	public void updateTotalCustomers() {
		this.totalCustomers++;
	}
	
	public void updateStoreCount(boolean increase) {
		if (increase) {
			this.customersInStore++;
		} else {
			this.customersInStore--;
		}
	}
}
