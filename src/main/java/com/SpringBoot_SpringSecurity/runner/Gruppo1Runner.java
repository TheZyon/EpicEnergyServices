package com.SpringBoot_SpringSecurity.runner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringBoot_SpringSecurity.entity.BeServiceClienti;
import com.SpringBoot_SpringSecurity.entity.BeServiceComuni;
import com.SpringBoot_SpringSecurity.entity.BeServiceIndirizzi;
import com.SpringBoot_SpringSecurity.entity.BeServiceProvince;
import com.SpringBoot_SpringSecurity.entity.BeServiceStatoFattura;
import com.SpringBoot_SpringSecurity.service.ClientiService;
import com.SpringBoot_SpringSecurity.service.ComuniService;
import com.SpringBoot_SpringSecurity.service.FattureService;
import com.SpringBoot_SpringSecurity.service.IndirizziService;
import com.SpringBoot_SpringSecurity.service.ProvinceService;
import com.SpringBoot_SpringSecurity.service.StatoFatturaService;

@Component
public class Gruppo1Runner implements ApplicationRunner {
	
	@Autowired ComuniService comuneSrv;
	@Autowired ProvinceService prSrv;
	@Autowired IndirizziService indSrv;
	@Autowired StatoFatturaService statoSrv;
	@Autowired FattureService fattSrv;
	@Autowired ClientiService clSrv;

	     @Override
	     public void run(ApplicationArguments args) throws Exception {
		/* System.out.println("GruppoUnoRunning...");
		
		//COMUNI
		 * 
	     BeServiceProvince roma = prSrv.getProvinceById(2l);
	     //System.out.println(roma);
	     List<BeServiceIndirizzi> lista = new ArrayList<BeServiceIndirizzi>();
	     BeServiceIndirizzi ind = indSrv.getIndirizziById(4l);
	     lista.add(ind);

	     BeServiceComuni comune = new BeServiceComuni();
	     comune.setNome("Fiumicino");
	     comune.setBeServiceIndirizzis(lista);
	     comune.setBeServiceProvince(roma);*/
	    	 
         //comuneSrv.createComune(comune);
	    	 
	     //BeServiceComuni comunePreso = comuneSrv.getComuneById(4l);
	     //comunePreso.setNome("FIUMICINO");
	    	 
         //comuneSrv.updateComune(comunePreso);
         //comuneSrv.removeDispositivo(4l);
	     
	 /*   List<BeServiceStatoFattura> listaFatture =  statoSrv.getAllFattura();
	  
	     for (BeServiceStatoFattura f : listaFatture) {
			//System.out.println(f);
		}
	     */
	    	 
	    	 
	    	//FATTURE
	    	 
	    	//System.out.println(fattSrv.getFattureByAnno(2020));
	    	 
	    	//BeServiceClienti c = clSrv.getById(2l); 
	    	//System.out.println(fattSrv.getFattureByBeServiceClienti(c));
	    	 
	    	//BeServiceStatoFattura f = statoSrv.getStatoFatturaById(1l);
	    	//System.out.println(fattSrv.getFattureByBeServiceStatoFattura(f));
	    	 
	    	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        //Date date = formatter.parse("2020-12-16 04:15:35.538");
	        //Timestamp timeStampDate = new Timestamp(date.getTime());
	            
	    	//System.out.println(fattSrv.getFattureByData(timeStampDate));
	    	  
	    	//System.out.println(fattSrv.getFattureByRangeImporto(0,300));
	    	 
	}

}
