package com.SpringBoot_SpringSecurity.runner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.SpringBoot_SpringSecurity.repository.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.service.ClientiService;

@Component
public class ClientiRunner implements ApplicationRunner {

	@Autowired private ClientiRepository repo;
	@Autowired ClientiService servClienti;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("alla grande");

		//test cliente per fatturato
/*        List<BeServiceClienti> clientiListaPerFatturato= servClienti.cercaTramiteFatturato(BigDecimal.valueOf(128425.64));
        clientiListaPerFatturato.forEach(ele-> System.out.println(ele.getNomeContatto()));*/
		
		//test cliente per nome
	/*	List<BeServiceClienti> clientiListaNome = servClienti.cercaTramiteParteNome("ante");
		clientiListaNome.forEach(ele-> System.out.println(ele.getNomeContatto()));*/

		//test cliente per ultimo contatto del metodo obsoleto (ora commentato)
		//List<BeServiceClienti> clientiListaUltimoContatto = servClienti.cercaTramiteDataUltimoContatto(Timestamp.valueOf("2021-03-05 14:06:43.709"));
		//clientiListaUltimoContatto.forEach(ele-> System.out.println(ele.getNomeContatto()));

		//test cliente per data di inserimento del metodo obsoleto (ora commentato)
		//List<BeServiceClienti> clientiListaDataInserimento =  servClienti.cercaTramiteDataUltimoContatto(Timestamp.valueOf("2021-03-29 06:53:29.705"));
		//clientiListaDataInserimento.forEach(ele-> System.out.println(ele.getNomeContatto()));
		
		//test clienti in data specifica del cerca tramite inserimento
/*		LocalDate data = LocalDate.parse("2020-10-27");
		List<BeServiceClienti> clientiInData = servClienti.cercaTramiteInserimentoData(data);	
		clientiInData.forEach(ele-> System.out.println(ele.getNomeContatto()));*/
		
		
		//test clienti in data specifica del cerca tramite ultime contatto
		/*LocalDate date = LocalDate.parse("2021-02-24");
		List<BeServiceClienti> giorgio = servClienti.cercaTramiteDataUltimoContatto(date);
		giorgio.forEach(ele-> System.out.println(ele.getNomeContatto()));*/


			repo.getClientiByNomeProvincia("ROMA").forEach(res->{System.out.println(res);});


//		repo.sortClientiByNomeProvincia().forEach(res->System.out.println(res.getBeServiceIndirizzi1().getBeServiceComuni().getBeServiceProvince()));

	}

}
