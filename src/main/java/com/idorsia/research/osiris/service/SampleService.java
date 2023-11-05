package com.idorsia.research.osiris.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Sample;
import com.idorsia.research.osiris.repository.SampleRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SampleService {
	
	private static Logger log = LogManager.getLogger(SampleService.class);
    private static SampleRepository sampleRepository;
    private static List<String> cachedSamples = new ArrayList<String>();

    @SuppressWarnings("static-access")
	@Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Iterable<Sample> findAll() { return sampleRepository.findAll(); }

    public static List<String> findAllSamples() {
        return sampleRepository.findAllSamples();
    }
    
    public long count() { return sampleRepository.count(); }

    @SuppressWarnings("static-access")
	public Optional<Sample> findBySampleId(Integer sampleId) {
        return this.sampleRepository.findBySampleId(sampleId);
    }

    @SuppressWarnings("static-access")
	public List<Sample> findByActNo(String actNo) {
        return this.sampleRepository.findByActNo(actNo);
    }
    
    @SuppressWarnings("static-access")
	public List<Sample> findByExtReference(String extReference) {
        return this.sampleRepository.findByExtReference(extReference);
    }

    @SuppressWarnings("static-access")
	public List<Sample> findBySupplier(String supplier) {
        return this.sampleRepository.findBySupplier(supplier);
    }
    
    @SuppressWarnings("static-access")
	public List<Sample> findByCatalogNo(String catalogNo) {
        return this.sampleRepository.findByCatalogNo(catalogNo);
    }
    
    @SuppressWarnings("static-access")
	public List<Sample> findByLocation(String location) {
        return this.sampleRepository.findByLocation(location);
    }
    
    @SuppressWarnings("static-access")
	public List<Sample> findByUserId(String userId) {
        return this.sampleRepository.findByUserId( userId);
    }
    
    public Sample save(Sample Sample) {
        return sampleRepository.save(Sample);
    }
    
    public void delete(Sample Sample) {
    	sampleRepository.delete(Sample);
    }
    
    public  List<String> getCachedSamples() {
        if(cachedSamples.isEmpty()) {
        	refreshCachedSamples();
        }
        return cachedSamples;
    }
    
    public synchronized static void refreshCachedSamples() {
		log.info("Refreshing Samples cache...");
		cachedSamples = new ArrayList<String>();
		Instant start = Instant.now();
        List<String> samples = findAllSamples();
        for(String sample : samples) {
        	cachedSamples.add(sample);
        }
        Instant end = Instant.now();
        log.info("Refresh Samples cache finished.");
        log.info("Number of Samples in cache : " + cachedSamples.size());
        log.info("DURATION findAllSamples(): " + Duration.between(start, end));
	}

}
