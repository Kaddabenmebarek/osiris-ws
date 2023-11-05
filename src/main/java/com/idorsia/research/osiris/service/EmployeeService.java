package com.idorsia.research.osiris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idorsia.research.osiris.entity.Employee;
import com.idorsia.research.osiris.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> findAll() { return employeeRepository.findAll(); }

    public long count() { return employeeRepository.count(); }

    public Optional<Employee> findByEmployeeId(Integer employeeId) {
        return this.employeeRepository.findByEmployeeId(employeeId);
    }
    
    public Optional<Employee> findByUserId(String employeeId) {
        return this.employeeRepository.findByUserId(employeeId);
    }
    
    public List<Employee> findByManagerId(Integer managerId) {
        return this.employeeRepository.findByManagerId(managerId);
    }
    
    public List<String> findScientificPeople(){
    	return this.employeeRepository.findScientificPeople();
    }

	public List<String> findGroupsByUserId(String userId) {
		return this.employeeRepository.findGroupsByUserName(userId);
	}

	public List<String> findGroupIdsByUserId(String userId) {
		List<String> groupIds = new ArrayList<String>();
		List<Integer> groups = this.employeeRepository.findGroupIdsByUserId(userId);
		for(Integer grouId : groups) {
			groupIds.add(String.valueOf(grouId));
		}
		return groupIds;
	}


}
