package com.idorsia.research.osiris.web;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idorsia.research.osiris.data.JsonUtils;
import com.idorsia.research.osiris.entity.SendTerminology;
import com.idorsia.research.osiris.service.SendTerminologyService;


@RestController
@RequestMapping(path = "/send_terminology")
public class SendTerminologyController {
    private static Logger logger = LogManager.getLogger(SendTerminologyController.class);
    private SendTerminologyService sendTerminologyService;

    @Autowired
    public SendTerminologyController(SendTerminologyService sendTerminologyService) {
        this.sendTerminologyService = sendTerminologyService;
    }

    protected SendTerminologyController() {
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllEmployees() {
        logger.info("Getting full terminology");

        boolean firstSendTerminologyService = true;
        long count = sendTerminologyService.count();
        Iterable<SendTerminology> terminology = sendTerminologyService.findAll();
        StringBuffer bodyResponse = new StringBuffer("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"terminology\":[");
        try {
            for (SendTerminology term : terminology) {
                if (firstSendTerminologyService) {
                	firstSendTerminologyService = false;
                } else {
                    bodyResponse.append(",");
                }
                bodyResponse.append(JsonUtils.mapToJson(term));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        bodyResponse.append("]}");
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

  
    @RequestMapping(method = RequestMethod.GET, path = "/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getTerminologyByCode(@PathVariable(value = "code") String code) {
        logger.info("Getting terminology for code: " + code);

        List<String> terminology = sendTerminologyService.findByCode(code);
        if (terminology == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No terminology found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(terminology));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    @RequestMapping(method = RequestMethod.GET, path = "/codelistname/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCodeListNames() {
        logger.info("Getting Codes: ");
        List<String> codeNames = sendTerminologyService.findCodeNames();
        if (codeNames == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No CodeNameList found.\"}");
        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(codeNames));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/codename/{codename}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCodeByCodeName(@PathVariable(value = "codename") String codename) {
        logger.info("Getting Code for: " + codename);
        String code = sendTerminologyService.getCodeByCodeName(codename);
        if (code == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No code found with given codename.\"}");
        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(code));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
}
