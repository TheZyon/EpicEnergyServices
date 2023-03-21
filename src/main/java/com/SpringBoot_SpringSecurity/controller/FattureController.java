package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import com.SpringBoot_SpringSecurity.service.FattureService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/fatture")
public class FattureController {

    @Autowired private FattureService service;
    @Autowired private ClientiService cService;
    @Autowired private StatoFatturaService sfService;

    //create

    @PostMapping
    public ResponseEntity<BeServiceFatture> create(@RequestBody BeServiceFatture fattura){
        service.create(fattura);
        return new ResponseEntity<>(fattura, HttpStatus.OK);
    }

    //read

    @GetMapping
    public ResponseEntity<Page<BeServiceFatture>> getAll(Pageable pageable){
        return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeServiceFatture> getById(@PathVariable long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    
   //Gruppo simo/lore
    
   //RANGE ??? completare
   // @GetMapping("/{uno}/{due}")
   // public ResponseEntity<Page<BeServiceFatture>> getByRange(@PathVariable int uno,@PathVariable int due, Pageable pageable){
   //     return new ResponseEntity<>(service.getFattureByRangeImporto(uno, due), HttpStatus.OK);
   // }
    
    @GetMapping("/{anno}")
    public ResponseEntity<Object> getByAnno(@PathVariable Integer anno){
        return new ResponseEntity<>(service.getFattureByAnno(anno), HttpStatus.OK);
    }
    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> getByClienti(@PathVariable long id){
    	BeServiceClienti c = cService.getById(id);
        return new ResponseEntity<>(service.getFattureByBeServiceClienti(c), HttpStatus.OK);
    }
    
    @GetMapping("/statofattura/{id}")
    public ResponseEntity<Object> getByStatoFattura(@PathVariable long id){
    	BeServiceStatoFattura sf= sfService.getStatoFatturaById(id);
        return new ResponseEntity<>(service.getFattureByBeServiceStatoFattura(sf), HttpStatus.OK);
    }
    
    @GetMapping("/{data}")
    public ResponseEntity<Object> getByData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Timestamp data){
    	return new ResponseEntity<>(service.getFattureByData(data), HttpStatus.OK);
    }


}
