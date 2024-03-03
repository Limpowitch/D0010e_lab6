package General;

public class Event {
	
	protected State state;
	protected EventQueue eventQueue;
	protected double executeTime;
	
	public Event(State state, double executeTime) {
		this.state = state;
		this.executeTime = executeTime;
	}
	
	public void execute() {
		//Generell funktion för event instruktioner
	}
	
	public double returnExecuteTime() {
		//Returnerar eventets executeTime
		return this.executeTime;
	}
}
