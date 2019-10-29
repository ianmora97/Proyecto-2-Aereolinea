/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.util.logging.Logger;

/**
 *
 * @author Gaby
 */
public class Ciudad {
      String codigoCiudad;
    String nombre;
    Pais pais;

    public Ciudad(String codigoCiudad, String nombre, Pais pais) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Ciudad(String codigoCiudad, String nombre) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
        this.pais = new Pais("","");
    }

    public Ciudad() {
    }

    

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return  codigoCiudad + " , " + nombre + " ," + pais.getNombre()+ '}';
    }
    
}
