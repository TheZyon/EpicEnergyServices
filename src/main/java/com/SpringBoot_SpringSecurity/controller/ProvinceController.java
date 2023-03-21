package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

        @Autowired private ProvinceService service;

        //create
        @PostMapping
        public ResponseEntity<BeServiceProvince> create(@RequestBody BeServiceProvince beServiceProvince){
            return new ResponseEntity<>(service.createProvince(beServiceProvince), HttpStatus.OK);
        }

        //read
        @GetMapping
        public ResponseEntity<List<BeServiceProvince>> getAll(){
            return new ResponseEntity<>(service.getAllProvince(), HttpStatus.OK);
        }

        //put
        @PutMapping
        public ResponseEntity<BeServiceProvince> putProvincia(@RequestBody BeServiceProvince provincia){
            return new ResponseEntity<>(service.createProvince(provincia), HttpStatus.OK);
        }

        //delete
        @DeleteMapping ("/{id}")
        public ResponseEntity<BeServiceProvince> deleteProvionce(@PathVariable long id){

            service.removeProvince(id);
            return new ResponseEntity<>(service.getProvinceById(id), HttpStatus.OK);


        }

}
