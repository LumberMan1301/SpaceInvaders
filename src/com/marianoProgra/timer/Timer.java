package com.marianoProgra.timer;

public class Timer {
	
	private long prevTime;
	
	public Timer() {
		prevTime = System.currentTimeMillis();
	}

	public long getPrevTimer() {
		return prevTime;
	}

	public void setPrevTimer(long currentTimer) {
		this.prevTime = currentTimer;
	}
	
	public void resetTimer() {
		prevTime = System.currentTimeMillis();
		
	}
	
	public boolean timerEvent(int timer) {
		
		if(System.currentTimeMillis() -  getPrevTimer() >timer) {
			resetTimer();
			return true;
		}
		return false;
	}
	
	public boolean isTimerReady(int timer) {
		if(System.currentTimeMillis() -  getPrevTimer() >timer)
			return true;
		return false;
	}
}
