package com.SpringBoot_SpringSecurity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;

@Repository
public interface StatoFatturaRepository extends CrudRepository<BeServiceStatoFattura, Long> {

}
