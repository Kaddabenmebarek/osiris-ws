package com.idorsia.research.osiris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Compound;
import com.idorsia.research.osiris.repository.CompoundRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompoundService {
    private CompoundRepository compoundRepository;

    @Autowired
    public CompoundService(CompoundRepository compoundRepository) {
        this.compoundRepository = compoundRepository;
    }

    public long count() { return compoundRepository.count(); }

    public Optional<Compound> findByCompoundId(Integer compoundId) {
        return this.compoundRepository.findByCompoundId(compoundId);
    }
    
    public List<Compound> findByName(String compundName) {
        return this.compoundRepository.findByName(compundName);
    }

    public Optional<Compound> findByChemLabJournal(String chemLabJournal) {
        return this.compoundRepository.findByChemLabJournal(chemLabJournal);
    }
    
}
