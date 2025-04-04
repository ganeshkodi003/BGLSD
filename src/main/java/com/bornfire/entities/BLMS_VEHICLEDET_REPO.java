package com.bornfire.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BLMS_VEHICLEDET_REPO extends JpaRepository<BLMS_VEHICLE_DET_ENTITY, String> {

	@Query(value = "select NEXT VALUE FOR BLMS_PERSONAL_SEQ AS nextval", nativeQuery = true)
	String srlnum();

	
	@Query(value = "select * from BLMS_VEHICLE_LOAN_DETAILS  where verify_flg='Y' and del_flg ='N'", nativeQuery = true)
	List<BLMS_VEHICLE_DET_ENTITY> getApprovelist();
	
	// @Query(value = "select * from BLMS_PERSONAL_LOAN_DETAILS  where verify_flg = 'N' and del_flg ='N'", nativeQuery = true)
	// List<BLMS_PERSONAL_LOAN_ENTITY> getnotapproved();
	
	 @Query(value = "select * from BLMS_VEHICLE_LOAN_DETAILS  where id =?1 and del_flg ='N' ", nativeQuery = true)
		BLMS_VEHICLE_DET_ENTITY getRefNo(String id);
	
}
