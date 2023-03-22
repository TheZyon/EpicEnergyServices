package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.repository.ClientiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
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
	public Page<BeServiceClienti> getAll(Pageable sorting) {
		return repo.findAll(sorting);
	}

	/* esempio di come trasformare una lista in una Page e settargli il Pageable */
	public Page<BeServiceClienti> getAllOrderByNomeProvincia(Pageable pageable) {
		var listSortedClienti = repo.sortClientiByNomeProvincia();
		Page<BeServiceClienti> sortedClientiPage = PageableExecutionUtils.getPage(listSortedClienti, pageable,
				() -> listSortedClienti.size());
		return sortedClientiPage;
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
	public Page<BeServiceClienti> cercaTramiteFatturato(BigDecimal fatturato, Pageable pageable) {

		var listFiltrataPerFatturato = repo.findByFatturatoAnnuale(fatturato);

		Page<BeServiceClienti> clientiPerFatturatoPage = PageableExecutionUtils.getPage(listFiltrataPerFatturato,
				pageable, () -> listFiltrataPerFatturato.size());

		return clientiPerFatturatoPage;

	}

	// metodino per filtrare by parte del nome
	public Page<BeServiceClienti> cercaTramiteParteNome(String nome, Pageable pageable) {
		var listaFiltrataPerNome = repo.findByNomeContattoContaining(nome);
		Page<BeServiceClienti> clientiColNomeSimile = PageableExecutionUtils.getPage(listaFiltrataPerNome, pageable,
				() -> listaFiltrataPerNome.size());
		return clientiColNomeSimile;
	}

	// metodino per il timestamp da finire per farlo con anche gli altri metodi (per
	// ora settato solo per data di inserimento )
	public Page<BeServiceClienti> cercaTramiteInserimentoData(LocalDate data, Pageable pageable) {
		List<BeServiceClienti> persone = new ArrayList<BeServiceClienti>();

		List<BeServiceClienti> listaClientiConLocaDate = new ArrayList<BeServiceClienti>();
		persone = repo.findAll();

		for (BeServiceClienti cliente : persone) {
			if (cliente.getDataInserimento() != null) {
				LocalDate dataClienti = cliente.getDataInserimento().toLocalDateTime().toLocalDate();
				if (data.isEqual(dataClienti)) {
					listaClientiConLocaDate.add(cliente);
				}
			}
		}
		Page<BeServiceClienti> clientiColData = PageableExecutionUtils.getPage(listaClientiConLocaDate, pageable,
				() -> listaClientiConLocaDate.size());
		return clientiColData;
	}

	public Page<BeServiceClienti> cercaTramiteDataUltimoContatto(LocalDate data,Pageable pageable) {
		List<BeServiceClienti> personeUltimoContatto = new ArrayList<BeServiceClienti>();
		List<BeServiceClienti> listaClientiConLocaDate = new ArrayList<BeServiceClienti>();
		personeUltimoContatto = repo.findAll();

		for (BeServiceClienti cliente : personeUltimoContatto) {
			if (cliente.getDataInserimento() != null) {
				LocalDate dataClienti = cliente.getDataUltimoContatto().toLocalDateTime().toLocalDate();
				if (data.isEqual(dataClienti)) {
					listaClientiConLocaDate.add(cliente);
				}
			}
		}
		Page<BeServiceClienti> clientiColData = PageableExecutionUtils.getPage(listaClientiConLocaDate, pageable,
				() -> listaClientiConLocaDate.size());
		return clientiColData;
		
	}
	
	
	 
	

}
