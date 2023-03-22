package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import com.SpringBoot_SpringSecurity.service.FattureService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/test/fatture")
public class FattureController {
    @Autowired private FattureService service;
    @Autowired private ClientiService cService;
    @Autowired private StatoFatturaService sfService;

    //create

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BeServiceFatture> create(@RequestBody BeServiceFatture fattura){
        service.create(fattura);
        return new ResponseEntity<>(fattura, HttpStatus.OK);
    }

    //read

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<BeServiceFatture>> getAll(Pageable pageable){
        return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BeServiceFatture> getById(@PathVariable long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    
    
   //Gruppo simo/lore
  
    //filtra by range importo
    @GetMapping("/filterbyrange/{uno}/{due}/{page}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getByRange(@PathVariable int uno,@PathVariable int due, @PathVariable int page, @RequestParam(defaultValue = "10") int size){
    	var pageable = PageRequest.of(page, size, Sort.by("importo").ascending());
    	
        return new ResponseEntity<>(service.getFattureByRangeImporto(uno, due, pageable), HttpStatus.OK);
    }
    
    //filtra by anno
    @GetMapping("/filterbyanno/{anno}/{page}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getByAnno(@PathVariable Integer anno, @PathVariable int page, @RequestParam(defaultValue = "10") int size){
    	var pageable = PageRequest.of(page, size, Sort.by("anno").ascending());
    	
        return new ResponseEntity<>(service.getFattureByAnno(anno, pageable), HttpStatus.OK);
    }
    
    //filtra by cliente
    @GetMapping("/cliente/{id}/{page}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getByClienti(@PathVariable long id, @PathVariable int page, @RequestParam(defaultValue = "10") int size){
    	var pageable = PageRequest.of(page, size, Sort.by("id").ascending());
    	
    	BeServiceClienti c = cService.getById(id);
        return new ResponseEntity<>(service.getFattureByBeServiceClienti(c, pageable), HttpStatus.OK);
    }
    
    //filtra by stato fattura
    @GetMapping("/statofattura/{id}/{page}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getByStatoFattura(@PathVariable long id, @PathVariable int page, @RequestParam(defaultValue = "10") int size){
        var pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        BeServiceStatoFattura sf= sfService.getStatoFatturaById(id);
        return new ResponseEntity<>(service.getFattureByBeServiceStatoFattura(sf, pageable), HttpStatus.OK);
    }
    
    //filtra by range data (timestamp)
    @GetMapping("/filterbydata/{data}/{page}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getByData(@PathVariable LocalDate data, @PathVariable int page, @RequestParam(defaultValue = "10") int size){
        var pageable = PageRequest.of(page, size, Sort.by("id").ascending());
    	
    	Timestamp timestamp = Timestamp.valueOf(data.atStartOfDay());
    	LocalDate dataFine = data.plusDays(1);
    	Timestamp endTimestamp = Timestamp.valueOf(dataFine.atStartOfDay());
    	
    	return new ResponseEntity<>(service.getFattureByData(timestamp, endTimestamp, pageable), HttpStatus.OK);
    }


}
