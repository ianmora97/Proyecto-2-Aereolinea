/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

/**
 *
 * @author Gaby
 */
public class Pais {
    String codigoPais;
    String nombre;

    public Pais(String codigoPais, String nombre) {
        this.codigoPais = codigoPais;
        this.nombre = nombre;
    }

    public Pais() {
    }

    
    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
