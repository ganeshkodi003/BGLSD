package com.bornfire.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "BGLS_LOAN_PARAMETER")
public class Loan_Parameter_Entity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "SERIAL_NO")
	    private Long serialNo;

	    @Column(name = "LOAN_TYPE")
	    private String loanType;

	    @Column(name = "LOAN_CURRENCY")
	    private String loanCurrency;

	    @Column(name = "INTEREST_COMP_FREQ")
	    private String interestCompFreq;

	    @Column(name = "LOAN_MIN_AMOUNT")
	    private Double loanMinAmount;

	    @Column(name = "LOAN_MAX_AMOUNT")
	    private Double loanMaxAmount;

	    @Column(name = "LOAN_MIN_PERIOD")
	    private Integer loanMinPeriod;

	    @Column(name = "LOAN_MAX_PERIOD_FLAG")
	    private Character loanMaxPeriodFlag;

	    @Column(name = "INTEREST_RATE")
	    private Double interestRate;

	    @Column(name = "PREFERENTIAL_RATE")
	    private Double preferentialRate;

	    @Column(name = "INTEREST_BOOKING_FREQ")
	    private String interestBookingFreq;

	    @Column(name = "INTEREST_BOOKING_ACC")
	    private String interestBookingAcc;

	    @Column(name = "INTEREST_APP_FREQ")
	    private String interestAppFreq;

	    @Column(name = "INTEREST_APP_ACC")
	    private String interestAppAcc;

	    @Column(name = "PL_ACCOUNT")
	    private String plAccount;

	    @Column(name = "NPA_NORMS")
	    private String npaNorms;

	    @Column(name = "COLLATERAL_FLAG")
	    private Character collateralFlag;

	    @Column(name = "COLLATERAL_MARGIN")
	    private Double collateralMargin;

	    @Column(name = "DISBURSEMENT_METHOD")
	    private String disbursementMethod;

	    @Column(name = "DISBURSEMENT_ACCOUNT")
	    private String disbursementAccount;

	    @Column(name = "RECOVERY_METHOD")
	    private String recoveryMethod;

	    @Column(name = "RECOVERY_ACCOUNT")
	    private String recoveryAccount;

	    @Column(name = "LOAN_SCHEME")
	    private String loanScheme;

	    @Column(name = "ENTRY_USER")
	    private String entryUser;

	    @Column(name = "MODIFY_USER")
	    private String modifyUser;

	    @Column(name = "VERIFY_USER")
	    private String verifyUser;

	    @Column(name = "ENTRY_TIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date entryTime;

	    @Column(name = "MODIFY_TIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date modifyTime;

	    @Column(name = "VERIFY_TIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date verifyTime;

	    @Column(name = "DEL_FLG")
	    private String delFlg;

	    @Column(name = "ENTITY_CRE_FLG")
	    private String entityCreFlg;

	    @Column(name = "MODIFY_FLG")
	    private String modifyFlg;

	    @Column(name = "VERIFY_FLG")
	    private String VerifyFlg;
	    
		public String getVerifyFlg() {
			return VerifyFlg;
		}

		public void setVerifyFlg(String verifyFlg) {
			VerifyFlg = verifyFlg;
		}

		public Long getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(Long serialNo) {
			this.serialNo = serialNo;
		}

		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		public String getLoanCurrency() {
			return loanCurrency;
		}

		public void setLoanCurrency(String loanCurrency) {
			this.loanCurrency = loanCurrency;
		}

		public String getInterestCompFreq() {
			return interestCompFreq;
		}

		public void setInterestCompFreq(String interestCompFreq) {
			this.interestCompFreq = interestCompFreq;
		}

		public Double getLoanMinAmount() {
			return loanMinAmount;
		}

		public void setLoanMinAmount(Double loanMinAmount) {
			this.loanMinAmount = loanMinAmount;
		}

		public Double getLoanMaxAmount() {
			return loanMaxAmount;
		}

		public void setLoanMaxAmount(Double loanMaxAmount) {
			this.loanMaxAmount = loanMaxAmount;
		}

		public Integer getLoanMinPeriod() {
			return loanMinPeriod;
		}

		public void setLoanMinPeriod(Integer loanMinPeriod) {
			this.loanMinPeriod = loanMinPeriod;
		}

		public Character getLoanMaxPeriodFlag() {
			return loanMaxPeriodFlag;
		}

		public void setLoanMaxPeriodFlag(Character loanMaxPeriodFlag) {
			this.loanMaxPeriodFlag = loanMaxPeriodFlag;
		}

		public Double getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(Double interestRate) {
			this.interestRate = interestRate;
		}

		public Double getPreferentialRate() {
			return preferentialRate;
		}

		public void setPreferentialRate(Double preferentialRate) {
			this.preferentialRate = preferentialRate;
		}

		public String getInterestBookingFreq() {
			return interestBookingFreq;
		}

		public void setInterestBookingFreq(String interestBookingFreq) {
			this.interestBookingFreq = interestBookingFreq;
		}

		public String getInterestBookingAcc() {
			return interestBookingAcc;
		}

		public void setInterestBookingAcc(String interestBookingAcc) {
			this.interestBookingAcc = interestBookingAcc;
		}

		public String getInterestAppFreq() {
			return interestAppFreq;
		}

		public void setInterestAppFreq(String interestAppFreq) {
			this.interestAppFreq = interestAppFreq;
		}

		public String getInterestAppAcc() {
			return interestAppAcc;
		}

		public void setInterestAppAcc(String interestAppAcc) {
			this.interestAppAcc = interestAppAcc;
		}

		public String getPlAccount() {
			return plAccount;
		}

		public void setPlAccount(String plAccount) {
			this.plAccount = plAccount;
		}

		public String getNpaNorms() {
			return npaNorms;
		}

		public void setNpaNorms(String npaNorms) {
			this.npaNorms = npaNorms;
		}

		public Character getCollateralFlag() {
			return collateralFlag;
		}

		public void setCollateralFlag(Character collateralFlag) {
			this.collateralFlag = collateralFlag;
		}

		public Double getCollateralMargin() {
			return collateralMargin;
		}

		public void setCollateralMargin(Double collateralMargin) {
			this.collateralMargin = collateralMargin;
		}

		public String getDisbursementMethod() {
			return disbursementMethod;
		}

		public void setDisbursementMethod(String disbursementMethod) {
			this.disbursementMethod = disbursementMethod;
		}

		public String getDisbursementAccount() {
			return disbursementAccount;
		}

		public void setDisbursementAccount(String disbursementAccount) {
			this.disbursementAccount = disbursementAccount;
		}

		public String getRecoveryMethod() {
			return recoveryMethod;
		}

		public void setRecoveryMethod(String recoveryMethod) {
			this.recoveryMethod = recoveryMethod;
		}

		public String getRecoveryAccount() {
			return recoveryAccount;
		}

		public void setRecoveryAccount(String recoveryAccount) {
			this.recoveryAccount = recoveryAccount;
		}

		public String getLoanScheme() {
			return loanScheme;
		}

		public void setLoanScheme(String loanScheme) {
			this.loanScheme = loanScheme;
		}

		public String getEntryUser() {
			return entryUser;
		}

		public void setEntryUser(String entryUser) {
			this.entryUser = entryUser;
		}

		public String getModifyUser() {
			return modifyUser;
		}

		public void setModifyUser(String modifyUser) {
			this.modifyUser = modifyUser;
		}

		public String getVerifyUser() {
			return verifyUser;
		}

		public void setVerifyUser(String verifyUser) {
			this.verifyUser = verifyUser;
		}

		public Date getEntryTime() {
			return entryTime;
		}

		public void setEntryTime(Date entryTime) {
			this.entryTime = entryTime;
		}

		public Date getModifyTime() {
			return modifyTime;
		}

		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}

		public Date getVerifyTime() {
			return verifyTime;
		}

		public void setVerifyTime(Date verifyTime) {
			this.verifyTime = verifyTime;
		}

		public String getDelFlg() {
			return delFlg;
		}

		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}

		public String getEntityCreFlg() {
			return entityCreFlg;
		}

		public void setEntityCreFlg(String entityCreFlg) {
			this.entityCreFlg = entityCreFlg;
		}

		public String getModifyFlg() {
			return modifyFlg;
		}

		public void setModifyFlg(String modifyFlg) {
			this.modifyFlg = modifyFlg;
		}

		
		public Loan_Parameter_Entity(Long serialNo, String loanType, String loanCurrency, String interestCompFreq,
				Double loanMinAmount, Double loanMaxAmount, Integer loanMinPeriod, Character loanMaxPeriodFlag,
				Double interestRate, Double preferentialRate, String interestBookingFreq, String interestBookingAcc,
				String interestAppFreq, String interestAppAcc, String plAccount, String npaNorms, Character collateralFlag,
				Double collateralMargin, String disbursementMethod, String disbursementAccount, String recoveryMethod,
				String recoveryAccount, String loanScheme, String entryUser, String modifyUser, String verifyUser,
				Date entryTime, Date modifyTime, Date verifyTime, String delFlg, String entityCreFlg, String modifyFlg,
				String verifyFlg) {
			super();
			this.serialNo = serialNo;
			this.loanType = loanType;
			this.loanCurrency = loanCurrency;
			this.interestCompFreq = interestCompFreq;
			this.loanMinAmount = loanMinAmount;
			this.loanMaxAmount = loanMaxAmount;
			this.loanMinPeriod = loanMinPeriod;
			this.loanMaxPeriodFlag = loanMaxPeriodFlag;
			this.interestRate = interestRate;
			this.preferentialRate = preferentialRate;
			this.interestBookingFreq = interestBookingFreq;
			this.interestBookingAcc = interestBookingAcc;
			this.interestAppFreq = interestAppFreq;
			this.interestAppAcc = interestAppAcc;
			this.plAccount = plAccount;
			this.npaNorms = npaNorms;
			this.collateralFlag = collateralFlag;
			this.collateralMargin = collateralMargin;
			this.disbursementMethod = disbursementMethod;
			this.disbursementAccount = disbursementAccount;
			this.recoveryMethod = recoveryMethod;
			this.recoveryAccount = recoveryAccount;
			this.loanScheme = loanScheme;
			this.entryUser = entryUser;
			this.modifyUser = modifyUser;
			this.verifyUser = verifyUser;
			this.entryTime = entryTime;
			this.modifyTime = modifyTime;
			this.verifyTime = verifyTime;
			this.delFlg = delFlg;
			this.entityCreFlg = entityCreFlg;
			this.modifyFlg = modifyFlg;
			VerifyFlg = verifyFlg;
		}

		public Loan_Parameter_Entity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		
}
