package State;

import General.State;
import State.PickTime;
import State.PayTime;

public class StoreState extends State {
	final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private boolean isOpen = false;
    private int maxCapacity;
    private int customersInStore = 0;
    private int highestCustomerID = -1;
    private int missedCustomers = 0;
    private int paidCustomers = 0;
    private CheckoutQueue checkoutQueue;
    private int totalCustomersBeenInQueue = 0;
    private int maxCheckoutCapacity;
    private int customersHasCheckedOut;
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
	private double populatedQueueTime;
	private double emptyqueueTime;
	
	//TODO:
	//Skapa alla updates/getter för alla olika store-variabler
	public StoreState(int seed, double lambda, int maxCapacity, int maxCheckoutCapacity, double pickLow, double pickHigh, double payLow, double payHigh) {
		super();
		this.lambda = lambda;
		this.seed = seed;
		this.pickLow = pickLow;
		this.pickHigh = pickHigh;
		this.payLow = payLow;
		this.payHigh = payHigh;
		this.maxCapacity = maxCapacity;
		this.latestEventName = "Arrival";
		this.maxCheckoutCapacity = maxCheckoutCapacity;
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
	
	public void registersempty()
	{
		//State checktime = new State();
		
		if(checkoutQueue.queuetime() == false)  // checks if the queue has people in it and updates time spent in it.
		{
			if(populatedQueueTime == 0.0)
			{
				populatedQueueTime = super.returnCurrentTime();
				
			}
			else
			{
				double timetemp =  super.returnCurrentTime() - populatedQueueTime;
				populatedQueueTime += timetemp; 
			}
		}
		else // if the queue is empty, another timer is started to measure queued time spent in it.
		{
			if(emptyqueueTime == 0.0)
			{
				emptyqueueTime = super.returnCurrentTime(); 
			}
			else
			{
				double timetemp = super.returnCurrentTime() - emptyqueueTime;
				emptyqueueTime += timetemp;
			}
			
		}
		
	}
	public double getPopulatedQueueTime()
	{
		return populatedQueueTime;
	}
	public double getEmptyQueueTime() {
		
		return emptyqueueTime;
	}

}
