package General;

public class Event {
	
	protected State state;
	protected EventQueue eventQueue;
	protected double executeTime;
	
	public Event(State state, EventQueue eventQueue, double executeTime) {
		this.state = state;
		this.executeTime = executeTime;
		this.eventQueue = eventQueue;
	}
	
	public void execute() {
		//Generell funktion för event instruktioner
	}
	
	public double returnExecuteTime() {
		//Returnerar eventets executeTime
		return this.executeTime;
	}
}
