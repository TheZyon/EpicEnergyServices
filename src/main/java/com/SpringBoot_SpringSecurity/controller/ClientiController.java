package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.repository.ClientiRepository;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/test/clienti")
public class ClientiController {

    @Autowired private ClientiService service;

    //create
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BeServiceClienti> postCliente(@RequestBody BeServiceClienti cliente){
        service.create(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    //get all clienti con sorting di un field del cliente
    @GetMapping("/page/{page}/{sortBy}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getAllClienti(@PathVariable int page, @RequestParam(defaultValue = "10") int size, @PathVariable String sortBy) {
        Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
        return service.getAll(sorting);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BeServiceClienti> getClienteById(@PathVariable long id){
        return  new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/orderByNomeProvincia/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getClientiOrderedByNomeProvincia(@PathVariable int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable=PageRequest.of(page,size);
        return service.getAllOrderByNomeProvincia(pageable);
    }

    //update
    

    //delete
    
    //clienti filtrati per fatturato
    @GetMapping("/fatturato/{fatturato_annuale}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getByFatturato(@PathVariable int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue="id") String sortBy,@PathVariable BigDecimal fatturato_annuale) {
        
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));

        return service.cercaTramiteFatturato(fatturato_annuale, sorting);
    
    }

    //clienti filtrati per nome like
    @GetMapping("/nome/{nome}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getByNome(@PathVariable String nome,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteParteNome(nome, sorting);
    }
    
    //query ultimo contatto
    @GetMapping("/contatto/{data}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getByUltimoContatto(@PathVariable LocalDate data,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteDataUltimoContatto(data, sorting);
    }
    
    //query data inserimento
    @GetMapping("/inserimento/{data}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<BeServiceClienti> getByDataInserimento(@PathVariable LocalDate data,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	
    	
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteInserimentoData(data, sorting);
    	
    }

}




