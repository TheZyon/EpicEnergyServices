package com.SpringBoot_SpringSecurity.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.entity.BeServiceIndirizzi;
import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.service.ComuniService;
import com.SpringBoot_SpringSecurity.service.IndirizziService;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;

@Component
public class Gruppo1Runner implements ApplicationRunner {
	
	@Autowired ComuniService comuneSrv;
	@Autowired ProvinceService prSrv;
	@Autowired IndirizziService indSrv;
	@Autowired StatoFatturaService statoSrv;

	     @Override
	     public void run(ApplicationArguments args) throws Exception {
		/* System.out.println("GruppoUnoRunning...");
		
	     BeServiceProvince roma = prSrv.getProvinceById(2l);
	     //System.out.println(roma);
	     List<BeServiceIndirizzi> lista = new ArrayList<BeServiceIndirizzi>();
	     BeServiceIndirizzi ind = indSrv.getIndirizziById(4l);
	     lista.add(ind);

	     BeServiceComuni comune = new BeServiceComuni();
	     comune.setNome("Fiumicino");
	     comune.setBeServiceIndirizzis(lista);
	     comune.setBeServiceProvince(roma);*/
//CREATE	//comuneSrv.createComune(comune);
	     //BeServiceComuni comunePreso = comuneSrv.getComuneById(4l);
	     //comunePreso.setNome("FIUMICINO");
//UPDATE	//comuneSrv.updateComune(comunePreso);
//DELETE	//comuneSrv.removeDispositivo(4l);
	     
	 /*    List<BeServiceStatoFattura> listaFatture =  statoSrv.getAllFattura();
	  
	     for (BeServiceStatoFattura f : listaFatture) {
			//System.out.println(f);
		}
	     */
	   
		
	}

}
