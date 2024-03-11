package State;

import Helper_Functions.ExponentialRandomStream;

/**
 * ArrivalTime klassen genererar ankomsttider for kunder i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class ArrivalTime {

    private long seed;
    private double lambda;
    private ExponentialRandomStream generatedNumber;

    /**
     * Skapar en ny ArrivalTime instans.
     *
     * @param lambda Parametern lambda for den exponentiella fordelningen.
     * @param seed   Fro till slumpgeneratorn.
     */
    public ArrivalTime(double lambda, long seed) {
        this.lambda = lambda;
        this.seed = seed;
        this.generatedNumber = new ExponentialRandomStream(lambda, seed);

    }

    //Vi tar nuvarande tid vilket ar sparat i state + next metoden i 
    //ExponentialRandomStream och returnerar det

    /**
     * Genererar en ankomsttid baserat pa den exponentiella fordelningen.
     *
     * @param currentTime Den aktuella tiden i simuleringen.
     * @return Nasta ankomsttid.
     */
    public double generateArrivalTime(double currentTime) {
        return currentTime + generatedNumber.next();
    }
}	


