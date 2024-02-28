package General;

import java.util.ArrayList;

public class EventQueue extends ArrayList<Event> {

	public EventQueue() {
		super();
	}
	
	//Lägger till event i queue
	public void addToQueue(Event event) {
		//Sortera efter executeTime
		//executeTime för ett specifikt event går att få genom returnExecuteTime()
		
	}
	
	//Vi behöver ingen metod för removeFromQueue.
	//Då EventQueue är en ArrayList, så kan Simulator använda sig av .remove
	
}
