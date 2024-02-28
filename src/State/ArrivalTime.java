package State;

import Helper_Functions.ExponentialRandomStream;

public class ArrivalTime {
	
	private double lambda;
	private long seed;
	private ExponentialRandomStream generatedNumber;
	
	public ArrivalTime(double lambda, long seed) {
		this.lambda = lambda;
		this.seed = seed;
		this.generatedNumber = new ExponentialRandomStream(lambda, seed);
	}
	
	//Vi tar nuvarande tid vilket är sparat i state + next metoden i 
	//ExponentialRandomStream och returnerar det
	public double generateArrivalTime(double currentTime) {
		return currentTime + generatedNumber.next();
	}
}


