package General;

import java.util.Observable;
import java.util.Observer;

/**
 * GeneralView klassen representerar en generell observerklass for simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class GeneralView implements Observer {

    /**
     * Metoden som kallas nar det observerade objektet andras.
     * <p>
     * Den har metoden ar tankt att implementeras av underklasser for att hantera
     * specifika uppdateringar.
     *
     * @param o   Det observerade objektet som har andrats.
     * @param arg Eventuellt argument som skickas med uppdateringen.
     */
    public void update(Observable o, Object arg) {
        // Denna metod lamnar vi tom da uppdateringar hanteras av specifika observerklasser.
    }
}
