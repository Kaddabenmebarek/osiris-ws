package com.idorsia.research.osiris.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.SendTerminology;
import com.idorsia.research.osiris.repository.SendTerminologyRepository;

import java.util.List;

@Service
public class SendTerminologyService {

	private static Logger log = LogManager.getLogger(SendTerminologyService.class);
	private SendTerminologyRepository sendTerminologyRepository;

	@Autowired
	@SuppressWarnings("static-access")
	public SendTerminologyService(SendTerminologyRepository sendTerminologyRepository) {
		this.sendTerminologyRepository = sendTerminologyRepository;
	}

	public Iterable<SendTerminology> findAll() {
		return sendTerminologyRepository.findAll();
	}

	public long count() {
		return sendTerminologyRepository.count();
	}

	public List<String> findByCode(String code) {
		return this.sendTerminologyRepository.findByCode(code);
	}

	public List<String> findCodeNames() {
		return this.sendTerminologyRepository.findCodeNames();
	}

	public String getCodeByCodeName(String codename) {
		return this.sendTerminologyRepository.getCodeByCodeName(codename);
	}

}
