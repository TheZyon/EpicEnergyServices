package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statofatture")
public class StatoFatturaController {

    @Autowired private StatoFatturaService service;

    @GetMapping
    public ResponseEntity<List<BeServiceStatoFattura>> getAll(){
        return new ResponseEntity<>(service.getAllFattura(), HttpStatus.OK);
    }



}
