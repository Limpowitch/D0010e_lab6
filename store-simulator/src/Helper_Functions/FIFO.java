package Helper_Functions;

import java.util.ArrayList;

/**
 * Klassen FIFO implementerar en FIFO ko.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandstrom.
 */
public class FIFO {

    private ArrayList<Object> FIFO;
    private int maxSize = 0;

    /**
     * Skapar en ny tom FIFO-ko.
     */
    public FIFO() {
        this.FIFO = new ArrayList<>();
    }

    /**
     * Lagger till ett nytt objekt i slutet av kon.
     *
     * @param item Det objekt som ska laggas till
     */
    public void add(Object item) {
        FIFO.add(item);
        if (FIFO.size() > maxSize()) {
            maxSize++;
        }
    }

    /**
     * Tar bort och returnerar det forsta objektet i kon.
     */
    public void removeFirst() {
        if (!FIFO.isEmpty()) {
            FIFO.remove(0);
        }
    }

    /**
     * Returnerar det aktuella antalet objekt i kon.
     *
     * @return Antalet objekt i kon
     */
    public int getSize() {
        return FIFO.size();
    }

    /**
     * Returnerar det storsta antalet objekt som kon har innehallit.
     *
     * @return Det storsta antalet objekt i kon
     */
    public int maxSize() {
        return maxSize;
    }

    /**
     * Returnerar det forsta objektet i kon utan att ta bort det.
     *
     * @return Det forsta objektet i kon, eller null om kon ar tom
     */
    public Object getFirst() {
        return FIFO.get(0);
    }

    /**
     * Returnerar objektet pa angiven position i kon.
     *
     * @param i Index for objektet som ska returneras
     * @return Objektet pa angiven position, eller null om indexet ar ogiltigt
     */
    public Object getIndex(int i) {
        return FIFO.get(i);
    }
}