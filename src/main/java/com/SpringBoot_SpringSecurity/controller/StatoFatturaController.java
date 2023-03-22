package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.repository.StatoFatturaRepository;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statofatture")
public class StatoFatturaController {


    @Autowired private StatoFatturaService service;
    @Autowired private StatoFatturaRepository statoRepo;


    @GetMapping
    public ResponseEntity<List<BeServiceStatoFattura>> getAll(){
        return new ResponseEntity<>(service.getAllFattura(), HttpStatus.OK);
    }
    
	 @GetMapping("/page/{page}")
	    public Page<BeServiceStatoFattura> getAllStatoFattura(@PathVariable int page,
	    		@RequestParam(defaultValue = "10") int size,
	    		  @RequestParam(defaultValue = "id") String sortBy) {
	        Pageable sortedByName = PageRequest.of(page, size, Sort.by("nome"));
	        return statoRepo.findAll(sortedByName);
	    }
	 



}
