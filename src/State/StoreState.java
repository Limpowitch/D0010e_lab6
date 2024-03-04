package State;

import General.State;
import State.PickTime;
import View.Observer;
import View.Subject;
import State.PayTime;

public class StoreState extends State implements Subject{
	private Observer observer;
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
	
	public boolean getOpenStatus() {
		return this.isOpen;
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
	
	public void updateStoreCount(boolean increase) {
		if (increase) {
			this.customersInStore++;
		} else {
			this.customersInStore--;
		}
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		observer.update(this);
		
	}
}
