package org.tpg.utils.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodTimerTest {
	@Test
	public void testTimer() throws Exception {
		MethodTimer timer = new MethodTimer();
		
		Thread.sleep(1000);
		
		assertTrue(timer.getDuration() > 0);
	}
}
