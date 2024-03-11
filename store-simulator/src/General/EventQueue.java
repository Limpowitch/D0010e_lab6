package General;

import java.util.ArrayList;

/**
 * EventQueue klassen representerar en kö för handelser i simuleringen.
 *
 * @author Bernhard Rosenzweig, Elias Skeppstedt, Tim Rosendahl, Axel Sandström.
 */
public class EventQueue extends ArrayList<Event> {

    public EventQueue() {
        super();
    }


    // Lagger till event i queue

    /**
     * Lagger till ett event i kön.
     * <p>
     * Handelser laggs till i kön i stigande ordning baserat pa deras executeTime.
     *
     * @param event Eventet som ska laggas till i kön.
     */
    public void addToQueue(Event event) {
        if (this.isEmpty()) {
            this.add(event);
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).returnExecuteTime() > event.returnExecuteTime()) {
                    this.add(i, event);
                    break;
                } else if (i == this.size() - 1) {
                    this.add(event);
                    break;
                }
            }
        }
    }
    
    // Sortera efter executeTime
    // executeTime för ett specifikt event gar att fa genom returnExecuteTime()

    // Vi behöver ingen metod för removeFromQueue.
    // Da EventQueue ar en ArrayList, sa kan Simulator anvanda sig av .remove
}
