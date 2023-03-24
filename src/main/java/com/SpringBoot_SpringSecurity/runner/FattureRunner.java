package com.SpringBoot_SpringSecurity.runner;


import com.SpringBoot_SpringSecurity.entity.BeServiceFatture;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import com.SpringBoot_SpringSecurity.service.FattureService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.stream.Stream;

@Component
public class FattureRunner implements ApplicationRunner {

    @Autowired private ClientiService clientiService;
    @Autowired private StatoFatturaService statoFatturaService;
    @Autowired private FattureService fattureService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public void popolaDB(){
            var fattura= new BeServiceFatture(1995, Timestamp.valueOf("1995-04-09 00:00:00"), BigDecimal.valueOf(2000l),33,
                            clientiService.getById(1l), statoFatturaService.getStatoFatturaById(4l));

        fattureService.create(fattura);
    }
}
