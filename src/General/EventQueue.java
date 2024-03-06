package General;

import java.util.ArrayList;

public class EventQueue extends ArrayList<Event> {

    public EventQueue() {
        super();
    }
    
    
    // Lägger till event i queue
    public void addToQueue(Event event) {
        if (this.isEmpty()) {
            this.add(event);
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).returnExecuteTime() > event.returnExecuteTime()) {
                    this.add(i, event);
                    break;
                } else if (i == this.size() - 1){
                    this.add(event);
                    break;
                }
            }
        }
    }
    
    

    // Sortera efter executeTime
    // executeTime för ett specifikt event går att få genom returnExecuteTime()

    // Vi behöver ingen metod för removeFromQueue.
    // Då EventQueue är en ArrayList, så kan Simulator använda sig av .remove
}
