package com.SpringBoot_SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;

@Repository
public interface ProvinceRepository extends JpaRepository<BeServiceProvince, Long> {

}
