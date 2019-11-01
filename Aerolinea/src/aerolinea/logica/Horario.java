/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.sql.Date;

/**
 *
 * @author Ian Rodriguez
 */
public class Horario {
    
    int duracion; //primary key
    Date fecha;
    String horaLlegada, horaSalida;
    String precio;
   
    public Horario() {
        this.duracion = 0;
        this.fecha = null;
        this.horaLlegada = "";
        this.horaSalida = "";
        this.precio = "";
    }

    public Horario(int duracion, Date fecha, String horaLlegada, String horaSalida, String precio) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Horario{" + "duracion=" + duracion + ", fecha=" + fecha + ", horaLlegada=" + horaLlegada + ", horaSalida=" + horaSalida + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.duracion;
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
        final Horario other = (Horario) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        return true;
    }
    
    
}
