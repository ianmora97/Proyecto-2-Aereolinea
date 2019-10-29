/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

public class Viaje {
    String numViaje;
    String fechaEsp;
    Vuelo vuelo;

    public Viaje(String numViaje, String fechaEsp, Vuelo vuelo) {
        this.numViaje = numViaje;
        this.fechaEsp = fechaEsp;
        this.vuelo = vuelo;
    }

    public Viaje(String numViaje, String fechaEsp) {
        this.numViaje = numViaje;
        this.fechaEsp = fechaEsp;
        this.vuelo= new Vuelo("","");
    }

    public String getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(String numViaje) {
        this.numViaje = numViaje;
    }

    public String getFechaEsp() {
        return fechaEsp;
    }

    public void setFechaEsp(String fechaEsp) {
        this.fechaEsp = fechaEsp;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

  
    
}
