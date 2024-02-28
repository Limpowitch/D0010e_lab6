package State;

import Helper_Functions.UniformRandomStream;

public class PickTime {
	
	private double pickLow;
	private double pickHigh;
	private long seed;
	private UniformRandomStream generatedNumber;
	
	public PickTime(double pickLow, double pickHigh, long seed) {
		this.pickLow = pickLow;
		this.pickHigh = pickHigh;
		this.seed = seed;
		this.generatedNumber = new UniformRandomStream(pickLow, pickHigh, seed);
	}
	
	//Vi tar nuvarande tid vilket är sparat i state + next metoden i 
	//UniformRandomStream och returnerar det
	public double generatePickTime(double currentTime) {
		return currentTime + generatedNumber.next();
	}
}
