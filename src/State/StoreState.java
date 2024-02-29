package State;

import General.State;


public class StoreState extends State{
    
	// Initial values for the store
	
	final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private boolean isOpen;
    private int maxCapacity;
    private int customersInStore;
    private int highestCustomerID;
    private int missedCustomers;
    private CheckoutQueue checkoutQueue;
    private int maxCheckoutCapacity;
	private long seed;
	private double lambda;
	private double pickLow;
	private double pickHigh;
	private double payLow; 
	private double payHigh;
	private int freeregisters;
	private float freeregistersTime;
	
	
	//TODO:
	//Skapa alla updates/getter för alla olika store-variabler
	public StoreState(double lambda, long seed) {  // removed maxcapacity as argument and replaced with inheritence below.
		super();
		this.seed = seed; 
		this.lambda = lambda; 
		this.isOpen = false;
		this.maxCapacity =  super.maxcapacity; // inherits its value from method State
		this.customersInStore = 0;
		this.missedCustomers = 0;
		this.freeregisters = super.freeRegisters; // inherits its value from method State
		highestCustomerID = -1;
        checkoutQueue = new CheckoutQueue();
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
	
	public int getMaxCheckoutCapacity() {
		return this.maxCheckoutCapacity;
	}
	
	public CheckoutQueue getCheckoutQueue() {
		return this.checkoutQueue;
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
	public void showFreeRegissters(boolean update) {
		
		if(update)
		{
			this.freeregisters++;
		}
		else
		{
			this.freeregisters--;
		}
		
	}
	
	
}