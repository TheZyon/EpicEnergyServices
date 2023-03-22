package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FattureRepository extends PagingAndSortingRepository<BeServiceFatture, Long>, CrudRepository<BeServiceFatture, Long>{

	public List<BeServiceFatture> findByBeServiceClienti(BeServiceClienti beServiceClienti, Pageable paging);
	
	public List<BeServiceFatture> findByBeServiceStatoFattura(BeServiceStatoFattura beServiceStatoFattura, Pageable pageable);
	
	@Query("SELECT e FROM BeServiceFatture e WHERE e.data BETWEEN ?1  AND  ?2")
	public List<BeServiceFatture> findByData(Timestamp data1, Timestamp data2, Pageable pageable);
	
	public List<BeServiceFatture> findByAnno(Integer anno, Pageable pageable);
	
	@Query("SELECT e FROM BeServiceFatture e WHERE e.importo BETWEEN ?1  AND  ?2")
	public List<BeServiceFatture> findByRangeImporto(BigDecimal uno, BigDecimal due, Pageable pageable);
	

}
