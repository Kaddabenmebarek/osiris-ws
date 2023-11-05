package com.idorsia.research.osiris.repository;

import com.idorsia.research.osiris.entity.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.employeeId = ?1")
	Optional<Employee> findByEmployeeId(Integer employeeId);

	@Query("select e from Employee e where e.managerId = ?1")
	List<Employee> findByManagerId(Integer managerId);

	@Query("select e from Employee e where e.userName = ?1")
	Optional<Employee> findByUserId(String employeeId);

	@Query(value = "SELECT distinct(e.user_name) FROM employee e, employee_group_link egl WHERE e.employee_id = egl.employee_id AND egl.group_id not in (16377,16381,20648,16424,20694,20697,20698,20882,20883,20884,20921,20922,20720,20723,20726,20840,20900,20008,20760,20560,20564,20640,20641,20656,20667,20674,20684,21000,21002,21003,21005,21006,21007,21010,21013,21014,21015,21120,21121,21481,21482,21487,21490,21491,21492,21501) AND e.lastworkingdate is null order by user_name", nativeQuery = true)
	List<String> findScientificPeople();

	@Query(value = "SELECT g.GROUP_NAME FROM employee_group g, employee_group_link l WHERE l.group_id = g.group_id AND l.employee_id = ?1", nativeQuery = true)
	List<String> findGroupsByUserId(Integer userId);
	
	@Query(value = "SELECT g.group_name FROM employee_group g, employee_group_link l, employee e WHERE l.group_id = g.group_id AND l.employee_id = e.employee_id AND e.USER_NAME = ?1", nativeQuery = true)
	List<String> findGroupsByUserName(String userName);

	@Query(value = "SELECT g.group_id FROM employee_group g, employee_group_link l, employee e WHERE l.group_id = g.group_id AND l.employee_id = e.employee_id AND e.USER_NAME = ?1", nativeQuery = true)
	List<Integer> findGroupIdsByUserId(String userId);

}
