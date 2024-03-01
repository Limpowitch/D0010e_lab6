package General;

import State.Customer;

public class Event {
	
	protected State state;
	protected Customer customer;
	protected double executeTime;
	
	public Event(State state, double executeTime) {
		this.state = state;
		this.executeTime = executeTime;
	}
	
	public Event(State state, double executeTime, Customer customer) {
		this.state = state;
		this.executeTime = executeTime;
		this.customer = customer;
	}
	
	public void execute() {
		//Generell funktion för event instruktioner
	}
	
	public double returnExecuteTime() {
		//Returnerar eventets executeTime
		return this.executeTime;
	}
}
