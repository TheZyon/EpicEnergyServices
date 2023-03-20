package com.SpringBoot_SpringSecurity.service;


import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.repository.ClientiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientiService {

    @Autowired private ClientiRepository repo;

    //Create
    public BeServiceClienti create(BeServiceClienti c){
        repo.save(c);
        return c;
    }

    //read
    public List<BeServiceClienti> getAll(){
        return (List<BeServiceClienti>) repo.findAll();
    }
    public BeServiceClienti getById(long id){
        return repo.findById(id).orElseThrow(()->new EntityNotFoundException("il cliente con questio id non esiste!"));
    }

    //put
    public BeServiceClienti put(BeServiceClienti c){
        repo.save(c);
        return c;
    }

    //delete
    public BeServiceClienti deleteById(long id){
        var cliente= getById(id);
        repo.deleteById(id);
        return cliente;
    }

}
