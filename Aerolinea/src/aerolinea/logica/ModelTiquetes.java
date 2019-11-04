/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoTiquetes;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelTiquetes {
    DaoTiquetes tiquetes;

    public ModelTiquetes() {
       tiquetes = new DaoTiquetes();
    }
    public void agregar(Tiquete t) throws Exception{
        tiquetes.ReservacionAdd(t);
    }
    public Tiquete consultar(String id) throws Exception {
        Tiquete result = tiquetes.getTiquete(id);
        return result;
    }
    public List<Tiquete> buscarTodos() {
        List<Tiquete> result = tiquetes.TiqueteSearchEO();
        return result;
    }
    public List<Tiquete> selectReserva(String s) {
        List<Tiquete> result = tiquetes.getTiquetesList(s);
        return result;
    }
    static ModelTiquetes instancia;

    public static ModelTiquetes instanciar() {
        if (instancia == null) {
            instancia = new ModelTiquetes();
        }
        return instancia;
    }
}
