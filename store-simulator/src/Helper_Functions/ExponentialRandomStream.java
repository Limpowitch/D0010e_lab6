package Helper_Functions;

import java.util.Random;


/**
 * Klassen ExponentialRandomStream genererar slumpmassiga tal.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class ExponentialRandomStream {

    private Random rand;
    private double lambda;

    /**
     * Skapar en ny instans av ExponentialRandomStream med angiven lambda parameter och fro for slumptalsgeneratorn.
     *
     * @param lambda Lambda parametern for den exponentiella fordelningen
     * @param seed   Froet for slumptalsgeneratorn
     */
    public ExponentialRandomStream(double lambda, long seed) {
        rand = new Random(seed);
        this.lambda = lambda;
    }

    /**
     * Genererar ett slumpvarde och uppdaterar lambda.
     *
     * @param lambda Frekvensvariabel
     */
    public ExponentialRandomStream(double lambda) {
        rand = new Random();
        this.lambda = lambda;
    }

    /**
     * Genererar och returnerar nasta slumptal enligt den exponentiella fordelningen.
     *
     * @return Nasta slumptal
     */
    public double next() {
        return -Math.log(rand.nextDouble()) / lambda;
    }
}


