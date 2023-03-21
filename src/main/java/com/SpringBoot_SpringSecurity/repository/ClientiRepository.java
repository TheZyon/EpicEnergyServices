package com.SpringBoot_SpringSecurity.repository;


import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepository extends CrudRepository<BeServiceClienti, Long> {

	
	
public List<BeServiceClienti> findByFatturatoAnnuale(BigDecimal fatturatoAnnuale);
public List<BeServiceClienti>  findByDataInserimento(Timestamp dataInserimento);
public List<BeServiceClienti>  findByDataUltimoContatto(Timestamp dataUltimoContatto);
public List<BeServiceClienti> findByNomeContattoContaining(String nomeContatto);

}
