package me.datapark.profile;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private String marca;
    private String modelo;
    private String matricula;
    private String tipoTanque;

    public Vehicle(String marca, String modelo, String matricula, String tipoTanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.tipoTanque = tipoTanque;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoTanque() {
        return tipoTanque;
    }

    public void setTipoTanque(String tipoTanque) {
        this.tipoTanque = tipoTanque;
    }
}
