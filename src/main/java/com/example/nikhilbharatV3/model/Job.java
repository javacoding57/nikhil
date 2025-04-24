package com.example.nikhilbharatV3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="applicationid")
	private Long applicationid;
	@Column(name="jobdesignation")
	private	String jobdesignation; //job title
	@Column(name="department")
	private	String department;
	@Column(name="salary")
	private	String salary;
	@Column(name="location")
	private	String location;
	@Column(name="noticepriod")
	private	String noticepriod;
	@Column(name="jobtype")
	private	String jobtype;
	@Column(name="jobdescription")
	private	String jobdescription;

	public Job() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(Long applicationid) {
		this.applicationid = applicationid;
	}

	public String getJobdesignation() {
		return jobdesignation;
	}

	public void setJobdesignation(String jobdesignation) {
		this.jobdesignation = jobdesignation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNoticepriod() {
		return noticepriod;
	}

	public void setNoticepriod(String noticepriod) {
		this.noticepriod = noticepriod;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", applicationid=" + applicationid + ", jobdesignation=" + jobdesignation
				+ ", department=" + department + ", salary=" + salary + ", location=" + location + ", noticepriod="
				+ noticepriod + ", jobtype=" + jobtype + ", jobdescription=" + jobdescription + "]";
	}


	
	
}
