package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.repository.ProvinceRepository;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/province")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProvinceController {

        @Autowired private ProvinceService service;
        @Autowired private ProvinceRepository provinceRepo;

        //create
        @PostMapping
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<BeServiceProvince> create(@RequestBody BeServiceProvince beServiceProvince){
            return new ResponseEntity<>(service.createProvince(beServiceProvince), HttpStatus.OK);
        }

        //read
        @GetMapping
        @PreAuthorize("hasRole('USER')")
        public ResponseEntity<List<BeServiceProvince>> getAll(){
            return new ResponseEntity<>(service.getAllProvince(), HttpStatus.OK);
        }
        
   	 @GetMapping("/page/{page}")
   	@PreAuthorize("hasRole('USER')")
	    public Page<BeServiceProvince> getAllProvince(@PathVariable int page,
	    		@RequestParam(defaultValue = "10") int size,
	    		  @RequestParam(defaultValue = "id") String sortBy) {
	        Pageable sortedByName = PageRequest.of(page, size, Sort.by("nome"));
	        return provinceRepo.findAll(sortedByName);
	    }

        //put
        @PutMapping
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<BeServiceProvince> putProvincia(@RequestBody BeServiceProvince provincia){
            return new ResponseEntity<>(service.createProvince(provincia), HttpStatus.OK);
        }

        //delete
        @DeleteMapping ("/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<BeServiceProvince> deleteProvionce(@PathVariable long id){

            service.removeProvince(id);
            return new ResponseEntity<>(service.getProvinceById(id), HttpStatus.OK);


        }

}
