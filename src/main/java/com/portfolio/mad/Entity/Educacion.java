package com.portfolio.mad.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private int desdeE;
    private int hastaE;


    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE,int desdeE, int hastaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.desdeE = desdeE;
        this.hastaE = hastaE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public int getDesdeE() {
        return desdeE;
    }

    public void setDesdeE(int desdeE) {
        this.desdeE = desdeE;
    }

    public int getHastaE() {
        return hastaE;
    }

    public void setHastaE(int hastaE) {
        this.hastaE = hastaE;
    }

   
    
}