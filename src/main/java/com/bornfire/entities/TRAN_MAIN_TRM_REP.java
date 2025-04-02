package com.bornfire.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TRAN_MAIN_TRM_REP extends JpaRepository<TRAN_MAIN_TRM_ENTITY, String>{
	@Query(value = "SELECT NEXT VALUE FOR OrderIDSequence", nativeQuery = true)
	String gettrmRefUUID();
	
	@Query(value = "SELECT NEXT VALUE FOR TRAN_ID_SEQUENCE", nativeQuery = true)
	String gettrmRefUUID1();
}
