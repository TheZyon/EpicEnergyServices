package com.SpringBoot_SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot_SpringSecurity.entity.BeServiceIndirizzi;
import com.SpringBoot_SpringSecurity.repository.IndirizziRepository;

@Service
public class IndirizziService {

	@Autowired IndirizziRepository repo;
	
	public BeServiceIndirizzi createIndirizzi (BeServiceIndirizzi d) {
		repo.save(d);
		return d;
	}
	
	public BeServiceIndirizzi getIndirizziById(Long id) {
		BeServiceIndirizzi u = repo.findById(id).get();
		return u;
	}
	
	public BeServiceIndirizzi updateIndirizzi (BeServiceIndirizzi d) {
		repo.save(d);
		return d;
	}
	
	public String removeIndirizzi (Long id) {
		repo.deleteById(id);
		return "Provincia eliminata";
	}
	
	public List<BeServiceIndirizzi> getAllIndirizzi(){
		return (List<BeServiceIndirizzi>) repo.findAll();
	}
}
