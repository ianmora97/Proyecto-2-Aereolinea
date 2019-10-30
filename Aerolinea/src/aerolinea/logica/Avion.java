/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.util.Objects;

/**
 *
 * @author Ian Rodriguez
 */
public class Avion {
    String idTipoAvion,modelo,marca,anno;
    int numPasajeros,filas,asientos;

    public Avion(String idTipoAvion, String modelo, String marca, String anno, int numPasajeros, int filas, int asientos) {
        this.idTipoAvion = idTipoAvion;
        this.modelo = modelo;
        this.marca = marca;
        this.anno = anno;
        this.numPasajeros = numPasajeros;
        this.filas = filas;
        this.asientos = asientos;
    }
public Avion() {
        this.idTipoAvion = "";
        this.modelo = "";
        this.marca = "";
        this.anno = "";
        this.numPasajeros = 0;
        this.filas = 0;
        this.asientos = 0;
    }
    public String getIdTipoAvion() {
        return idTipoAvion;
    }

    public void setIdTipoAvion(String idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idTipoAvion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avion other = (Avion) obj;
        if (!Objects.equals(this.idTipoAvion, other.idTipoAvion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avion{" + "idTipoAvion=" + idTipoAvion + ", modelo=" + modelo + ", marca=" + marca + ", anno=" + anno + ", numPasajeros=" + numPasajeros + ", filas=" + filas + ", asientos=" + asientos + '}';
    }
    
}
