package com.SpringBoot_SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.repository.ComuniRepository;


@Service
public class ComuniService {

	@Autowired ComuniRepository repo;
	
	public BeServiceComuni createComune(BeServiceComuni d) {
		repo.save(d);
		return d;
	}
	public void createAll(List<BeServiceComuni>list){
		repo.saveAll(list);
	}

	public BeServiceComuni getComuneById(Long id) {
		BeServiceComuni u = repo.findById(id).get();
		return u;
	}
	
	public BeServiceComuni updateComune(BeServiceComuni d) {
		repo.save(d);
		return d;
	}
	
	public String removeComune(Long id) {
		repo.deleteById(id);
		return "Comune eliminato";
	}
	
	public List<BeServiceComuni> getAllComuni(){
		return (List<BeServiceComuni>) repo.findAll();
	}
}
