package com.SpringBoot_SpringSecurity.repository;


import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepository extends JpaRepository<BeServiceClienti, Long>{

public List<BeServiceClienti> findByFatturatoAnnuale(BigDecimal fatturatoAnnuale);
public List<BeServiceClienti> findByDataInserimento(Timestamp dataInserimento);
public List<BeServiceClienti> findByDataUltimoContatto(Timestamp data);
public List<BeServiceClienti> findByNomeContattoContaining(String nomeContatto);

}
