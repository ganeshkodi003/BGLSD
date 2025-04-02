package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Profile_Rep extends JpaRepository<Employee_Profile, String>{
	
	@Query(value="SELECT EMPLOYEE_ID FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	List<String> getexistingData();
	
	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	List<Employee_Profile> getEmployeeList();
	
	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE WHERE EMPLOYEE_ID =?1", nativeQuery = true)
	Employee_Profile getEmployeeData(String employee_id);
	
	@Query(value="SELECT branch_desc FROM BGLS_EMPLOYEE_PROFILE where BRANCH_ID =?1 AND DEL_FLG='N'", nativeQuery = true)
	String getBranchName(String branch_id);
	
	@Query(value = "SELECT MAX(CAST(CASE WHEN PATINDEX('%[0-9]%', EMPLOYEE_ID) > 0 THEN SUBSTRING(EMPLOYEE_ID, PATINDEX('%[0-9]%', EMPLOYEE_ID), LEN(EMPLOYEE_ID)) ELSE '0' END AS INT)) AS max_numeric_part FROM BGLS_EMPLOYEE_PROFILE", nativeQuery = true)
	String getSrlNo();

	@Query(value="SELECT * FROM BGLS_EMPLOYEE_PROFILE where entity_flg='Y'", nativeQuery = true)
	List<Employee_Profile> getEmployeeVeifiedList();

	
}
