package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String start,
                                                        @RequestParam(required = false) String end) {
    try {
      List<Employee> employees = new ArrayList<Employee>();
      if (name == null && start == null && end == null){
        employeeRepository.findAll().forEach(employees::add);
      }
      else {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String endDate = end == null ? formatter.format(date) : end;

        Date endInterval;
        endInterval = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

        if (start == null) {
          employeeRepository.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual(name, endInterval).forEach(employees::add);
        } else {
          Date startInterval = new SimpleDateFormat("yyyy-MM-dd").parse(start);
            employeeRepository.findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual(name, startInterval, endInterval).forEach(employees::add);
        }
      }

      if (employees.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(employees, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
    Optional<Employee> employeeData = employeeRepository.findById(id);

    if (employeeData.isPresent()) {
      return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/employees")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    try {
      Employee _employee = employeeRepository
          .save(new Employee(employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getStartDate(), employee.getEndDate()));
      return new ResponseEntity<>(_employee, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
    Optional<Employee> employeeData = employeeRepository.findById(id);

    if (employeeData.isPresent()) {
      Employee _employee = employeeData.get();
      _employee.setFirstName(employee.getFirstName());
      _employee.setLastName(employee.getLastName());
      _employee.setJobTitle(employee.getJobTitle());
      _employee.setDateOfBirth(employee.getDateOfBirth());
      _employee.setStartDate(employee.getStartDate());
      _employee.setEndDate(employee.getEndDate());
      return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
    try {
      employeeRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }

  @DeleteMapping("/employees")
  public ResponseEntity<HttpStatus> deleteAllEmployees() {
    try {
      employeeRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

  }
}
