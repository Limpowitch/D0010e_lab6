package General;

import java.util.Observable;

public class State extends Observable{
	protected double currentTime;
	protected double previousTime;
	protected boolean isRunning;

	public State() {
		this.isRunning = true;
		this.currentTime = 0;
		this.previousTime = 0;
	}
	
	public void stopSim() {
		this.isRunning = false;
	}
	
	public boolean isStopped() {
		return this.isRunning;
	}
	
	public double returnCurrentTime() {
		return this.currentTime;
	}
	
	public void update(Event event) {
		//Vi behöver en previousTime för att göra kö-tid calculations etc
		this.previousTime = this.currentTime;
		this.currentTime = event.returnExecuteTime();
		
		//Vi vill ge en notify till observers att något har hänt
		
	}
	
	public void notifyObserver() {
		setChanged();
		notifyObservers();
	}
	
	
}
