package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.repository.FattureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FattureService {

    @Autowired private FattureRepository repo;


    //create
    public BeServiceFatture create(BeServiceFatture beServiceFatture){
        repo.save(beServiceFatture);
        return beServiceFatture;
    }

    //retrieve
    public BeServiceFatture getById(long id){
        return repo.findById(id).orElseThrow(()->new EntityNotFoundException("fattura con questo id non esiste!"));
    }
    public Page<BeServiceFatture> getAll(Pageable pageable){
       try{ return repo.findAll(pageable);}
       catch (Exception e){
           throw new EntityNotFoundException("Problema nella paginazione delle entities!");
       }
    }

    //update

    //delete
    public BeServiceFatture deleteById(long id){
        var fattura= getById(id);
        repo.deleteById(id);
        return fattura;
    }



}
