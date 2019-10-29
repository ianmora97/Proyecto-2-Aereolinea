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
public class Reservacion {
    String numReserva;
    Viaje viaje;
    int numAsiento;

    public Reservacion(String numReserva, Viaje viaje, int numAsiento) {
        this.numReserva = numReserva;
        this.viaje = viaje;
        this.numAsiento = numAsiento;
    }

    public Reservacion(String numReserva, int numAsiento) {
        this.numReserva = numReserva;
        this.numAsiento = numAsiento;
    }

    public String getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(String numReserva) {
        this.numReserva = numReserva;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }
    
    
}
