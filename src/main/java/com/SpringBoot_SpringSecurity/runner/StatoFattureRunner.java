package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.service.FattureService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StatoFattureRunner implements ApplicationRunner {

    @Autowired private StatoFatturaService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

   /* var f=service.getAllFattura();

    f.forEach(sfattura->System.out.println(sfattura));*/

    }
}
