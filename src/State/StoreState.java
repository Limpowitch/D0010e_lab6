package State;

import General.State;
import State.PickTime;
import State.PayTime;

public class StoreState extends State {
	final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private String isOpen = "S";
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
    private int currentInCheckout;
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
	protected int printall;
	
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
	
	public void updatePrintAll(int i) {
		this.printall = i;
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
	
	public int getCurrentInCheckout() {
		return this.currentInCheckout;
	}
	
	public String getOpenStatus() {
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
	
	public int getPaidCustomers() {
		return this.paidCustomers;
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
		int highestCustomerIDHolder = this.highestCustomerID;
		this.highestCustomerID = this.highestCustomerID + 1;
		return new Customer(highestCustomerIDHolder + 1);
	}
	
	
	public void setOpenStatus(String string) {
			this.isOpen = string;
	}
	
	public void updateLatestEvent(String string) {
		this.latestEventName = string;
	}
	
	public void updateLatestEventCustomer(int customer) {
		latestEventCustomer = customer;
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
				populatedQueueTime = super.returnCurrentTime() - super.returnPreviousTime();
				
			}
			else
			{
				//double timetemp =  super.returnCurrentTime() - populatedQueueTime;
				//populatedQueueTime += timetemp; 
				populatedQueueTime = populatedQueueTime + (super.returnCurrentTime() - super.returnPreviousTime());
			}
		}
		else // if the queue is empty, another timer is started to measure queued time spent in it.
		{
			if(emptyqueueTime == 0.0)
			{
				emptyqueueTime = super.returnCurrentTime() - super.returnPreviousTime();
			}
			else
			{
				//double timetemp = super.returnCurrentTime() - emptyqueueTime;
				//emptyqueueTime += timetemp;
				emptyqueueTime = emptyqueueTime + (super.returnCurrentTime() - super.returnPreviousTime());
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

	public void updateCurrentInCheckout(boolean b) {
		if(b) {
			this.currentInCheckout++;
		} else {
			this.currentInCheckout--;
		}
		
	}

}
