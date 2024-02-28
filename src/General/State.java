package General;

public class State {
	protected double currentTime;
	protected double previousTime;
	protected boolean isRunning;

	public State() {
		this.isRunning = true;
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
	
	
}
