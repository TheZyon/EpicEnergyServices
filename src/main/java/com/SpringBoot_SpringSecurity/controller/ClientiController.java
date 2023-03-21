package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/clienti")
public class ClientiController {

    @Autowired private ClientiService service;


    //create
    @PostMapping
    public ResponseEntity<BeServiceClienti> postCliente(@RequestBody BeServiceClienti cliente){
        service.create(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


    //read
    @GetMapping
    public ResponseEntity<List<BeServiceClienti>> getAllClienti(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeServiceClienti> getClienteById(@PathVariable long id){
        return  new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    //update
    

    //delete



}
