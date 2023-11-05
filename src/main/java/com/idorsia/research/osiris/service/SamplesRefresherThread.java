package com.idorsia.research.osiris.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SamplesRefresherThread extends Thread {

	private static Logger log = LogManager.getLogger(SamplesRefresherThread.class);
	private boolean loop;
	private final static long INTERVAL = 1000 * 60 * 30;// every 30 minutes

	public SamplesRefresherThread(boolean loop) {
		super("SamplesRefresherThread");
		this.loop = loop;
		setDaemon(true);
	}

	@Override
	public void run() {
		try {
			do {
				try {
					SampleService.refreshCachedSamples();
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				if (loop) {
					Thread.sleep(INTERVAL);
				}
			} while (loop && !isInterrupted());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void reInitThread() {
		new SamplesRefresherThread(false).start();
	}

}
