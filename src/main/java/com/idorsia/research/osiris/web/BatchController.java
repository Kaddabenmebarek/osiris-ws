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
import com.idorsia.research.osiris.data.BatchDto;
import com.idorsia.research.osiris.data.JsonUtils;
import com.idorsia.research.osiris.entity.Batch;
import com.idorsia.research.osiris.service.BatchService;


@RestController
@RequestMapping(path = "/batch")
public class BatchController {
    private static Logger logger = LogManager.getLogger(BatchController.class);
    private BatchService batchService;
    
    @Autowired
    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    protected BatchController() {

    }

	@RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllBatches() {
        logger.info("Getting all chemLabJournals");

        boolean firstBatch = true;
        long count = batchService.count();
        System.out.println("START: BUILD BODY RESPONSE");
        Instant start = Instant.now();
        List<String> cachedBatches = batchService.getCachedBatches();
        StringBuilder bodyResponse = new StringBuilder("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"batches\":[");
        for (String chemLabJournal : cachedBatches) {
            if (firstBatch) {
            	firstBatch = false;
            } else {
                bodyResponse.append(",");
            }
            bodyResponse.append("\"").append(chemLabJournal).append("\"");
        }
        bodyResponse.append("]}");
        System.out.println("END: BUILD BODY RESPONSE");
        Instant end = Instant.now();
        System.out.println("DURATION BUILD BODY RESPONSE: " + Duration.between(start, end));
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{chemLabJournal}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatch(@PathVariable(value = "chemLabJournal") String chemLabJournal) {
        logger.info("Getting Batch with Lab Journal : " + chemLabJournal);

        Optional<Batch> batch = batchService.findByChemLabJournal(chemLabJournal);
        if (batch == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Lab Journal doesn't match.\"}");

        }
        Batch ba = batch.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(ba));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/batches/actNo/{actNo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatchesByActNo(@PathVariable(value = "actNo") String actNo) {
        logger.info("Getting batches for compound: " + actNo);

        List<Batch> batches = batchService.findByActNo(actNo);
        if (batches == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No batch found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(batches));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/batches/chemist/{chemist}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatchesByChemist(@PathVariable(value = "chemist") String chemist) {
        logger.info("Getting batches for chemist: " + chemist);

        List<Batch> batches = batchService.findByChemist(chemist);
        if (batches == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No batch found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(batches));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/batches/project/{projectName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatchesByProject(@PathVariable(value = "projectName") String projectName) {
        logger.info("Getting batches for project: " + projectName);

        List<Batch> batches = batchService.findByProjectName(projectName);
        if (batches == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No batch found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(batches));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/batches/producer/{producer}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatchesByProducer(@PathVariable(value = "producer") String producer) {
        logger.info("Getting batches for producer: " + producer);

        List<Batch> batches = batchService.findByProducer(producer);
        if (batches == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No batch found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(batches));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/batches/sample/{externalReference}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBatchesBySampleExternalReference(@PathVariable(value = "externalReference") String externalReference) {
        logger.info("Getting batches with externalReference: " + externalReference);

        List<Batch> batches = batchService.findBySampleExternalReference(externalReference);
        if (batches == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No batch found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(batches));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.POST, path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addBatch(@RequestBody BatchDto batchDto) {
        logger.info("Adding batch");
        StringBuffer bodyResponse = new StringBuffer("{");
        Batch batch = new Batch();
        batch.setChemLabJournal(batchDto.getChemLabJournal());
        batch.setActNo(batchDto.getActNo());
        batch.setChemist(batchDto.getChemist());
        batch.setProducer(batchDto.getProducer());
        batch.setProjectName(batchDto.getProjectName());
        batch.setPreparationDate(batchDto.getPreparationDate());
        batch.setPreparationDesc(batchDto.getPreparationDesc());
        batch.setPurification(batchDto.getPurification());
        batch.setMeltingPoint(batchDto.getMeltingPoint());
        batch.setBoilingPoint(batchDto.getBoilingPoint());
        batch.setColor(batchDto.getColor());
        batch.setAmount(batchDto.getAmount());
        batch.setYield(batchDto.getYield());
        batch.setCmnt(batchDto.getCmnt());
        batch.setUserId(batchDto.getUserId());
        batch.setUpdDate(batchDto.getUpdDate());
        batch.setLocation(batchDto.getLocation());
        batchService.save(batch);
        bodyResponse.append("}");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
	/*@RequestMapping(method = RequestMethod.PUT, path = "/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateBatch(@RequestBody BatchDto batchDto) {
		logger.info("Updating substance");
		String chemLabJournal = batchDto.getChemLabJournal();
		Optional<Batch> batch = batchService.findByChemLabJournal(chemLabJournal);
        if (batch == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"This batch can't be updated.\"}");
        }
        Batch ba = batch.get();
        ba.setChemLabJournal(batchDto.getChemLabJournal());
        ba.setActNo(batchDto.getActNo());
        ba.setChemist(batchDto.getChemist());
        ba.setProducer(batchDto.getProducer());
        ba.setProjectName(batchDto.getProjectName());
        ba.setPreparationDate(batchDto.getPreparationDate());
        ba.setPreparationDesc(batchDto.getPreparationDesc());
        ba.setPurification(batchDto.getPurification());
        ba.setMeltingPoint(batchDto.getMeltingPoint());
        ba.setBoilingPoint(batchDto.getBoilingPoint());
        ba.setColor(batchDto.getColor());
        ba.setAmount(batchDto.getAmount());
        ba.setYield(batchDto.getYield());
        ba.setCmnt(batchDto.getCmnt());
        ba.setUserId(batchDto.getUserId());
        ba.setUpdDate(batchDto.getUpdDate());
        ba.setLocation(batchDto.getLocation());
		StringBuffer bodyResponse = new StringBuffer("{}");
		batchService.save(ba);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{chemLabJournal}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteSubstance(@PathVariable(value = "chemLabJournal") String chemLabJournal) {
        logger.info("Deleting batch: " + chemLabJournal);

        Optional<Batch> batch = batchService.findByChemLabJournal(chemLabJournal);
        if (batch == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Batch cannot be removed.\"}");

        }
        Batch ba = batch.get();
		StringBuffer bodyResponse = new StringBuffer("{}");
		batchService.delete(ba);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
    }*/
}
