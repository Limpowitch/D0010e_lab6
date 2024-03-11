package State;

import Helper_Functions.UniformRandomStream;

/**
 * PayTime-klassen genererar betalningstider for kunder i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class PayTime {

    private double payLow;
    private double payHigh;
    private long seed;
    private UniformRandomStream generatedNumber;

    /**
     * Skapar en ny PayTime-instans.
     *
     * @param payLow  Lagsta betalningstid.
     * @param payHigh Hogsta betalningstid.
     * @param seed    Seed for slumpgeneratorn.
     */
    public PayTime(double payLow, double payHigh, long seed) {
        this.payLow = payLow;
        this.payHigh = payHigh;
        this.seed = seed;
        this.generatedNumber = new UniformRandomStream(payLow, payHigh, seed);
    }

    //Vi tar nuvarande tid vilket ar sparat i state + next metoden i 
    //UniformRandomStream och returnerar det

    /**
     * Genererar en betalningstid.
     *
     * @param currentTime Den aktuella tiden i simuleringen.
     * @return Betalningstiden for en kund.
     */
    public double generatePayTime(double currentTime) {
        return currentTime + generatedNumber.next();
    }
}
