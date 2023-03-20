package com.SpringBoot_SpringSecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceIndirizzi;

@Repository
public interface IndirizziRepository extends CrudRepository<BeServiceIndirizzi, Long> {

}
