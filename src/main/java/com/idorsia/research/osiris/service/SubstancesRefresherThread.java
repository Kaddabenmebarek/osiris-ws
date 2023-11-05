package com.idorsia.research.osiris.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubstancesRefresherThread extends Thread {

	private static Logger log = LogManager.getLogger(SubstancesRefresherThread.class);
	private boolean loop;
	private final static long INTERVAL = 1000 * 60 * 30;// every 30 minutes

	public SubstancesRefresherThread(boolean loop) {
		super("SubstancesRefresherThread");
		this.loop = loop;
		setDaemon(true);
	}

	@Override
	public void run() {
		try {
			do {
				try {
					SubstanceService.refreshCachedSubstances();
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
		new SubstancesRefresherThread(false).start();
	}

}
