package com.example.dorys.proyectos.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dorys on 20/09/2017.
 */

public class Proyecto {

    private String provincia;
    @SerializedName("monto_ejecutado_en_bs")
    private double monto;
    @SerializedName("descripcion_proyecto")
    private String descripcionProyecto;
    private String departamento;
    private  int beneficiarios;
    // private int _id;
    private String municipio;


    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto= descripcionProyecto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento= departamento;
    }

    public int getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(int beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio= municipio;
    }


}
