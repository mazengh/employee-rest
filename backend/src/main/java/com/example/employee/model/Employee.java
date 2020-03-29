package com.example.employee.model;

import javax.persistence.*;
import java.time.LocalDate;

// name, job title, age, start and end date of employment

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

  @Column(name = "startDate")
  private LocalDate startDate;

  @Column(name = "endDate")
  private LocalDate endDate;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String jobTitle, LocalDate dateOfBirth, LocalDate startDate, LocalDate endDate) {
		this.firstName = firstName;
    this.lastName = lastName;
    this.jobTitle = jobTitle;
    this.dateOfBirth = dateOfBirth;
    this.startDate = startDate;
    this.endDate = endDate;
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

  public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
  }

  public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
  }

	@Override
	public String toString() {
    return "Employee (id=" + id + ") " + firstName + " " + lastName + " was hired on " + startDate;
	}
}
