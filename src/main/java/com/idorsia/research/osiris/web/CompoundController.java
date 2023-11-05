package com.idorsia.research.osiris.web;

import java.util.List;
import java.util.Optional;

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
import com.idorsia.research.osiris.entity.Compound;
import com.idorsia.research.osiris.service.CompoundService;


@RestController
@RequestMapping(path = "/compound")
public class CompoundController {
    private static Logger logger = LogManager.getLogger(CompoundController.class);
    private CompoundService compoundService;

    @Autowired
    public CompoundController(CompoundService compoundService) {
        this.compoundService = compoundService;
    }

    protected CompoundController() {
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{chemLabJournal}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCompound(@PathVariable(value = "chemLabJournal") String chemLabJournal) {
        logger.info("Getting compound for lab journal: " + chemLabJournal);

        Optional<Compound> compound = compoundService.findByChemLabJournal(chemLabJournal);
        if (compound == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Given lab journal doesn't match.\"}");

        }
        Compound cmpd = compound.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(cmpd));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/compounds/{compoundName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCompoundByName(@PathVariable(value = "compoundName") String compoundName) {
        logger.info("Getting compounds for : " + compoundName);

        List<Compound> compounds = compoundService.findByName(compoundName);
        if (compounds == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No compound found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(compounds));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

}
