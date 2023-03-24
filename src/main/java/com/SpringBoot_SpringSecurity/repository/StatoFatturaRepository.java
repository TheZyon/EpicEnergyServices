package com.SpringBoot_SpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;

@Repository
public interface StatoFatturaRepository extends JpaRepository<BeServiceStatoFattura, Long> {


    public boolean existsByNome(String nome);
}
