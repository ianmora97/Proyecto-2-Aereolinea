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
public class Vuelo {
    String idVuelo;
    Avion avion;
    Ruta ruta;
    Horario horario;

    public Vuelo(String idVuelo, Avion avion, Ruta ruta, Horario horario) {
        this.idVuelo = idVuelo;
        this.avion = avion;
        this.ruta = ruta;
        this.horario = horario;
    }
    public Vuelo(){
        this.idVuelo = "";
        this.avion = null;
        this.ruta = null;
        this.horario = null;
    }
    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idVuelo=" + idVuelo + ", avion=" + avion + ", ruta=" + ruta + ", horario=" + horario + '}';
    }
    
    

}
