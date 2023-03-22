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
		return  repo.findAll(sorting);
	}


	/*esempio di come trasformare una lista in una Page e settargli il Pageable */
	public Page<BeServiceClienti> getAllOrderByNomeProvincia(Pageable pageable){
		var listSortedClienti= repo.sortClientiByNomeProvincia();
		Page<BeServiceClienti> sortedClientiPage = PageableExecutionUtils.getPage(listSortedClienti, pageable, () -> listSortedClienti.size());
		return sortedClientiPage;}
	public BeServiceClienti getById(long id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("il cliente con questio id non esiste!"));
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

	// metodino per cercare clienti by data inserimento ormai obsoleto (sostituito con un'altro cercaTramiteInserimentoData)
	//public List<BeServiceClienti> cercaTramiteInserimentoData(Timestamp data) {
	//	return repo.findByDataInserimento(data);
	//}

	// metodino per cercare client by data ultimo contatto ormai obsoleto (sostituito con un'altro cercaTramiteDataUltimoContatto)
	//public List<BeServiceClienti> cercaTramiteDataUltimoContatto(Timestamp data) {
	//	return repo.findByDataUltimoContatto(data);
	//}

	// metodino per filtrare by parte del nome
	public List<BeServiceClienti> cercaTramiteParteNome(String nome) {
		return repo.findByNomeContattoContaining(nome);
	}
	
	//metodino per il timestamp da finire per farlo con anche gli altri metodi (per ora settato solo per data di inserimento  )
	public List<BeServiceClienti> cercaTramiteInserimentoData(LocalDate data){
		List<BeServiceClienti> persone = new ArrayList<BeServiceClienti>();
		List<BeServiceClienti> listaClientiConLocaDate = new ArrayList<BeServiceClienti>();
		persone = repo.findAll();
		
		for(BeServiceClienti cliente : persone) {
			if(cliente.getDataInserimento()!=null) {
			LocalDate dataClienti=  cliente.getDataInserimento().toLocalDateTime().toLocalDate();
			if(data.isEqual(dataClienti)) {
				listaClientiConLocaDate.add(cliente);
			}
		}
		}
		return listaClientiConLocaDate;
	}
	
	public List<BeServiceClienti> cercaTramiteDataUltimoContatto(LocalDate data){
		List<BeServiceClienti> personeUltimoContatto = new ArrayList<BeServiceClienti>();
		List<BeServiceClienti> listaClientiConLocaDate = new ArrayList<BeServiceClienti>();
		personeUltimoContatto = repo.findAll();
		
		for(BeServiceClienti cliente : personeUltimoContatto) {
			if(cliente.getDataInserimento()!=null) {
				LocalDate dataClienti=  cliente.getDataUltimoContatto().toLocalDateTime().toLocalDate();
				if(data.isEqual(dataClienti)) {
					listaClientiConLocaDate.add(cliente);
				}
			}
		}
		return listaClientiConLocaDate;
	}

}
 