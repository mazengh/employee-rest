package com.example.employee.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

  @Column(name = "firstName")
  private String firstName;

	@Column(name = "lastName")
  private String lastName;

  @Column(name = "jobTitle")
  private String jobTitle;

  @Column(name = "dateOfBirth")
  private LocalDate dateOfBirth;

  @Column(name = "hireDate")
  private LocalDate hireDate;

  @Column(name = "leaveDate")
  private LocalDate leaveDate;

	public Employee() {}

	public Employee(String firstName, String lastName, String jobTitle, LocalDate dateOfBirth, LocalDate hireDate, LocalDate leaveDate) {
		this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.dateOfBirth = dateOfBirth;
    this.hireDate = hireDate;
    this.leaveDate = leaveDate;
	}

	public long getId() {
		return id;
	}

  public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
  }

  public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
  }

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
  }

  public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
  }

  public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
  }

  public LocalDate getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
  }

	@Override
	public String toString() {
    return "Employee (id=" + id + ") " + firstName + " " + lastName + " was hired on " + hireDate;
	}
}
