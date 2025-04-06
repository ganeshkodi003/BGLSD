package com.bornfire.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DMD_TABLE_REPO extends JpaRepository<DMD_TABLE, DMD_TABLE_IDclass> {

	@Query(value = "select * from DEMAND_TBL aa where aa.loan_acct_no = ?1 and aa.flow_date<=?2  AND aa.FLOW_CODE NOT IN ('DISBT')", nativeQuery = true)
	List<DMD_TABLE> getdemand(String acct_num, Date flow);

	@Query(value = "select TOP 2* from DEMAND_TBL aa where aa.loan_acct_no=?1 and aa.flow_date>=?2 order by FLOW_ID", nativeQuery = true)
	List<DMD_TABLE> getAlldemand(String acct_num, Date flow);

	@Query(value = "SELECT NEXT VALUE FOR DMD_SRL_SEQ AS SRL_NO;", nativeQuery = true)
	BigDecimal getSrlNo();

	@Query(value = "select * from DEMAND_TBL aa where aa.loan_acct_no = ?1", nativeQuery = true)
	DMD_TABLE gettranpopvalues(String acct_num);

	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE aa.loan_acct_no = ?1 AND aa.flow_frq <> 'DISBT'", nativeQuery = true)
	List<DMD_TABLE> gettranpopvalues1(String acct_num);

	@Query(value = "SELECT *\r\n" + "FROM DEMAND_TBL aa\r\n" + "WHERE aa.FLOW_DATE BETWEEN ?1 AND ?2\r\n"
			+ "  AND aa.FLOW_CODE NOT IN ('DISBT', 'PRDEM')\r\n"
			+ "  AND (?3 IS NULL OR ?3 = '' OR aa.LOAN_ACCT_NO = ?3)\r\n" + "  AND EXISTS (\r\n" + "      SELECT 1\r\n"
			+ "      FROM BGLS_TRM_WRK_TRANSACTIONS b\r\n" + "      WHERE b.ACCT_NUM = aa.LOAN_ACCT_NO\r\n" + "  )\r\n"
			+ "  AND NOT EXISTS (\r\n" + "      SELECT 1\r\n" + "      FROM DEMAND_TBL d\r\n"
			+ "      WHERE d.LOAN_ACCT_NO = aa.LOAN_ACCT_NO\r\n" + "        AND d.FLOW_DATE = aa.FLOW_DATE\r\n"
			+ "        AND d.PART_TRAN_TYPE = 'DEBIT'\r\n" + "  )\r\n" + "ORDER BY aa.FLOW_DATE\r\n"
			+ "", nativeQuery = true)
	List<DMD_TABLE> getloanflows(Date fromDate, Date todate, String accountNum);

	@Query(value = "SELECT * \r\n" + "FROM DEMAND_TBL aa \r\n" + "WHERE \r\n" + "    aa.FLOW_DATE BETWEEN ?1 AND ?2\r\n"
			+ "    AND aa.FLOW_CODE NOT IN ('DISBT') \r\n" + "    AND (\r\n"
			+ "        ?3 IS NULL OR ?3 = '' OR aa.LOAN_ACCT_NO = ?3\r\n" + "    )\r\n"
			+ "    AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n" + "ORDER BY aa.FLOW_DATE\r\n"
			+ "", nativeQuery = true)
	List<DMD_TABLE> getloanflows1(Date fromDate, Date todate, String accountNum);

	@Query(value = "select * from DEMAND_TBL where loan_acct_no = ?1 and flow_code=?2 and flow_id=?3", nativeQuery = true)
	DMD_TABLE getDemandData(String acct_num, String flowCode, String flowid);

	@Query(value = "SELECT * FROM DEMAND_TBL WHERE loan_acct_no =?1 AND FLOW_DATE =?2", nativeQuery = true)
	DMD_TABLE getflowcode(String acid, Date flow_date);

	@Query(value = "SELECT TOP 1 *\r\n" + "FROM DEMAND_TBL\r\n"
			+ "WHERE loan_acct_no =?1 AND FLOW_DATE > ?2 AND FLOW_CODE!='DIBST'\r\n"
			+ "ORDER BY FLOW_DATE ASC ;", nativeQuery = true)
	DMD_TABLE getPreviousFlowCode(String acid, Date flow_date);

	@Query(value = "SELECT * FROM DEMAND_TBL aa WHERE aa.FLOW_CODE NOT IN ('DISBT') AND aa.LOAN_ACCT_NO =?1 and aa.FLOW_DATE <= ?2 ORDER BY aa.FLOW_DATE,aa.flow_id,aa.flow_code", nativeQuery = true)
	List<DMD_TABLE> getloanposition(String accountNum, Date tranDate);

	@Query(value = "WITH ControlDate AS (\r\n" + "    -- Fetch the latest TRAN_DATE from BGLS_CONTROL_TABLE\r\n"
			+ "    SELECT MAX(TRAN_DATE) AS TRAN_DATE \r\n" + "    FROM BGLS_CONTROL_TABLE\r\n" + "), \r\n"
			+ "PRDEMData AS (\r\n" + "    SELECT \r\n" + "        aa.loan_acct_no,\r\n"
			+ "        2 AS flow_id,  -- PRDEM has flow_id = 2\r\n" + "        aa.acct_name,  -- Add acct_name here\r\n"
			+ "        'PRDEM' AS flow_code,\r\n" + "        cd.TRAN_DATE AS flow_date,\r\n"
			+ "        SUM(ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1  -- Correct join for ControlDate\r\n"
			+ "    WHERE \r\n" + "        aa.loan_acct_no = ?1\r\n" + "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'PRDEM'\r\n" + "        AND aa.flow_date > cd.TRAN_DATE\r\n"
			+ "    GROUP BY aa.loan_acct_no, aa.acct_name, cd.TRAN_DATE\r\n" + "    UNION ALL\r\n" + "    SELECT \r\n"
			+ "        aa.loan_acct_no,\r\n" + "        2 AS flow_id,  -- PRDEM has flow_id = 2\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'PRDEM' AS flow_code,\r\n"
			+ "        aa.flow_date AS flow_date,\r\n"
			+ "        SUM(ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1\r\n" + "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'PRDEM'\r\n"
			+ "        AND aa.flow_date < cd.TRAN_DATE  -- Before TRAN_DATE\r\n"
			+ "    GROUP BY aa.loan_acct_no, aa.acct_name, aa.flow_date, cd.TRAN_DATE\r\n" + "),\r\n"
			+ "INDEMData AS (\r\n" + "    -- Get INDEM amount before TRAN_DATE and display TRAN_DATE as flow_date\r\n"
			+ "    SELECT \r\n" + "        aa.loan_acct_no,\r\n" + "        1 AS flow_id,  -- INDEM has flow_id = 1\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'INDEM' AS flow_code,\r\n"
			+ "        aa.flow_date AS flow_date,\r\n" + "        ISNULL(aa.FLOW_AMT, 0) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1\r\n" + "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'INDEM'\r\n"
			+ "        AND aa.flow_date < cd.TRAN_DATE  -- Before TRAN_DATE\r\n" + "    UNION ALL\r\n"
			+ "    SELECT \r\n" + "        aa.loan_acct_no,\r\n" + "        1 AS flow_id,  -- INDEM has flow_id = 1\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'INDEM' AS flow_code,\r\n"
			+ "        cd.TRAN_DATE AS flow_date,\r\n" + "        ISNULL(aa.FLOW_AMT, 0) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1\r\n" + "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'INDEM'\r\n" + "        AND aa.flow_date = (\r\n"
			+ "            SELECT MAX(flow_date)\r\n" + "            FROM DEMAND_TBL\r\n"
			+ "            WHERE loan_acct_no = aa.loan_acct_no\r\n" + "            AND flow_code = 'INDEM'\r\n"
			+ "            AND flow_date < cd.TRAN_DATE\r\n" + "        )\r\n" + "),\r\n" + "FinalResult AS (\r\n"
			+ "    -- Combine PRDEM and INDEM data\r\n"
			+ "    SELECT loan_acct_no, flow_id, acct_name, flow_date, flow_code, amount\r\n" + "    FROM PRDEMData\r\n"
			+ "    UNION ALL\r\n" + "    SELECT loan_acct_no, flow_id, acct_name, flow_date, flow_code, amount\r\n"
			+ "    FROM INDEMData\r\n" + ")\r\n" + "SELECT \r\n" + " aa.flow_date,\r\n" + " aa.flow_id,\r\n"
			+ "  aa.flow_code,\r\n" + "  CASE\r\n" + "        WHEN aa.flow_code = 'INDEM' THEN ISNULL(aa.amount, 0)\r\n"
			+ "        ELSE aa.amount\r\n" + "    END AS amount,\r\n" + "    aa.loan_acct_no,\r\n"
			+ "    aa.acct_name\r\n" + "FROM FinalResult aa\r\n" + "ORDER BY \r\n" + "    aa.flow_date, \r\n"
			+ "    aa.flow_id,\r\n" + "    aa.flow_code,\r\n" + "    aa.amount,\r\n" + "    aa.loan_acct_no,\r\n"
			+ "    aa.acct_name\r\n" + "", nativeQuery = true)
	List<Object[]> gettranpopvalues11(String acct_num);

	@Query(value = "select TOP 1* from DEMAND_TBL aa where aa.loan_acct_no = ?1", nativeQuery = true)
	DMD_TABLE gettranpopvalues21(String acct_num);

	@Query(value = "SELECT * FROM DEMAND_TBL WHERE loan_acct_no = :accountNum AND FLOW_DATE IN (:flowDates)", nativeQuery = true)
	List<DMD_TABLE> getLoanFlowsValueDatas1(@Param("accountNum") String accountNum,
			@Param("flowDates") List<String> flowDates);

	@Query(value = "SELECT * FROM DEMAND_TBL WHERE loan_acct_no = ?1 AND FLOW_DATE =?2 and FLOW_CODE =?3", nativeQuery = true)
	DMD_TABLE getLoanFlowsValueDatas11(String encodedkey, String flow_date, String flow_code);

	@Query(value = "select * from DEMAND_TBL aa where aa.loan_acct_no = ?1 AND paid_amount IS NOT NULL AND MODIFY_FLG = 'Y'", nativeQuery = true)
	List<DMD_TABLE> gettranpopvaluesdatas(String acct_num);

	@Query(value = "WITH ControlDate AS (\r\n" + "    -- Fetch the latest TRAN_DATE from BGLS_CONTROL_TABLE\r\n"
			+ "    SELECT MAX(TRAN_DATE) AS TRAN_DATE \r\n" + "    FROM BGLS_CONTROL_TABLE\r\n" + "), \r\n"
			+ "PRDEMData AS (\r\n" + "    SELECT \r\n" + "        aa.loan_acct_no,\r\n"
			+ "        2 AS flow_id,  -- PRDEM has flow_id = 2\r\n" + "        aa.acct_name,  -- Add acct_name here\r\n"
			+ "        'PRDEM' AS flow_code,\r\n" + "        cd.TRAN_DATE AS flow_date,\r\n"
			+ "        SUM(ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1  -- Correct join for ControlDate\r\n"
			+ "    WHERE \r\n" + "        aa.loan_acct_no = ?1  -- Replace with actual account number\r\n"
			+ "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'PRDEM'\r\n" + "        AND aa.flow_date > cd.TRAN_DATE\r\n"
			+ "    GROUP BY aa.loan_acct_no, aa.acct_name, cd.TRAN_DATE\r\n" + "    UNION ALL\r\n" + "    SELECT \r\n"
			+ "        aa.loan_acct_no,\r\n" + "        2 AS flow_id,  -- PRDEM has flow_id = 2\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'PRDEM' AS flow_code,\r\n"
			+ "        aa.flow_date AS flow_date,\r\n"
			+ "        SUM(ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1  -- Replace with actual account number\r\n"
			+ "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'PRDEM'\r\n"
			+ "        AND aa.flow_date < cd.TRAN_DATE  -- Before TRAN_DATE\r\n"
			+ "    GROUP BY aa.loan_acct_no, aa.acct_name, aa.flow_date, cd.TRAN_DATE\r\n" + "),\r\n"
			+ "INDEMData AS (\r\n" + "    -- Get INDEM amount before TRAN_DATE and display TRAN_DATE as flow_date\r\n"
			+ "    SELECT \r\n" + "        aa.loan_acct_no,\r\n" + "        1 AS flow_id,  -- INDEM has flow_id = 1\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'INDEM' AS flow_code,\r\n"
			+ "        aa.flow_date AS flow_date,\r\n" + "        ISNULL(aa.FLOW_AMT, 0) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1  -- Replace with actual account number\r\n"
			+ "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'INDEM'\r\n"
			+ "        AND aa.flow_date < cd.TRAN_DATE  -- Before TRAN_DATE\r\n" + "    UNION ALL\r\n"
			+ "    SELECT \r\n" + "        aa.loan_acct_no,\r\n" + "        1 AS flow_id,  -- INDEM has flow_id = 1\r\n"
			+ "        aa.acct_name,  -- Add acct_name here\r\n" + "        'INDEM' AS flow_code,\r\n"
			+ "        cd.TRAN_DATE AS flow_date,\r\n" + "        ISNULL(aa.FLOW_AMT, 0) AS amount\r\n"
			+ "    FROM DEMAND_TBL aa\r\n" + "    JOIN ControlDate cd ON 1=1\r\n" + "    WHERE \r\n"
			+ "        aa.loan_acct_no = ?1  -- Replace with actual account number\r\n"
			+ "        AND aa.flow_frq <> 'DISBT'\r\n"
			+ "        AND (ISNULL(aa.FLOW_AMT, 0) - ISNULL(aa.PAID_AMOUNT, 0)) != 0\r\n"
			+ "        AND aa.flow_code = 'INDEM'\r\n" + "        AND aa.flow_date = (\r\n"
			+ "            SELECT MAX(flow_date)\r\n" + "            FROM DEMAND_TBL\r\n"
			+ "            WHERE loan_acct_no = aa.loan_acct_no\r\n" + "            AND flow_code = 'INDEM'\r\n"
			+ "            AND flow_date < cd.TRAN_DATE\r\n" + "        )\r\n" + "),\r\n" + "FinalResult AS (\r\n"
			+ "    -- Combine PRDEM and INDEM data\r\n"
			+ "    SELECT loan_acct_no, flow_id, acct_name, flow_date, flow_code, amount\r\n" + "    FROM PRDEMData\r\n"
			+ "    UNION ALL\r\n" + "    SELECT loan_acct_no, flow_id, acct_name, flow_date, flow_code, amount\r\n"
			+ "    FROM INDEMData\r\n" + ")\r\n" + "SELECT \r\n" + "    aa.flow_date,\r\n" + "    aa.flow_id,\r\n"
			+ "    aa.flow_code,\r\n" + "    CASE\r\n"
			+ "        WHEN aa.flow_code = 'INDEM' THEN ISNULL(aa.amount, 0)\r\n" + "        ELSE aa.amount\r\n"
			+ "    END AS amount,\r\n" + "    aa.loan_acct_no,\r\n" + "    aa.acct_name,\r\n"
			+ "    cd.TRAN_DATE  -- Added TRAN_DATE to final result\r\n" + "FROM FinalResult aa\r\n"
			+ "JOIN ControlDate cd ON 1=1  -- Join to add the latest TRAN_DATE\r\n"
			+ "WHERE aa.flow_date != TRAN_DATE  -- Exclude rows where TRAN_DATE is '2025-01-21'\r\n"
			+ "ORDER BY \r\n" + "    aa.flow_date, \r\n" + "    aa.flow_id,\r\n" + "    aa.flow_code,\r\n"
			+ "    aa.amount,\r\n" + "    aa.loan_acct_no,\r\n" + "    aa.acct_name\r\n" + "", nativeQuery = true)
	List<Object[]> gettranpopvalues121(String acct_num);
}
