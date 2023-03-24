package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.entity.BeServiceIndirizzi;
import com.SpringBoot_SpringSecurity.service.ComuniService;
import com.SpringBoot_SpringSecurity.service.IndirizziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class IndirizziRunner implements ApplicationRunner {
    @Autowired private ComuniService comuniService;
    @Autowired private IndirizziService indirizziService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }


    public void popolaDB(){
        var list = Stream.of(
                new BeServiceIndirizzi("00104", "69", "brutta", "via dei malnati", comuniService.getComuneById(1l)),
                new BeServiceIndirizzi("222", "111", "cocoIDE'", "e' una mia opinione", comuniService.getComuneById(2l)),
                new BeServiceIndirizzi("333", "666", "Campo bello di Ovetto", "via soda", comuniService.getComuneById(3l)),
                new BeServiceIndirizzi("444", "777", "Zona Mistress Trans", "via dei padri di famigliaperbene", comuniService.getComuneById(4l))

        ).toList();

    indirizziService.createAll(list);

    }
}
