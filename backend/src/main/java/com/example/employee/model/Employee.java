package com.example.employee.model;

import javax.persistence.*;
import java.util.Date;

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
  private Date dateOfBirth;

  @Column(name = "startDate")
  private Date startDate;

  @Column(name = "endDate")
  private Date endDate;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String jobTitle, Date dateOfBirth, Date startDate, Date endDate) {
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

  public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
  }

  public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
  }

  public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
  }

	@Override
	public String toString() {
    return "Employee (id=" + id + ") " + firstName + " " + lastName + " was hired on " + startDate;
	}
}
