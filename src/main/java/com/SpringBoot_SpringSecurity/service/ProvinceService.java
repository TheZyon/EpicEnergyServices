package com.SpringBoot_SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.repository.ProvinceRepository;

@Service
public class ProvinceService {

	@Autowired ProvinceRepository repo;
	
	public BeServiceProvince createProvince(BeServiceProvince d) {
		repo.save(d);
		return d;
	}
	
	public BeServiceProvince getProvinceById(Long id) {
		BeServiceProvince u = repo.findById(id).get();
		return u;
	}
	
	public BeServiceProvince updateProvince(BeServiceProvince d) {
		repo.save(d);
		return d;
	}
	
	public String removeProvince(Long id) {
		repo.deleteById(id);
		return "Provincia eliminata";
	}
	
	public List<BeServiceProvince> getAllProvince(){
		return (List<BeServiceProvince>) repo.findAll();
	}
}
