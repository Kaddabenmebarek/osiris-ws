package com.idorsia.research.osiris;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.idorsia.research.osiris.service.BatchesRefresherThread;
import com.idorsia.research.osiris.service.SamplesRefresherThread;
import com.idorsia.research.osiris.service.SubstancesRefresherThread;

@SpringBootApplication
@EntityScan({"",""})
public class OsirisApplication implements CommandLineRunner {
    
	static final Logger logger = LogManager.getLogger(OsirisApplication.class.getName());
    private static Thread batchRefresherThread;
    private static Thread substanceRefresherThread;
    private static Thread samplesRefresherThread;
    
    public static void main(String[] args) {
        SpringApplication.run(OsirisApplication.class, args);
        /*startBatchRefresherThread();
        startSubstanceRefresherThread();
        startSamplesRefresherThread();*/
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Osiris WebService started");
    }
    
    public static void startBatchRefresherThread() {
    	logger.debug("Starting BatchRefresherThread.");
    	batchRefresherThread = new BatchesRefresherThread(true);
    	batchRefresherThread.start();
    }
    
    public static void startSubstanceRefresherThread() {
    	logger.debug("Starting SubstanceRefresherThread.");
    	substanceRefresherThread = new SubstancesRefresherThread(true);
    	substanceRefresherThread.start();
    }
    
    public static void startSamplesRefresherThread() {
    	logger.debug("Starting SamplesRefresherThread.");
    	samplesRefresherThread = new SamplesRefresherThread(true);
    	samplesRefresherThread.start();
    }
    
}
