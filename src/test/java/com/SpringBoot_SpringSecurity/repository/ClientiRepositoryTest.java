package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.runner.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
@DataJpaTest
@ContextConfiguration(classes = {StatoFatturaRepository.class, StatoFattureRunner.class})
class ClientiRepositoryTest {


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
    @Test
    void findByFatturatoAnnuale() {
    }

    @Test
    void findByDataInserimento() {

        statoFattureRunner.popolaDB();
        provinceRunner.popolaDB();
        comuniRunner.popolaDB();
        indirizziRunner.popolaDB();
        clientiRunner.popolaDB();
        fattureRunner.popolaDB();
        var cList= clientiRepository.findByDataInserimento(Timestamp.valueOf("1998-04-07 00:00:00"));
        assertThat(cList).size().isEqualTo(1);
    }

    @Test
    void findByDataUltimoContatto() {
    }

    @Test
    void findByNomeContattoContaining() {
    }

    @Test
    void findClientiByIdIndirizzo() {
    }

    @Test
    void sortClientiByNomeProvincia() {
    }

    @Test
    void getClientiByNomeProvincia() {
    }
}