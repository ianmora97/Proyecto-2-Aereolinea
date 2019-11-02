/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.perfil;

import aerolinea.logica.Reservacion;
import aerolinea.logica.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ian Rodriguez
 */
public class Model extends Observable{
    Usuario sesion;
    
    List<Reservacion> reservas;
    Reservacion filtroReserva;

    public Model() {
        this.sesion = new Usuario();
        this.reservas = new ArrayList<>();
        this.filtroReserva = new Reservacion();
    }

    public List<Reservacion> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservacion> reservas) {
        this.reservas = reservas;
        this.setChanged();
        this.notifyObservers();
    }

    public Reservacion getFiltroReserva() {
        return filtroReserva;
    }

    public void setFiltroReserva(Reservacion filtroReserva) {
        this.filtroReserva = filtroReserva;
        this.setChanged();
        this.notifyObservers();
    }
    
    public Usuario getSesion() {
        return sesion;
    }

    public void setSesion(Usuario sesion) {
        this.sesion = sesion;
        this.setChanged();
        this.notifyObservers();
    }
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
}
