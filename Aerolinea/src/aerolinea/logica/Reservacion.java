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
public class Reservacion {
    String idReserva,vuelo,asiento,Pago_id;

    public Reservacion(String idReserva, String vuelo, String asiento, String Pago_id) {
        this.idReserva = idReserva;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.Pago_id = Pago_id;
    }

    public Reservacion() {
        this.idReserva = "";
        this.vuelo = "";
        this.asiento = "";
        this.Pago_id = "";
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getPago_id() {
        return Pago_id;
    }

    public void setPago_id(String Pago_id) {
        this.Pago_id = Pago_id;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "idReserva=" + idReserva + ", vuelo=" + vuelo + ", asiento=" + asiento + ", Pago_id=" + Pago_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idReserva);
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
        final Reservacion other = (Reservacion) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        return true;
    }
    
    
}
