package com.idorsia.research.osiris.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Batch;
import com.idorsia.research.osiris.repository.BatchRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService {
	
	private static Logger log = LogManager.getLogger(BatchService.class);
    private static BatchRepository batchRepository;
    //private static List<Batch> cachedBatches = new ArrayList<Batch>();
    private static List<String> cachedBatches = new ArrayList<String>();

    @Autowired
    @SuppressWarnings("static-access")
    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

	public static Iterable<Batch> findAll() { return batchRepository.findAll(); }

    public long count() { return batchRepository.count(); }

    @SuppressWarnings("static-access")
	public Optional<Batch> findByChemLabJournal(String chemLabJournal) {
        return this.batchRepository.findByChemLabjournal(chemLabJournal);
    }
    
    @SuppressWarnings("static-access")
    public List<Batch> findByActNo(String actNo) {
        return this.batchRepository.findByActNo(actNo);
    }
    
    @SuppressWarnings("static-access")
    public List<Batch> findByChemist(String chemist) {
        return this.batchRepository.findByChemist(chemist);
    }

    @SuppressWarnings("static-access")
    public List<Batch> findByProducer(String producer) {
        return this.batchRepository.findByProducer(producer);
    }
    
    @SuppressWarnings("static-access")
    public List<Batch> findByProjectName(String projectName) {
        return this.batchRepository.findByProjectName(projectName);
    }
    
    @SuppressWarnings("static-access")
    public List<Batch> findBySampleExternalReference(String externalReference) {
        return this.batchRepository.findBySampleExternalReference(externalReference);
    }
    
	public static List<String> findAllBatches(){
    	return batchRepository.findAllBatches();
    }
    
    public Batch save(Batch batch) {
        return batchRepository.save(batch);
    }
    
    public void delete(Batch batch) {
    	batchRepository.delete(batch);
    }
    
    public  List<String> getCachedBatches() {
        if(cachedBatches.isEmpty()) {
        	refreshCachedBatches();
        }
        return cachedBatches;
    }
    
    public synchronized static void refreshCachedBatches() {
		log.info("Refreshing Batches cache...");
		cachedBatches = new ArrayList<String>();
		Instant start = Instant.now();
        List<String> batches = findAllBatches();
        for(String batch : batches) {
        	cachedBatches.add(batch);
        }
        Instant end = Instant.now();
        log.info("Refresh Batches cache finished.");
        log.info("Number of Batches in cache : " + cachedBatches.size());
        log.info("DURATION findAllBatches(): " + Duration.between(start, end));
	}

}
