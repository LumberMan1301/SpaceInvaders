package com.marianoProgra.timer;

public class Timer {
	
	private long currentTimer;
	
	public Timer() {
		currentTimer = System.currentTimeMillis();
	}

	public long getCurrentTimer() {
		return currentTimer;
	}

	public void setCurrentTimer(long currentTimer) {
		this.currentTimer = currentTimer;
	}
	
	public boolean timerEvent(int timer) {
		
		if(System.currentTimeMillis() -  getCurrentTimer() >timer)
			return true;
		
		return false;
	}
}
