package com.SpringBoot_SpringSecurity.runner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.service.ClientiService;

@Component
public class ClientiRunner implements ApplicationRunner {

	@Autowired ClientiService servClienti;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("alla grande");

		//test cliente per fatturato
        List<BeServiceClienti> clientiListaPerFatturato= servClienti.cercaTramiteFatturato(BigDecimal.valueOf(128425.64));
        clientiListaPerFatturato.forEach(ele-> System.out.println(ele.getNomeContatto()));
		
		//test cliente per nome
		List<BeServiceClienti> clientiListaNome = servClienti.cercaTramiteParteNome("ante");
		clientiListaNome.forEach(ele-> System.out.println(ele.getNomeContatto()));

		//test cliente per ultimo contatto
		List<BeServiceClienti> clientiListaUltimoContatto = servClienti.cercaTramiteDataUltimoContatto(Timestamp.valueOf("2021-03-05 14:06:43.709"));
		clientiListaUltimoContatto.forEach(ele-> System.out.println(ele.getNomeContatto()));

		//test cliente per data di inserimento
		List<BeServiceClienti> clientiListaDataInserimento =  servClienti.cercaTramiteDataUltimoContatto(Timestamp.valueOf("2021-03-29 06:53:29.705"));
		clientiListaDataInserimento.forEach(ele-> System.out.println(ele.getNomeContatto()));
	}

}
