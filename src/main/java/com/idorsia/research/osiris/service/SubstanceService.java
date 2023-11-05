package com.idorsia.research.osiris.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Substance;
import com.idorsia.research.osiris.repository.SubstanceRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubstanceService {
	
	private static Logger log = LogManager.getLogger(SubstanceService.class);
    private static SubstanceRepository substanceRepository;
    private static List<String> cachedSubstances = new ArrayList<String>();

    @SuppressWarnings("static-access")
	@Autowired
    public SubstanceService(SubstanceRepository substanceRepository) {
        this.substanceRepository = substanceRepository;
    }

    public Iterable<Substance> findAll() { return substanceRepository.findAll(); }

    public static List<String> findAllSubstances() {
        return substanceRepository.findAllSubstances();
    }
    
    public long count() { return substanceRepository.count(); }

    @SuppressWarnings("static-access")
	public Optional<Substance> findByName(String actNo) {
        return this.substanceRepository.findByName(actNo);
    }

    @SuppressWarnings("static-access")
	public List<Substance> findByFormula(String formula) {
        return this.substanceRepository.findByFormula(formula);
    }

    public Substance save(Substance substance) {
        return substanceRepository.save(substance);
    }
    
    public void delete(Substance substance) {
    	substanceRepository.delete(substance);
    }
    
    public  List<String> getCachedSubstances() {
        if(cachedSubstances.isEmpty()) {
        	refreshCachedSubstances();
        }
        return cachedSubstances;
    }
    
    public synchronized static void refreshCachedSubstances() {
		log.info("Refreshing Substances cache...");
		cachedSubstances = new ArrayList<String>();
		Instant start = Instant.now();
        List<String> substances = findAllSubstances();
        for(String substance : substances) {
        	cachedSubstances.add(substance);
        }
        Instant end = Instant.now();
        log.info("Refresh Substances cache finished.");
        log.info("Number of Substances in cache : " + cachedSubstances.size());
        log.info("DURATION findAllSubstances(): " + Duration.between(start, end));
	}
}
