package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BLMS_VEHICLEDET_REPO extends JpaRepository<BLMS_VEHICLE_DET_ENTITY, String> {

	@Query(value = "select NEXT VALUE FOR BLMS_PERSONAL_SEQ AS nextval", nativeQuery = true)
	String srlnum();
}
