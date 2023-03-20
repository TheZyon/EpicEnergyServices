package com.SpringBoot_SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.service.ComuniService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/comuni")
public class Gruppo1Controller {
	
	@Autowired ComuniService cSrv;

	@GetMapping("/gruppo1")
	public String allAccess() {
		return "Gruppo 1 :)";
	}
	
	//@PostMapping("/create")
	//public ResponseEntity<BeServiceComuni> createComune(@RequestBody BeServiceComuni d) {
	//	return new ResponseEntity<BeServiceComuni>(cSrv.createComune(d), HttpStatus.OK);
	//}
	//@PutMapping("/update")
	//public ResponseEntity<BeServiceComuni> updateComune(@RequestBody BeServiceComuni d) {
	//	return new ResponseEntity<BeServiceComuni>(cSrv.createComune(d), HttpStatus.OK);
	//}
	//@GetMapping("/all")
	//public List<BeServiceComuni> getAllComuni() {
	//	 return cSrv.getAllComuni();
	//}
	//@DeleteMapping("/delete/{id}")
	//public ResponseEntity<String> removeComune(@PathVariable Long id) {
	//	return new ResponseEntity<String>(cSrv.removeComune(id), HttpStatus.OK);
	//}
	
	
	
}
