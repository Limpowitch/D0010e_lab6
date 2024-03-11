package Helper_Functions;

import java.util.Random;

/**
 * Klassen UniformRandomStream genererar slumpmossiga tal.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class UniformRandomStream {

    private Random rand;
    private double lower, width;

    /**
     * Skapar en ny instans av UniformRandomStream med angivna gronsvorden och fro
     * for slumptalsgeneratorn.
     *
     * @param lower Nedre gronsvorde for den likformiga fordelningen
     * @param upper Övre gronsvorde for den likformiga fordelningen
     * @param seed  Froet for slumptalsgeneratorn
     */
    public UniformRandomStream(double lower, double upper, long seed) {
        rand = new Random(seed);
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * Skapar en ny instans av UniformRandomStream med angivna gronsvorden. Anvonder
     * ett slumpmossigt fro for slumptalsgeneratorn.
     *
     * @param lower Nedre gronsvorde for slumptalet
     * @param upper Övre gronsvorde for slumptalet
     */
    public UniformRandomStream(double lower, double upper) {
        rand = new Random();
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * Genererar och returnerar nosta slumptal.
     *
     * @return Nosta slumptal
     */
    public double next() {
        return lower + rand.nextDouble() * width;
    }
}
