/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.usuarios;

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
    List<Usuario> usuarios;
    Usuario filtro;
    
    

    public Model(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        filtro = new Usuario();
    }

    public Model() {
        usuarios = new ArrayList<>();
        filtro=new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.setChanged();
        this.notifyObservers(); 
        
    }
   
    public Usuario getFiltro() {
        return filtro;
    }

    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
    }
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();   
    }
}
