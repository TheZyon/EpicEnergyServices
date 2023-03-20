package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FattureRepository extends CrudRepository<BeServiceFatture, Long> {
}
