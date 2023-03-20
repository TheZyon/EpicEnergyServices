package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.service.FattureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/fatture")
public class FattureController {

    @Autowired private FattureService service;

    //create

    @PostMapping
    public ResponseEntity<BeServiceFatture> create(@RequestBody BeServiceFatture fattura){
        service.create(fattura);
        return new ResponseEntity<>(fattura, HttpStatus.OK);
    }

    //read

    @GetMapping
    public ResponseEntity<List<BeServiceFatture>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BeServiceFatture> getById(@PathVariable long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }


}
