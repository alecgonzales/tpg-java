package org.tpg.utils.impl;

import org.tpg.utils.Timer;

public class MethodTimer implements Timer {
	public long startTime;
	public long endTime;
	
	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	
	public MethodTimer() {
		this.start();
	}
	
	@Override
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	
	@Override
	public void stop() {
		this.endTime = System.currentTimeMillis();
	}
	
	@Override
	public long getDuration() {
		if (this.endTime == 0) {
			this.stop();
		}
		return this.endTime - this.startTime;
	}
}
