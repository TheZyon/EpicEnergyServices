package com.SpringBoot_SpringSecurity.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//entity...
public class Indirizzo {

/*
*
*
* -via
-civico
-localitÃ
-cap
-comune*/

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn("id_cliente")
    private Cliente cliente;




}
