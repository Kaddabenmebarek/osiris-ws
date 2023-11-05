package com.idorsia.research.osiris.web;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idorsia.research.osiris.data.JsonUtils;
import com.idorsia.research.osiris.data.SubstanceDto;
import com.idorsia.research.osiris.entity.Substance;
import com.idorsia.research.osiris.service.SubstanceService;


@RestController
@RequestMapping(path = "/substance")
public class SubstanceController {
    private static Logger logger = LogManager.getLogger(SubstanceController.class);
    private SubstanceService substanceService;

    @Autowired
    public SubstanceController(SubstanceService substanceService) {
        this.substanceService = substanceService;
    }

    protected SubstanceController() {

    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllSubstances() {
        logger.info("Getting all substances");

        boolean firstSubstance = true;
        long count = substanceService.count();
        List<String> substances = substanceService.getCachedSubstances();
        System.out.println("START: BUILD BODY RESPONSE");
        Instant start = Instant.now();        
        StringBuffer bodyResponse = new StringBuffer("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"substances\":[");
        for (String substance : substances) {
            if (firstSubstance) {
            	firstSubstance = false;
            } else {
                bodyResponse.append(",");
            }
            bodyResponse.append("\"").append(substance).append("\"");
        }
        bodyResponse.append("]}");
        System.out.println("END: BUILD BODY RESPONSE");
        Instant end = Instant.now();
        System.out.println("DURATION BUILD BODY RESPONSE: " + Duration.between(start, end));
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{actNo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSubstance(@PathVariable(value = "actNo") String actNo) {
        logger.info("Getting substance : " + actNo);

        Optional<Substance> substance = substanceService.findByName(actNo);
        if (substance == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"ActNo doesn't match.\"}");

        }
        Substance subst = substance.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(subst));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/substances/{formula}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSubstancesByFormula(@PathVariable(value = "formula") String formula) {
        logger.info("Getting substances for formula: " + formula);

        List<Substance> substances = substanceService.findByFormula(formula);
        if (substances == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No substances found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(substances));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.POST, path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addSubstance(@RequestBody SubstanceDto substanceDto) {
        logger.info("Adding Substance");
        StringBuffer bodyResponse = new StringBuffer("{");
        Substance substance = new Substance();
        substance.setActNo(substanceDto.getActNo());
        substance.setFormula(substanceDto.getFormula());
        substance.setMolWeight(substanceDto.getMolWeight());
        substance.setAbsWeight(substanceDto.getAbsWeight());
        substance.setSystematicName(substanceDto.getSystematicName());
        substance.setKnown(substanceDto.getKnown());
        substance.setKnownSource(substanceDto.getKnownSource());
        substance.setSubstanceClass(substanceDto.getSubstanceClass());
        substance.setMolFile(substanceDto.getMolFile());
        substance.setCmnt(substanceDto.getCmnt());
        substance.setUserId(substanceDto.getUserId());
        substance.setUpdDate(substanceDto.getUpdDate());
        substance.setClogp(substanceDto.getClogp());
        substance.setIdCode(substanceDto.getIdCode());
        substance.setCoordinates(substanceDto.getCoordinates());
        substance.setTautomer(substanceDto.getTautomer());
        substance.setFlag(substanceDto.getFlag());
        substanceService.save(substance);
        bodyResponse.append("}");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
	/*@RequestMapping(method = RequestMethod.PUT, path = "/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateSubstance(@RequestBody SubstanceDto substanceDto) {
		logger.info("Updating substance");
		String actNo = substanceDto.getActNo();
		Optional<Substance> substance = substanceService.findByName(actNo);
        if (substance == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"This substance can't be updated.\"}");
        }
        Substance subst = substance.get();
        subst.setActNo(substanceDto.getActNo());
        subst.setFormula(substanceDto.getFormula());
        subst.setMolWeight(substanceDto.getMolWeight());
        subst.setAbsWeight(substanceDto.getAbsWeight());
        subst.setSystematicName(substanceDto.getSystematicName());
        subst.setKnown(substanceDto.getKnown());
        subst.setKnownSource(substanceDto.getKnownSource());
        subst.setSubstanceClass(substanceDto.getSubstanceClass());
        subst.setMolFile(substanceDto.getMolFile());
        subst.setCmnt(substanceDto.getCmnt());
        subst.setUserId(substanceDto.getUserId());
        subst.setUpdDate(substanceDto.getUpdDate());
        subst.setClogp(substanceDto.getClogp());
        subst.setIdCode(substanceDto.getIdCode());
        subst.setCoordinates(substanceDto.getCoordinates());
        subst.setTautomer(substanceDto.getTautomer());
        subst.setFlag(substanceDto.getFlag());
		StringBuffer bodyResponse = new StringBuffer("{}");
		substanceService.save(subst);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{actNo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteSubstance(@PathVariable(value = "actNo") String actNo) {
        logger.info("Deleting substance: " + actNo);

        Optional<Substance> substance = substanceService.findByName(actNo);
        if (substance == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Substance cannot be removed.\"}");

        }
        Substance subst = substance.get();
		StringBuffer bodyResponse = new StringBuffer("{}");
		substanceService.delete(subst);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
    }*/
}
