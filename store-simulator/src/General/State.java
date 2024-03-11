package General;

import java.util.Observable;

/**
 * State klassen representerar det generella tillstandet i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class State extends Observable {
    private double currentTime;
    private double previousTime;
    private boolean isRunning;

    /**
     * Skapar en ny State instans.
     */
    public State() {
        this.isRunning = true;
        this.currentTime = 0;
        this.previousTime = 0;
    }

    /**
     * Returnerar om simuleringen ar igang.
     *
     * @return True om simuleringen ar igang, annars false.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Stoppar simuleringen.
     */
    public void stopSim() {
        this.isRunning = false;
    }

    /**
     * Returnerar den aktuella tiden i simuleringen.
     *
     * @return Aktuell simuleringstid.
     */
    public double returnCurrentTime() {
        return this.currentTime;
    }

    /**
     * Returnerar den tid da foregaende eventet terminerade.
     *
     * @return Tiden da foregaende eventet terminerade.
     */
    public double returnPreviousTime() {
        return this.previousTime;
    }

    /**
     * Uppdaterar tillstandet med information fran en handelse.
     *
     * @param event Handelsen som har intraffat.
     */
    public void update(Event event) {
        //Vi behover en previousTime for att gora ko-tid calculations etc
        this.previousTime = this.currentTime;
        this.currentTime = event.returnExecuteTime();

        //Vi vill ge en notify till observers att nagot har hant

    }

    /**
     * Meddelar observatorer om att en andring har skett i tillstandet.
     */
    public void notifyObserver() {
        setChanged();
        notifyObservers();
    }


}
