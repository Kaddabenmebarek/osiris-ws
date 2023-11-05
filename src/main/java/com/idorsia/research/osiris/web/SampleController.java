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
import com.idorsia.research.osiris.data.SampleDto;
import com.idorsia.research.osiris.data.JsonUtils;
import com.idorsia.research.osiris.entity.Sample;
import com.idorsia.research.osiris.service.SampleService;


@RestController
@RequestMapping(path = "/sample")
public class SampleController {
    private static Logger logger = LogManager.getLogger(SampleController.class);
    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    protected SampleController() {

    }

    @SuppressWarnings("static-access")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllSubstances() {
        logger.info("Getting all Samples");

        boolean firstSample = true;
        long count = sampleService.count();
        List<String> samples = sampleService.getCachedSamples();
        System.out.println("START: BUILD BODY RESPONSE");
        Instant start = Instant.now();        
        StringBuffer bodyResponse = new StringBuffer("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"samples\":[");
        try {
            for (String sample : samples) {
                if (firstSample) {
                	firstSample = false;
                } else {
                    bodyResponse.append(",");
                }
                bodyResponse.append(JsonUtils.mapToJson(sample));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        bodyResponse.append("]}");
        System.out.println("END: BUILD BODY RESPONSE");
        Instant end = Instant.now();
        System.out.println("DURATION BUILD BODY RESPONSE: " + Duration.between(start, end));
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{sampleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSample(@PathVariable(value = "sampleId") Integer sampleId) {
        logger.info("Getting Sample : " + sampleId);

        Optional<Sample> sample = sampleService.findBySampleId(sampleId);
        if (sample == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Sample id doesn't exists.\"}");

        }
        Sample sa = sample.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(sa));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/samples/actNo/{actNo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesByActNo(@PathVariable(value = "actNo") String actNo) {
        logger.info("Getting Samples for compound: " + actNo);

        List<Sample> samples = sampleService.findByActNo(actNo);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found with this compound.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/samples/extReference/{extReference}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesByExtRefernce(@PathVariable(value = "extReference") String extReference) {
        logger.info("Getting Samples for external reference :" + extReference);

        List<Sample> samples = sampleService.findByExtReference(extReference);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/samples/supplier/{supplier}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesBySupplier(@PathVariable(value = "supplier") String supplier) {
        logger.info("Getting Samples for supplier: " + supplier);

        List<Sample> samples = sampleService.findBySupplier(supplier);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/samples/catalogNo/{catalogNo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesByCatalogNo(@PathVariable(value = "catalogNo") String catalogNo) {
        logger.info("Getting Samples for catalog: " + catalogNo);

        List<Sample> samples = sampleService.findByCatalogNo(catalogNo);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/samples/location/{location}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesByLocation(@PathVariable(value = "catalogNo") String location) {
        logger.info("Getting Samples for location: " + location);

        List<Sample> samples = sampleService.findByLocation(location);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/samples/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSamplesByuserId(@PathVariable(value = "userId") String userId) {
        logger.info("Getting Samples for user: " + userId);

        List<Sample> samples = sampleService.findByUserId(userId);
        if (samples == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Sample found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(samples));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.POST, path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addSample(@RequestBody SampleDto sampleDto) {
        logger.info("Adding Sample");
        StringBuffer bodyResponse = new StringBuffer("{");
        Sample sample = new Sample();
        sample.setActNo(sampleDto.getActNo());
        sample.setCatalogNo(sampleDto.getCatalogNo());
        sample.setCmnt(sampleDto.getCmnt());
        sample.setExtReferfence(sampleDto.getExtReferfence());
        sample.setLocation(sampleDto.getLocation());
        sample.setLoNo(sampleDto.getLoNo());
        sample.setPrimaryPurpose(sampleDto.getPrimaryPurpose());
        sample.setSupplier(sampleDto.getSupplier());
        sample.setUpdDate(sampleDto.getUpdDate());
        sample.setUserId(sampleDto.getUserId());        
        sampleService.save(sample);
        bodyResponse.append("}");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
	/*@RequestMapping(method = RequestMethod.PUT, path = "/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateSample(@RequestBody SampleDto sampleDto) {
		logger.info("Updating Sample");
		Integer sampleId = sampleDto.getSampleId();
		Optional<Sample> sample = sampleService.findBySampleId(sampleId);
        if (sample == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"This Sample can't be updated.\"}");
        }
        Sample sa = sample.get();
        sa.setActNo(sampleDto.getActNo());
        sa.setCatalogNo(sampleDto.getCatalogNo());
        sa.setCmnt(sampleDto.getCmnt());
        sa.setExtReferfence(sampleDto.getExtReferfence());
        sa.setLocation(sampleDto.getLocation());
        sa.setLoNo(sampleDto.getLoNo());
        sa.setPrimaryPurpose(sampleDto.getPrimaryPurpose());
        sa.setSupplier(sampleDto.getSupplier());
        sa.setUpdDate(sampleDto.getUpdDate());
        sa.setUserId(sampleDto.getUserId());  
		StringBuffer bodyResponse = new StringBuffer("{}");
		sampleService.save(sa);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{sampleId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteSubstance(@PathVariable(value = "chemLabJournal") Integer sampleId) {
        logger.info("Deleting Sample: " + sampleId);

        Optional<Sample> sample = sampleService.findBySampleId(sampleId);
        if (sample == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Sample cannot be removed.\"}");

        }
        Sample sa = sample.get();
		StringBuffer bodyResponse = new StringBuffer("{}");
		sampleService.delete(sa);
		bodyResponse.append("}");
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json")
				.body(bodyResponse.toString());
    }*/
}
