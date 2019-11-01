/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoAvion;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelAviones {
    DaoAvion usuarios;

    public ModelAviones() {
       usuarios = new DaoAvion();
    }

    public void agregar(Avion v) throws Exception {
        usuarios.AvionAdd(v);
    }
    public void eliminar(String a) throws Exception{
        usuarios.AvionDelete(a);
    }
    public Avion consultar(String id) throws Exception {
        Avion result = usuarios.getAvion(id);
        return result;
    }
    public Avion editar(String id) throws Exception {
        Avion result = usuarios.getAvion(id);
        return result;
    }
    public void modificar(Avion v) throws Exception {
        usuarios.AvionUpdate(v);
    }

    public List<Avion> buscar(String nombre) {
        List<Avion> result = usuarios.AvionSearch(nombre);
        return result;
    }
    public List<Avion> buscarTodos() {
        List<Avion> result = usuarios.AvionSearchEO();
        return result;
    }
    static ModelAviones instancia;

    public static ModelAviones instanciar() {
        if (instancia == null) {
            instancia = new ModelAviones();
        }
        return instancia;
    }
}
