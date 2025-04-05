package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SB_AccountMasterEntityRepo extends JpaRepository<SB_AccountMasterEntity, String> {

@Query(value = "SELECT NEXT VALUE FOR LOAN_ACCOUNT_MASTER", nativeQuery = true)
String getNextLoanAccountNo();

@Query(value = "SELECT * From BLMS_SB_LOAN_MASTER where Customer_id = ?1", nativeQuery = true)
SB_AccountMasterEntity getcustomeraccount(String accountno);
  
}