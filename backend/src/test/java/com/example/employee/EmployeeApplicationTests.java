package com.example.employee;


import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.controller.EmployeeController;

import java.time.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EmployeeApplicationTests {
	private static Employee e1;
	private static Employee e2;
	private static Employee e3;
	private static Employee e4;

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	private EmployeeRepository employeeRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeAll
  public static void init() {
		e1 = new Employee("William", "Holmes", "Developer", LocalDate.parse("1980-05-04"), LocalDate.parse("2013-02-01"), null);
		e2 = new Employee("Jack", "Spiro", "Sales", LocalDate.parse("1975-06-25"), LocalDate.parse("2014-08-01"), LocalDate.parse("2018-05-25"));
		e3 = new Employee("John", "Doe", "Engineer", LocalDate.parse("1980-11-15"), LocalDate.parse("2017-05-01"), null);
		e4 = new Employee("Dwayne", "Johnson", "Designer", LocalDate.parse("1985-02-10"), LocalDate.parse("2019-04-01"), null);
  }

	@Test
	void contextLoads() {
	}

	@Test
	void findEmployees_whenNoRecord() {
		Mockito.when(employeeRepo.findAll()).thenReturn(Arrays.asList());
		Assertions.assertEquals(new ResponseEntity<>(HttpStatus.NO_CONTENT), employeeController.getAllEmployees(null, null, null));
		Assertions.assertEquals(null, employeeController.getAllEmployees(null, null, null).getBody());
	}

	@Test
	void findAllEmployees() {
		List<Employee> employees = Arrays.asList(e1, e2, e3);
		Mockito.when(employeeRepo.findAll()).thenReturn(employees);
		Assertions.assertEquals(new ResponseEntity<>(employees, HttpStatus.OK), employeeController.getAllEmployees(null, null, null));
		Assertions.assertEquals(3, employeeController.getAllEmployees(null, null, null).getBody().size());
	}

	@Test
	void findEmployeesByFirstOrLastName() {
		List<Employee> employees = Arrays.asList(e2, e3, e4);
		Mockito.when(employeeRepo.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual("J", LocalDate.now()))
														 .thenReturn(employees);

		String nameStr = "J";
		ResponseEntity<List<Employee>> result = employeeController.getAllEmployees(nameStr, null, null);
		Assertions.assertEquals(new ResponseEntity<>(employees, HttpStatus.OK), result);
		Assertions.assertEquals(3, result.getBody().size());
		Assertions.assertEquals("Jack", result.getBody().get(0).getFirstName());
		Assertions.assertEquals("John", result.getBody().get(1).getFirstName());
		Assertions.assertEquals("Dwayne", result.getBody().get(2).getFirstName());
	}

	@Test
	void findEmployeesByFirstOrLastName_startingFromDate() {
		List<Employee> employees = Arrays.asList(e2, e4);
		Mockito.when(employeeRepo.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual("J", LocalDate.parse("2018-01-01"), LocalDate.now()))
														 .thenReturn(employees);

		String startDate = "2018-01-01", nameStr = "J";
		ResponseEntity<List<Employee>> result = employeeController.getAllEmployees(nameStr, startDate, null);
		Assertions.assertEquals(new ResponseEntity<>(employees, HttpStatus.OK), result);
		Assertions.assertEquals(2, result.getBody().size());
		Assertions.assertEquals("Jack", result.getBody().get(0).getFirstName());
		Assertions.assertEquals("Dwayne", result.getBody().get(1).getFirstName());
	}

	@Test
	void findEmployeesWorkingBetweenTwoDates() {
		List<Employee> employees = Arrays.asList(e1, e2);
		LocalDate startDate = LocalDate.parse("2013-01-01");
		LocalDate endDate = LocalDate.parse("2015-01-01");
		Mockito.when(employeeRepo.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual("", startDate, endDate))
														 .thenReturn(employees);

		ResponseEntity<List<Employee>> result = employeeController.getAllEmployees("", startDate.toString(), endDate.toString());
		Assertions.assertEquals(new ResponseEntity<>(employees, HttpStatus.OK), result);
		Assertions.assertEquals(2, result.getBody().size());
		Assertions.assertEquals("William", result.getBody().get(0).getFirstName());
		Assertions.assertEquals("Jack", result.getBody().get(1).getFirstName());
	}

	@Test
	void findEmployeesWorkingUntilDate() {
		List<Employee> employees = Arrays.asList(e1, e2, e3);
		LocalDate endDate = LocalDate.parse("2018-01-01");
		Mockito.when(employeeRepo.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual("", endDate))
														 .thenReturn(employees);

		ResponseEntity<List<Employee>> result = employeeController.getAllEmployees(null, null, endDate.toString());
		Assertions.assertEquals(new ResponseEntity<>(employees, HttpStatus.OK), result);
		Assertions.assertEquals(3, result.getBody().size());
		Assertions.assertEquals("William", result.getBody().get(0).getFirstName());
		Assertions.assertEquals("Jack", result.getBody().get(1).getFirstName());
		Assertions.assertEquals("John", result.getBody().get(2).getFirstName());
	}

	@Test
	void testCreateEmployee() {
		Mockito.when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(e3);
		ResponseEntity<Employee> result = employeeController.createEmployee(e3);
		Assertions.assertEquals(new ResponseEntity<>(e3, HttpStatus.CREATED), result);
	}
}
