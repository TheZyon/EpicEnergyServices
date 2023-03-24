package com.SpringBoot_SpringSecurity;

import com.SpringBoot_SpringSecurity.repository.*;
import com.SpringBoot_SpringSecurity.runner.*;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import jakarta.persistence.EntityNotFoundException;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class SpringSecurityExampleV2ApplicationTests {


    @Autowired private StatoFattureRunner statoFattureRunner;
    @Autowired private ProvinceRunner provinceRunner;
    @Autowired private ComuniRunner comuniRunner;
    @Autowired private IndirizziRunner indirizziRunner;
    @Autowired private ClientiRunner clientiRunner;
    @Autowired private FattureRunner fattureRunner;

    @Autowired private StatoFatturaRepository statoFatturaRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private ComuniRepository comuniRepository;
    @Autowired private IndirizziRepository indirizziRepository;
    @Autowired private ClientiRepository clientiRepository;
    @Autowired private FattureRepository fattureRepository;




    @BeforeEach
    void popolaDB(){
        statoFattureRunner.popolaDB();
        provinceRunner.popolaDB();
        comuniRunner.popolaDB();
        indirizziRunner.popolaDB();
        clientiRunner.popolaDB();
        fattureRunner.popolaDB();
    }

    @AfterEach
    void mastroLindo(){
        fattureRepository.deleteAll();
        clientiRepository.deleteAll();
        indirizziRepository.deleteAll();
        comuniRepository.deleteAll();
        provinceRepository.deleteAll();
        statoFatturaRepository.deleteAll();
    }


	@Test
    void testGetByIdCliente(){
        var id=2l;
        assertThat(clientiRepository.findById(id).isPresent()).isTrue();
    }

}
