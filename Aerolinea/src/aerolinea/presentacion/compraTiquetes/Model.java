/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.compraTiquetes;

import aerolinea.Application;
import aerolinea.logica.Usuario;
import aerolinea.logica.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ian Rodriguez
 */
public class Model extends Observable{
    List<Vuelo> vuelos;
    Vuelo filtrVuelo;
    
    Usuario user;

    public Model() {
        vuelos = new ArrayList<>();
        filtrVuelo = new Vuelo();
        user = Application.Perfil_Controller.getModel().getSesion();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
        this.setChanged();
        this.notifyObservers();
    }

    public Vuelo getFiltrVuelo() {
        return filtrVuelo;
    }

    public void setFiltrVuelo(Vuelo filtrVuelo) {
        this.filtrVuelo = filtrVuelo;
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
