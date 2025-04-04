package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BLMS_VEHICLE_LOAN_DETAILS")
public class BLMS_VEHICLE_DET_ENTITY {
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_of_birth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	date_of_application;
	private String phone_number;
	private String email_id;
	private String home_address;
	private String marital_status;
	private String place_of_work;
	private String job_title;
	private String work_address;
	private String service;
	private String monthly_income;
	private String annual_income;
	private String employer;
	private String employment_nature;
	private String vehicle_type;
	private String vehicle_value;
	private String vehicle_model;
	private String registration_number;
	private String dealer_name;
	private String dealer_address;
	private String entity_user;
	private String modify_user;
	private String verify_user;
	private Date entity_time;
	private Date modify_time;
	private Date verify_time;
	private String entity_flg;
	private String modify_flg;
	private String verify_flg;
	private String del_flg;
	@Id
	private String id;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public Date getDate_of_application() {
		return date_of_application;
	}


	public void setDate_of_application(Date date_of_application) {
		this.date_of_application = date_of_application;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getHome_address() {
		return home_address;
	}


	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}


	public String getMarital_status() {
		return marital_status;
	}


	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}


	public String getPlace_of_work() {
		return place_of_work;
	}


	public void setPlace_of_work(String place_of_work) {
		this.place_of_work = place_of_work;
	}


	public String getJob_title() {
		return job_title;
	}


	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}


	public String getWork_address() {
		return work_address;
	}


	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getMonthly_income() {
		return monthly_income;
	}


	public void setMonthly_income(String monthly_income) {
		this.monthly_income = monthly_income;
	}


	public String getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(String annual_income) {
		this.annual_income = annual_income;
	}


	public String getEmployer() {
		return employer;
	}


	public void setEmployer(String employer) {
		this.employer = employer;
	}


	public String getEmployment_nature() {
		return employment_nature;
	}


	public void setEmployment_nature(String employment_nature) {
		this.employment_nature = employment_nature;
	}


	public String getVehicle_type() {
		return vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}


	public String getVehicle_value() {
		return vehicle_value;
	}


	public void setVehicle_value(String vehicle_value) {
		this.vehicle_value = vehicle_value;
	}


	public String getVehicle_model() {
		return vehicle_model;
	}


	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}


	public String getRegistration_number() {
		return registration_number;
	}


	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}


	public String getDealer_name() {
		return dealer_name;
	}


	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}


	public String getDealer_address() {
		return dealer_address;
	}


	public void setDealer_address(String dealer_address) {
		this.dealer_address = dealer_address;
	}


	public String getEntity_user() {
		return entity_user;
	}


	public void setEntity_user(String entity_user) {
		this.entity_user = entity_user;
	}


	public String getModify_user() {
		return modify_user;
	}


	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}


	public String getVerify_user() {
		return verify_user;
	}


	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}


	public Date getEntity_time() {
		return entity_time;
	}


	public void setEntity_time(Date entity_time) {
		this.entity_time = entity_time;
	}


	public Date getModify_time() {
		return modify_time;
	}


	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}


	public Date getVerify_time() {
		return verify_time;
	}


	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}


	public String getEntity_flg() {
		return entity_flg;
	}


	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}


	public String getModify_flg() {
		return modify_flg;
	}


	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}


	public String getVerify_flg() {
		return verify_flg;
	}


	public void setVerify_flg(String verify_flg) {
		this.verify_flg = verify_flg;
	}


	public String getDel_flg() {
		return del_flg;
	}


	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public BLMS_VEHICLE_DET_ENTITY(String name, Date date_of_birth, Date date_of_application, String phone_number,
			String email_id, String home_address, String marital_status, String place_of_work, String job_title,
			String work_address, String service, String monthly_income, String annual_income, String employer,
			String employment_nature, String vehicle_type, String vehicle_value, String vehicle_model,
			String registration_number, String dealer_name, String dealer_address, String entity_user,
			String modify_user, String verify_user, Date entity_time, Date modify_time, Date verify_time,
			String entity_flg, String modify_flg, String verify_flg, String del_flg, String id) {
		super();
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.date_of_application = date_of_application;
		this.phone_number = phone_number;
		this.email_id = email_id;
		this.home_address = home_address;
		this.marital_status = marital_status;
		this.place_of_work = place_of_work;
		this.job_title = job_title;
		this.work_address = work_address;
		this.service = service;
		this.monthly_income = monthly_income;
		this.annual_income = annual_income;
		this.employer = employer;
		this.employment_nature = employment_nature;
		this.vehicle_type = vehicle_type;
		this.vehicle_value = vehicle_value;
		this.vehicle_model = vehicle_model;
		this.registration_number = registration_number;
		this.dealer_name = dealer_name;
		this.dealer_address = dealer_address;
		this.entity_user = entity_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.entity_time = entity_time;
		this.modify_time = modify_time;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.verify_flg = verify_flg;
		this.del_flg = del_flg;
		this.id = id;
	}


	public BLMS_VEHICLE_DET_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
