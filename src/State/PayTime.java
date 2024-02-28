package State;

import Helper_Functions.UniformRandomStream;

public class PayTime {
	
	private double payLow;
	private double payHigh;
	private long seed;
	private UniformRandomStream generatedNumber;
	
	public PayTime(double payLow, double payHigh, long seed) {
		this.payLow = payLow;
		this.payHigh = payHigh;
		this.seed = seed;
		this.generatedNumber = new UniformRandomStream(payLow, payHigh, seed);
	}
	
	//Vi tar nuvarande tid vilket är sparat i state + next metoden i 
	//UniformRandomStream och returnerar det
	public double generatePayTime(double currentTime) {
		return currentTime + generatedNumber.next();
	}
}
