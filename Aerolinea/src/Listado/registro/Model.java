/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.registro;

import java.util.Observable;
import java.util.Observer;
import aerolinea.logica.Usuario;
/**
 *
 * @author Ian Rodriguez
 */
public class Model extends Observable {
    
    Usuario filtro;

    public Model(Usuario filtro) {
        this.filtro = filtro;
    }

    public Model() {
        this.filtro = new Usuario();
    }

    public Usuario getFiltro() {
        return filtro;
    }

    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
        this.setChanged();
        this.notifyObservers(); 
    }
    
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
