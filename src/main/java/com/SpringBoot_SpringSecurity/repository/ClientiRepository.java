package com.SpringBoot_SpringSecurity.repository;


import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepository extends CrudRepository<BeServiceClienti, Long> {
}
