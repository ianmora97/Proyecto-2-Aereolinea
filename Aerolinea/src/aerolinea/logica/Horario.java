/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Ian Rodriguez
 */
public class Horario {
    
    String idHorario; //primary key
    String duracion; 
    String fecha;
    String horaLlegada, horaSalida;
    String precio;
   
    public Horario() {
        idHorario = "";
        this.duracion = "";
        this.fecha = "";
        this.horaLlegada = "";
        this.horaSalida = "";
        this.precio = "";
    }

    public Horario(String horario, String duracion, String fecha, String horaLlegada, String horaSalida, String precio) {
        this.idHorario = horario;
        this.duracion = duracion;
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.precio = precio;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.duracion);
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
