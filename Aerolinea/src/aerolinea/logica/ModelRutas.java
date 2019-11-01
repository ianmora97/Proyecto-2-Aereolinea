/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoRutas;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelRutas {
    DaoRutas rutas;

    public ModelRutas() {
       rutas = new DaoRutas();
    }
    public void agregar(Ruta v) throws Exception {
        rutas.RutaAdd(v);
    }
    public void eliminar(String a) throws Exception{
        rutas.RutaDelete(a);
    }
    public Ruta consultar(String id) throws Exception {
        Ruta result = rutas.getRuta(id);
        return result;
    }
    public Ruta editar(String id) throws Exception {
        Ruta result = rutas.getRuta(id);
        return result;
    }
    public void modificar(Ruta v) throws Exception {
        rutas.RutaUpdate(v);
    }

    public List<Ruta> buscar(String nombre) {
        List<Ruta> result = rutas.RutaSearch(nombre);
        return result;
    }
    public List<Ruta> buscarTodos() {
        List<Ruta> result = rutas.UsuarioSearchEO();
        return result;
    }
    static ModelRutas instancia;

    public static ModelRutas instanciar() {
        if (instancia == null) {
            instancia = new ModelRutas();
        }
        return instancia;
    }
}
