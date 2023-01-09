package com.portfolio.mad.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private int desdeE;
    @NotBlank
    private int hastaE;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE,int desdeE, int hastaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.desdeE = desdeE;
        this.hastaE = hastaE;
                
    }
    //Getters & Setters

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
