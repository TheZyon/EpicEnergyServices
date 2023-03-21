package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.repository.ClientiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ClientiService {

	@Autowired
	private ClientiRepository repo;

	// Create
	public BeServiceClienti create(BeServiceClienti c) {
		repo.save(c);
		return c;
	}

	// read
	public List<BeServiceClienti> getAll() {
		return (List<BeServiceClienti>) repo.findAll();
	}

	public BeServiceClienti getById(long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("il cliente con questio id non esiste!"));
	}

	// put
	public BeServiceClienti put(BeServiceClienti c) {
		repo.save(c);
		return c;
	}

	// delete
	public BeServiceClienti deleteById(long id) {
		var cliente = getById(id);
		repo.deleteById(id);
		return cliente;
	}

	// metodino per cercare clienti by fatturato annuale
	public List<BeServiceClienti> cercaTramiteFatturato(BigDecimal fatturato) {
		return repo.findByFatturatoAnnuale(fatturato);

	}

	// metodino per cercare clienti by data inserimento
	public List<BeServiceClienti> cercaTramiteInserimentoData(Timestamp data) {
		return repo.findByDataInserimento(data);
	}

	// metodino per cercare client by data ultimo contatto
	public List<BeServiceClienti> cercaTramiteDataUltimoContatto(Timestamp data) {
		return repo.findByDataUltimoContatto(data);
	}

	// metodino per filtrare by parte del nome
	public List<BeServiceClienti> cercaTramiteParteNome(String nome) {
		return repo.findByNomeContattoContaining(nome);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
