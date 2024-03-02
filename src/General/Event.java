package General;

import State.Customer;

public class Event {
	
	protected State state;
	protected EventQueue eventQueue;
	protected double executeTime;
	
	public Event(State state, double executeTime) {
		this.state = state;
		this.executeTime = executeTime;
	}
	
	public void execute(Event event) {
			eventQueue.addToQueue(event);
	}
	
	public double returnExecuteTime() {
		//Returnerar eventets executeTime
		return this.executeTime;
	}
}
