package General;

import java.util.ArrayList;

public class EventQueue extends ArrayList<Event> {

	public EventQueue() {
		super();
	}
	
	//Lägger till event i queue
	public void addToQueue(Event event) {
		// Om this i:te elements ExTime är större än eventets ExTime,
		// lägg till event på i:te plats i this.
		// FULT IF-SATS, ENDAST TILLS VIDARE //
		if (this.size() <= 2 && (event.getExecuteTime() == 0 || event.getExecuteTime() == 999)) {
                this.add(event);
            } else {
			for (int i = 0; i < this.size(); i++) {
				if (this.get(i).getExecuteTime() > event.getExecuteTime()) {
	                this.add(i, event);
	            }
	        }
		}
	}
	//Vi behöver ingen metod för removeFromQueue.
	//Då EventQueue är en ArrayList, så kan Simulator använda sig av .remove
}
