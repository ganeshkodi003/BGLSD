package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BLMS_PERSONAL_LOAN_DETAILS")
public class BLMS_PERSONAL_LOAN_ENTITY {
	private String	name;
	private Date	date_of_birth;
	private String	phone_number;
	private String	email_id;
	private String	home_address;
	private String	marital_status;
	private String	place_of_work;
	private String	job_title;
	private String	work_address;
	private String	service;
	private BigDecimal	monthly_income;
	private BigDecimal	annual_income;
	private String	employer;
	private String	employment_nature;
	private String	purpose_of_personal_loan;
	private BigDecimal	loan_amount;
	private BigDecimal	rate_of_interest;
	private BigDecimal	repayment_period;
	private BigDecimal	monthly_installment;
	private String	remarks;
	private String	entity_user;
	private String	modify_user;
	private String	verify_user;
	private Date	entity_time;
	private Date	modify_time;
	private Date	verify_time;
	private String	entity_flg;
	private String	modify_flg;
	private String	verify_flg;
	private String	del_flg;
	@Id
	private String	id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public BigDecimal getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(BigDecimal monthly_income) {
		this.monthly_income = monthly_income;
	}
	public BigDecimal getAnnual_income() {
		return annual_income;
	}
	public void setAnnual_income(BigDecimal annual_income) {
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
	public String getPurpose_of_personal_loan() {
		return purpose_of_personal_loan;
	}
	public void setPurpose_of_personal_loan(String purpose_of_personal_loan) {
		this.purpose_of_personal_loan = purpose_of_personal_loan;
	}
	public BigDecimal getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(BigDecimal loan_amount) {
		this.loan_amount = loan_amount;
	}
	public BigDecimal getRate_of_interest() {
		return rate_of_interest;
	}
	public void setRate_of_interest(BigDecimal rate_of_interest) {
		this.rate_of_interest = rate_of_interest;
	}
	public BigDecimal getRepayment_period() {
		return repayment_period;
	}
	public void setRepayment_period(BigDecimal repayment_period) {
		this.repayment_period = repayment_period;
	}
	public BigDecimal getMonthly_installment() {
		return monthly_installment;
	}
	public void setMonthly_installment(BigDecimal monthly_installment) {
		this.monthly_installment = monthly_installment;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	public BLMS_PERSONAL_LOAN_ENTITY(String name, Date date_of_birth, String phone_number, String email_id,
			String home_address, String marital_status, String place_of_work, String job_title, String work_address,
			String service, BigDecimal monthly_income, BigDecimal annual_income, String employer,
			String employment_nature, String purpose_of_personal_loan, BigDecimal loan_amount,
			BigDecimal rate_of_interest, BigDecimal repayment_period, BigDecimal monthly_installment, String remarks,
			String entity_user, String modify_user, String verify_user, Date entity_time, Date modify_time,
			Date verify_time, String entity_flg, String modify_flg, String verify_flg, String del_flg, String id) {
		super();
		this.name = name;
		this.date_of_birth = date_of_birth;
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
		this.purpose_of_personal_loan = purpose_of_personal_loan;
		this.loan_amount = loan_amount;
		this.rate_of_interest = rate_of_interest;
		this.repayment_period = repayment_period;
		this.monthly_installment = monthly_installment;
		this.remarks = remarks;
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
	public BLMS_PERSONAL_LOAN_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

}
