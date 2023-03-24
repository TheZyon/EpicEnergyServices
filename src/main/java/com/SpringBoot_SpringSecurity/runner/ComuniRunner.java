package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.service.ComuniService;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ComuniRunner implements ApplicationRunner {

    @Autowired private ProvinceService provinceService;
    @Autowired private ComuniService service;
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public void popolaDB(){

        var lista= Stream.of(

                new BeServiceComuni("In-Cesto", provinceService.getProvinceById(1l)),//in cocolandia
                new BeServiceComuni("Unapologeticity",provinceService.getProvinceById(2l)),//in CuClux....
                new BeServiceComuni("Ovetto", provinceService.getProvinceById(3l)),//inCuloAllaGallina
                new BeServiceComuni("BDSMcity", provinceService.getProvinceById(4l)) //in BunnyManParadise
        ).toList();

        service.createAll(lista);
    }


}
