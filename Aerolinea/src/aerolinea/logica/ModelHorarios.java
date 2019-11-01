/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoHorario;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelHorarios {
    DaoHorario horarios;
    public ModelHorarios(){
        horarios = new DaoHorario();
    }
    public void agregar(Horario h) throws Exception{
        horarios.HorarioAdd(h);
    }
    public void eliminar(String h) throws Exception{
        horarios.HorarioDelete(h);
    }
    public Horario consultar(String h) throws Exception{
        Horario result = horarios.getHorario(h);
        return result;
    }
    public Horario editar(String h) throws Exception{
        Horario result = horarios.getHorario(h);
        return result;
    }
    public void modificar(Horario h) throws Exception{
        horarios.HorarioUpdate(h);
    }
    public List<Horario> buscar(String nombre) {
        List<Horario> result = horarios.HorarioSearch(nombre);
        return result;
    }
    public List<Horario> buscarTodos() {
        List<Horario> result = horarios.HorarioSearchEO();
        return result;
    }
    static ModelHorarios instancia;

    public static ModelHorarios instanciar() {
        if (instancia == null) {
            instancia = new ModelHorarios();
        }
        return instancia;
    }
}
