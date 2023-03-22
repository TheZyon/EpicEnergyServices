package com.SpringBoot_SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.repository.ComuniRepository;
import com.SpringBoot_SpringSecurity.service.ComuniService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comuni")
public class ComuneController {
	
	@Autowired ComuniService cSrv;
	@Autowired ComuniRepository comuniRepo;

	@GetMapping("/gruppo1")
	public String allAccess() {
		return "Gruppo 1 :)";
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BeServiceComuni> createComune(@RequestBody BeServiceComuni d) {
		return new ResponseEntity<BeServiceComuni>(cSrv.createComune(d), HttpStatus.OK);
	}
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BeServiceComuni> updateComune(@RequestBody BeServiceComuni d) {
		return new ResponseEntity<BeServiceComuni>(cSrv.createComune(d), HttpStatus.OK);
	}
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public List<BeServiceComuni> getAllComuni() {
		 return cSrv.getAllComuni();	 
	}
	
	 @GetMapping("/page/{page}")
	 @PreAuthorize("hasRole('USER')")
	    public Page<BeServiceComuni> getAllComuni(@PathVariable int page,
	    		@RequestParam(defaultValue = "10") int size,
	    		  @RequestParam(defaultValue = "id") String sortBy) {
	        Pageable sortedByName = PageRequest.of(page, size, Sort.by("nome"));
	        return comuniRepo.findAll(sortedByName);
	    }
	 
	 
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> removeComune(@PathVariable Long id) {
		return new ResponseEntity<String>(cSrv.removeComune(id), HttpStatus.OK);
	}
	
	
	
}
