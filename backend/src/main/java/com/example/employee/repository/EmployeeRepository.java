package com.example.employee.repository;

import java.util.List;
import java.time.LocalDate;

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
  List<Employee> findByHireDateBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);

  @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name% or e.lastName like %:name%) and (:start is null or e.hireDate BETWEEN :start and :end)")
  List<Employee> findByFirstNameContainingOrLastNameContainingAndHireDateLessThanEqual(@Param("name") String name, @Param("start") LocalDate start, @Param("end") LocalDate end);

  @Query("SELECT e FROM Employee e WHERE (:name is null or e.firstName like %:name% or e.lastName like %:name%) and (:end is null or e.hireDate <= :end)")
  List<Employee> findByFirstNameContainingOrLastNameContainingAndHireDateLessThanEqual(@Param("name") String name, @Param("end") LocalDate end);

}
