package com.dataObjects;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
//allocationSize is must be 1 as by default it will be 50
@SequenceGenerator(allocationSize = 1, name = "sequence", sequenceName = "emp_id_seq" )
public class Employee {

	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence" )
	
	private Integer employeeId;
	
	@Column(name="employee_name",length=100,nullable=false)
	private String employeeName;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="date_of_joining")
	private Date doj;
	
	@Column(name="salary")
	private Double salary;
	
	/*
	 * @Embedded 
	 * private Address address;
	 */
	
	@Embedded 
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "perman_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name = "perman_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "perman_state_name"), name = "state")

	})
	private Address permanentAddress;
	
	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(column = @Column(name = "resis_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name = "resis_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "resis_state_name"), name = "state")

	})
	private Address resisdencyAddress;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Address getResisdencyAddress() {
		return resisdencyAddress;
	}
	public void setResisdencyAddress(Address resisdencyAddress) {
		this.resisdencyAddress = resisdencyAddress;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + "]";
	}
}
