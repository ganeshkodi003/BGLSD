package com.bornfire.services;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.entities.BACP_CUS_PROFILE_REPO;
import com.bornfire.entities.Chart_Acc_Entity;
import com.bornfire.entities.Chart_Acc_Rep;
import com.bornfire.entities.DMD_TABLE;
import com.bornfire.entities.DMD_TABLE_REPO;
import com.bornfire.entities.LeaseData;
import com.bornfire.entities.Lease_Loan_Master_Entity;
import com.bornfire.entities.Lease_Loan_Master_Repo;
import com.bornfire.entities.Lease_Loan_Work_Entity;
import com.bornfire.entities.Lease_Loan_Work_Repo;
import com.bornfire.entities.Loan_Repayment_Master_Entity;
import com.bornfire.entities.Loan_Repayment_Master_Repo;
import com.bornfire.entities.NoticeDetailsPayment0Entity;
import com.bornfire.entities.NoticeDetailsPayment0Rep;
import com.bornfire.entities.SB_AccountMasterEntity;
import com.bornfire.entities.SB_AccountMasterEntityRepo;
import com.bornfire.entities.TestPrincipalCalculation;

@Service
public class LeaseLoanService {

	@Autowired
	Lease_Loan_Work_Repo lease_Loan_Work_Repo;

	@Autowired
	NoticeDetailsPayment0Rep paymentWorkRepo;

	@Autowired
	Lease_Loan_Master_Repo lease_Loan_Master_Repo;

	@Autowired
	Loan_Repayment_Master_Repo loan_Repayment_Master_Repo;

	@Autowired
	DMD_TABLE_REPO dMD_TABLE_REPO;
	
	@Autowired
	Chart_Acc_Rep chart_Acc_Rep;
	
	@Autowired
	BACP_CUS_PROFILE_REPO bACP_CUS_PROFILE_REPO;

	@Autowired
	InterestCalculationServices interestCalculationServices;

	@Autowired
	SB_AccountMasterEntityRepo sb_AccountMasterEntityRepo;

	public String addLeaseLoan(LeaseData leaseRecord, String entryUser) {

		boolean flag = true;
		String msg = "";

		Lease_Loan_Work_Entity loandetails = leaseRecord.getLoanDetails();
		SB_AccountMasterEntity sbAcctDetails = convertToSBAccountMaster(leaseRecord.getLoanDetails());
		if (Objects.nonNull(loandetails.getLoan_accountno())) {
			loandetails.setEntry_user(entryUser);
			loandetails.setEntry_time(new Date());
			loandetails.setModify_user(entryUser);
			loandetails.setModify_time(new Date());
			loandetails.setEntity_flg("N");
			loandetails.setDel_flg("N");

			Chart_Acc_Entity coa = new Chart_Acc_Entity();

					coa.setAcct_num(sbAcctDetails.getLoan_accountno());
					coa.setAcct_name(loandetails.getCustomer_name());
					coa.setAcct_crncy(loandetails.getLoan_currency());
					coa.setAcct_bal(BigDecimal.ZERO);
					coa.setCr_amt(BigDecimal.ZERO);
					coa.setDr_amt(BigDecimal.ZERO);
					coa.setGl_code(sbAcctDetails.getGl_code());
					coa.setGl_desc(sbAcctDetails.getGl_desc());
					coa.setGlsh_code(sbAcctDetails.getGlsh_code());
					coa.setGlsh_desc(sbAcctDetails.getGlsh_desc());
					coa.setSchm_code(sbAcctDetails.getScheme_code());
					coa.setSchm_type(sbAcctDetails.getScheme_type());
					coa.setClassification("Asset");
					coa.setBank_acc_name(loandetails.getLoan_accountno());
					coa.setAdd_det_flg("N");
					coa.setEntity_flg("Y");
					coa.setDel_flg("N");
					coa.setAcct_status("Y");
					coa.setAcct_cls_flg("N");
					coa.setAcct_type("L");

					chart_Acc_Rep.save(coa);


		} else {
			flag = false;
		}

		NoticeDetailsPayment0Entity repaymentDetails = leaseRecord.getRepaymentDetails();
		if (Objects.nonNull(repaymentDetails.getAccount_no())) {
			repaymentDetails.setEntry_usr(entryUser);
			repaymentDetails.setEntry_tm(new Date());
			repaymentDetails.setMod_usr(entryUser);
			repaymentDetails.setMod_tm(new Date());
			repaymentDetails.setEntity_flg("N");
			repaymentDetails.setDel_flg("N");
		} else {
			flag = false;
		}

		if (flag) {
			lease_Loan_Work_Repo.save(loandetails);
			sb_AccountMasterEntityRepo.save(sbAcctDetails);
			paymentWorkRepo.save(repaymentDetails);
			String demandFlow = disbursementDemand(loandetails,entryUser);
			System.out.println(demandFlow);
			 
			msg = "Loan Account Created Successfully";
		} else {
			msg = "Loan Account Created Failed";
		}
		return msg;
	}
// converting the leaseloan entity to sb account entity
	private SB_AccountMasterEntity convertToSBAccountMaster(Lease_Loan_Work_Entity loanDetails) {
		SB_AccountMasterEntity sbAccount = new SB_AccountMasterEntity();

		// Get all declared fields from both classes
		Field[] loanFields = Lease_Loan_Work_Entity.class.getDeclaredFields();
		Field[] sbFields = SB_AccountMasterEntity.class.getDeclaredFields();

		for (Field loanField : loanFields) {
			loanField.setAccessible(true); // Allow access to private fields
			try {
				Object value = loanField.get(loanDetails); // Get value from loanDetails

				// Find the matching field in SB_AccountMasterEntity
				for (Field sbField : sbFields) {
					if (sbField.getName().equals(loanField.getName())) {
						sbField.setAccessible(true);
						sbField.set(sbAccount, value); // Set value to sbAccount
						break;
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		// Set additional specific values (if any)
		sbAccount.setLoan_accountno("SB0000"+sb_AccountMasterEntityRepo.getNextLoanAccountNo());
		sbAccount.setEntry_time(new Date());
		sbAccount.setModify_time(new Date());
		sbAccount.setScheme_type("SBA");
		sbAccount.setScheme_code("SBGEN");
		sbAccount.setGl_code("2000002010");
		sbAccount.setGl_desc("Deposits");
		sbAccount.setGlsh_code("2010");
		sbAccount.setGlsh_desc("SBGeneral");

		

		return sbAccount;
	}
	public String verifyleaseloan(String accountNo, String entryUser) {

		boolean flag = true;
		String msg = "";

		Lease_Loan_Work_Entity loandetails = lease_Loan_Work_Repo.getLeaseAccount(accountNo);
		Lease_Loan_Master_Entity masterLoan = new Lease_Loan_Master_Entity(loandetails);

		if (Objects.nonNull(masterLoan.getLoan_accountno())) {
			masterLoan.setVerify_user(entryUser);
			masterLoan.setVerify_time(new Date());
			masterLoan.setEntity_flg("Y");

		} else {
			flag = false;
		}

		NoticeDetailsPayment0Entity repaymentDetails = paymentWorkRepo.getPaymentDetails(accountNo);
		Loan_Repayment_Master_Entity masterPayment = new Loan_Repayment_Master_Entity(repaymentDetails);

		if (Objects.nonNull(masterPayment.getAccount_no())) {

			masterPayment.setVer_usr(entryUser);
			masterPayment.setVer_tm(new Date());
			masterPayment.setEntity_flg("Y");

		} else {
			flag = false;
		}

		if (flag) {
			lease_Loan_Master_Repo.save(masterLoan);
			loan_Repayment_Master_Repo.save(masterPayment);

			/*
			 * String demandFlow = disbursementDemand(masterLoan,entryUser);
			 * System.out.println(demandFlow);
			 */
			String principalFlow = principalAndInterestDemand(masterLoan, masterPayment,entryUser);
			System.out.println(principalFlow);

			lease_Loan_Work_Repo.deleteRecord(loandetails.getLoan_accountno());
			paymentWorkRepo.deleteRecord(repaymentDetails.getAccount_no());
			
			msg = "Lease Account Verified Successfully";
		} else {
			msg = "Lease Account Verified Failed";
		}

		return msg;
	}

	public String disbursementDemand(Lease_Loan_Work_Entity master,String user) {

		DMD_TABLE demand = new DMD_TABLE();

		BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();

		demand.setLoan_acct_no(master.getLoan_accountno());
		demand.setLoan_acid(master.getLoan_accountno());
		demand.setAcct_name(master.getCustomer_name());
		demand.setFlow_id(BigDecimal.ONE);
		demand.setFlow_code("DISBT");
		demand.setFlow_date(master.getDate_of_loan());
		demand.setFlow_amt(master.getLoan_sanctioned());
		demand.setFlow_crncy_code(master.getLoan_currency());
		demand.setEntry_time(new Date());
		demand.setEntry_user(user);
		demand.setDel_flg("N");
		demand.setSrl_no(srlNo);

		dMD_TABLE_REPO.save(demand);

		return "Disbursement Demand Updated";
	}

	public String principalAndInterestDemand(Lease_Loan_Master_Entity master,
			Loan_Repayment_Master_Entity paymentMaster,String user) {

		int no_of_inst = Integer.valueOf(paymentMaster.getNo_of_inst());

		Date start_date = paymentMaster.getInst_start_dt();

		LocalDate startDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDate = startDate.plus(no_of_inst, ChronoUnit.MONTHS);

		Date calculatedEndDate = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		BigDecimal product = master.getLoan_sanctioned();
		BigDecimal productAmt = master.getLoan_sanctioned();
		BigDecimal intRate = master.getEffective_interest_rate();
		BigDecimal instmentAmount = paymentMaster.getInst_amount();
		String principle_frequency = paymentMaster.getInst_freq();
		String interestFrequency = paymentMaster.getInterest_frequency();
		String SchmeType = master.getLoan_type();

		List<TestPrincipalCalculation> InterestAmount = interestCalculationServices.calculatePrincialPaymentNotice(
				start_date, calculatedEndDate, product, productAmt, principle_frequency, intRate, no_of_inst,
				instmentAmount, interestFrequency,SchmeType);

		int toltalInstallment = InterestAmount.size();

		List<DMD_TABLE> principleAndInterest = new ArrayList<>();

		int noOfInstallment = 1;
		int noOfprincipalInstallment = 1;

		if (toltalInstallment > 0) {
			for (TestPrincipalCalculation record : InterestAmount) {
				DMD_TABLE entity = new DMD_TABLE();

				entity.setLoan_acid(master.getLoan_accountno());
				entity.setLoan_acct_no(master.getLoan_accountno());
				entity.setAcct_name(master.getCustomer_name());
				entity.setFlow_id(BigDecimal.valueOf(noOfInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());
				entity.setFlow_crncy_code(master.getLoan_currency());

				entity.setFlow_amt(record.getInterestAmount());
				entity.setFlow_code("INDEM");

				entity.setEntry_time(new Date());
				entity.setEntry_user(user);
				entity.setDel_flg("N");

				BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();
				entity.setSrl_no(srlNo);

				noOfInstallment++;
				principleAndInterest.add(entity);
			}

			for (TestPrincipalCalculation record : InterestAmount) {
				DMD_TABLE entity = new DMD_TABLE();

				entity.setLoan_acid(master.getLoan_accountno());
				entity.setLoan_acct_no(master.getLoan_accountno());
				entity.setAcct_name(master.getCustomer_name());
				entity.setFlow_id(BigDecimal.valueOf(noOfprincipalInstallment));

				entity.setFlow_frq(record.getInstallmentFrequency());
				entity.setFlow_date(record.getInstallmentDate());
				entity.setFlow_crncy_code(master.getLoan_currency());

				entity.setFlow_amt(record.getPrincipalAmount());
				entity.setFlow_code("PRDEM");

				entity.setEntry_time(new Date());
				entity.setEntry_user(user);
				entity.setDel_flg("N");

				BigDecimal srlNo = dMD_TABLE_REPO.getSrlNo();
				entity.setSrl_no(srlNo);

				noOfprincipalInstallment++;
				principleAndInterest.add(entity);
			}

		} else {

		}

		dMD_TABLE_REPO.saveAll(principleAndInterest);

		return "Principle and Interest Demand Updated";

	}

}
