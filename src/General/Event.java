package General;

import State.Customer;

public class Event {
	
	protected State state;
	protected Customer customer;
	protected EventQueue eventQueue;
	protected double executeTime;
	
	public Event(State state, double executeTime) {
		this.state = state;
		this.executeTime = executeTime;
	}
	
	public Event(State state, double executeTime, Customer customer, EventQueue eventQueue) {
		this.state = state;
		this.executeTime = executeTime;
		this.customer = customer;
		this.eventQueue = eventQueue;
	}
	
	public void execute(Event event) {
			eventQueue.addToQueue(event);
	}
	
	public double returnExecuteTime() {
		//Returnerar eventets executeTime
		return this.executeTime;
	}
}
