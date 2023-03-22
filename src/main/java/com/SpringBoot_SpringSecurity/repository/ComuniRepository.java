package com.SpringBoot_SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;

@Repository
public interface ComuniRepository extends JpaRepository<BeServiceComuni, Long> {

}
