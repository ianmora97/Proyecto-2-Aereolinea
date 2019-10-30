/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

/**
 *
 * @author Ian Rodriguez
 */
public class Ciudad {
    String codigoCiudad;
    String nombre;
    String pais;

    public Ciudad(String codigoCiudad, String nombre, String pais) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Ciudad() {
       this.codigoCiudad = "";
        this.nombre = "";
        this.pais = "";
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return codigoCiudad + " , " + nombre + " ," + pais ;
    }
    
}
