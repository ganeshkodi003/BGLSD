package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;

public class TestPrincipalCalculation {

	private Date installmentDate;
	private BigDecimal productValue;
	private BigDecimal product;
	private String installmentFrequency;
	private BigDecimal principalAmount;
	private BigDecimal principalAmountOutstanding;
	private BigDecimal interestPercentage;
	private BigDecimal interestAmount;
	private int numberOfDays;
	private String rateCode;
	private BigDecimal principalOverDue;
	private BigDecimal interestOverdue;
	private Date installmentFromDate;
	private String installmentDescription;
	private String paidamount;
	private BigDecimal chargesAmount; // ✅ New field for FEEDEM
	public Date getInstallmentDate() {
		return installmentDate;
	}
	public void setInstallmentDate(Date installmentDate) {
		this.installmentDate = installmentDate;
	}
	public BigDecimal getProductValue() {
		return productValue;
	}
	public void setProductValue(BigDecimal productValue) {
		this.productValue = productValue;
	}
	public BigDecimal getProduct() {
		return product;
	}
	public void setProduct(BigDecimal product) {
		this.product = product;
	}
	public String getInstallmentFrequency() {
		return installmentFrequency;
	}
	public void setInstallmentFrequency(String installmentFrequency) {
		this.installmentFrequency = installmentFrequency;
	}
	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}
	public BigDecimal getPrincipalAmountOutstanding() {
		return principalAmountOutstanding;
	}
	public void setPrincipalAmountOutstanding(BigDecimal principalAmountOutstanding) {
		this.principalAmountOutstanding = principalAmountOutstanding;
	}
	public BigDecimal getInterestPercentage() {
		return interestPercentage;
	}
	public void setInterestPercentage(BigDecimal interestPercentage) {
		this.interestPercentage = interestPercentage;
	}
	public BigDecimal getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getRateCode() {
		return rateCode;
	}
	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}
	public BigDecimal getPrincipalOverDue() {
		return principalOverDue;
	}
	public void setPrincipalOverDue(BigDecimal principalOverDue) {
		this.principalOverDue = principalOverDue;
	}
	public BigDecimal getInterestOverdue() {
		return interestOverdue;
	}
	public void setInterestOverdue(BigDecimal interestOverdue) {
		this.interestOverdue = interestOverdue;
	}
	public Date getInstallmentFromDate() {
		return installmentFromDate;
	}
	public void setInstallmentFromDate(Date installmentFromDate) {
		this.installmentFromDate = installmentFromDate;
	}
	public String getInstallmentDescription() {
		return installmentDescription;
	}
	public void setInstallmentDescription(String installmentDescription) {
		this.installmentDescription = installmentDescription;
	}
	public String getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}
	public BigDecimal getChargesAmount() {
		return chargesAmount;
	}
	public void setChargesAmount(BigDecimal chargesAmount) {
		this.chargesAmount = chargesAmount;
	}

}
