package State;

import General.State;

public class StoreState extends State{
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private boolean isOpen;
	private long seed;
	private double lambda;
	private double pickLow;
	private double pickHigh;
	private double payLow;
	private double payHigh;
	
	//TODO:
	//Skapa alla updates/getter för alla olika store-variabler
	public StoreState(double lambda, long seed) {
		super();
		this.seed = seed; 
		this.lambda = lambda; 
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
	
	
	public void setOpenStatus(boolean open) {
		if (open) {
			this.isOpen = true;
		} else {
			this.isOpen = false;
		}
	}
}
