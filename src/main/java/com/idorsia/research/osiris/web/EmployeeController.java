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
import com.idorsia.research.osiris.entity.Employee;
import com.idorsia.research.osiris.service.EmployeeService;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private static Logger logger = LogManager.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    protected EmployeeController() {

    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllEmployees() {
        logger.info("Getting all Employees");

        boolean firstEmployee = true;
        long count = employeeService.count();
        Iterable<Employee> employees = employeeService.findAll();
        StringBuffer bodyResponse = new StringBuffer("{");
        bodyResponse.append("\"count\":\"" + count + "\",");
        bodyResponse.append("\"employees\":[");
        try {
            for (Employee employee : employees) {
                if (firstEmployee) {
                	firstEmployee = false;
                } else {
                    bodyResponse.append(",");
                }
                bodyResponse.append(JsonUtils.mapToJson(employee));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        bodyResponse.append("]}");

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json;encoding=UTF-8")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getEmployeeById(@PathVariable(value = "employeeId") Integer employeeId) {
        logger.info("Getting Employee: " + employeeId);

        Optional<Employee> employee = employeeService.findByEmployeeId(employeeId);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"Id doesn't match.\"}");

        }
        Employee empl = employee.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(empl));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getEmployeeByUserId(@PathVariable(value = "userId") String userId) {
        logger.info("Getting Employee: " + userId);

        Optional<Employee> employee = employeeService.findByUserId(userId);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"UserId doesn't match.\"}");

        }
        Employee empl = employee.get();
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(empl));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employees/manager/{managerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getEmployeeesByActNo(@PathVariable(value = "managerId") Integer managerId) {
        logger.info("Getting Employees for managerId: " + managerId);

        List<Employee> employees = employeeService.findByManagerId(managerId);
        if (employees == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Employee found with given manager Id.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(employees));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/scientific_people/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getEmployeeesByActNo() {
        logger.info("Getting Sceintific Employees: ");

        List<String> employees = employeeService.findScientificPeople();
        if (employees == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Employee found.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(employees));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getGroupsByEmployee(@PathVariable(value = "userId") String userId) {
        logger.info("Getting Groups for userId: " + userId);
        List<String> groups = employeeService.findGroupsByUserId(userId);
        if (groups == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Group found with given userId.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(groups));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/groups/ids/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getGroupIdsByEmployee(@PathVariable(value = "userId") String userId) {
        logger.info("Getting Groups for userId: " + userId);
        List<String> groups = employeeService.findGroupIdsByUserId(userId);
        if (groups == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Content-Type", "application/json")
                    .body("{\"errorMessage\":\"No Group found with given userId.\"}");

        }
        StringBuffer bodyResponse = new StringBuffer();
        try {
            bodyResponse.append(JsonUtils.mapToJson(groups));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(bodyResponse.toString());
    }
    
}
