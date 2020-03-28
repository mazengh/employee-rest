package com.example.employee.repository;

import java.util.List;
import java.util.Date;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.example.employee.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
  List<Employee> findByFirstNameContaining(@Param("name") String name);
  List<Employee> findByLastNameContaining(@Param("name") String name);


  List<Employee> findByStartDateBetween(@Param("start") Date start, @Param("end") Date end);

  // @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name%) and (:start is null or e.startDate BETWEEN :start and :end)")
  // List<Employee> findByFirstNameContainingAndStartDateBetween(@Param("name") String name, @Param("start") Date start, @Param("end") Date end);

  @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name% or e.lastName like %:name%) and (:start is null or e.startDate BETWEEN :start and :end)")
  List<Employee> findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual(@Param("name") String name, @Param("start") Date start, @Param("end") Date end);


  // @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name%) and (:end is null or e.startDate <= :end)")
  // List<Employee> findByFirstNameContainingAndStartDateLessThanEqual(@Param("name") String name, @Param("end") Date end);

  @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name% or e.lastName like %:name%) and (:end is null or e.startDate <= :end)")
  List<Employee> findByFirstNameContainingOrLastNameContainingAndStartDateLessThanEqual(@Param("name") String name, @Param("end") Date end);

}
