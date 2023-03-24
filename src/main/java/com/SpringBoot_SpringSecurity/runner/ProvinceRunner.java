package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ProvinceRunner implements ApplicationRunner {

    @Autowired private ProvinceService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public void popolaDB(){
        var lista= Stream.of(
                new BeServiceProvince("Cocolandia", "MD"),
                new BeServiceProvince("CuCluxlandia", "KK"),
                new BeServiceProvince("InCuloAllaGallina", "CG"),
                new BeServiceProvince("BunnyManParadise", "BP")
        ).toList();

        service.createAll(lista);
    }


}
