package State;

import Helper_Functions.UniformRandomStream;

/**
 * PickTime klassen genererar plocktider for kunder i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class PickTime {

    private double pickLow;
    private double pickHigh;
    private long seed;
    private UniformRandomStream generatedNumber;

    /**
     * Skapar en ny PickTime instans.
     *
     * @param pickLow  Lagsta plocktid.
     * @param pickHigh Hogsta plocktid.
     * @param seed     Seed for slumpgeneratorn.
     */
    public PickTime(double pickLow, double pickHigh, long seed) {
        this.pickLow = pickLow;
        this.pickHigh = pickHigh;
        this.seed = seed;
        this.generatedNumber = new UniformRandomStream(pickLow, pickHigh, seed);
    }

    //Vi tar nuvarande tid vilket ar sparat i state + next metoden i
    //UniformRandomStream och returnerar det

    /**
     * Genererar en plocktid.
     *
     * @param currentTime Den aktuella tiden i simuleringen.
     * @return Plocktiden for en kund.
     */
    public double generatePickTime(double currentTime) {
        return currentTime + generatedNumber.next();
    }
}
