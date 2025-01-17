/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.Application;
import aerolinea.logica.Avion;
import aerolinea.logica.Horario;
import aerolinea.logica.Ruta;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ian Rodriguez
 */
public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModelo(model);
        view.setControlador(this);
        leerDatos();
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setTitle("Administracion");
        
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    
    public void usuariosListadoShow() {
        Application.Listado_Usuarios_Controller.show();
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }
    
    public void leerDatos() {
        model.setAviones(aerolinea.logica.ModelAviones.instanciar().buscarTodos());
        model.setRutas(aerolinea.logica.ModelRutas.instanciar().buscarTodos());
        model.setHorarios(aerolinea.logica.ModelHorarios.instanciar().buscarTodos());
        model.setVuelos(aerolinea.logica.ModelVuelo.instanciar().buscarTodos());
    }
    /*------------------METODOS AVIONES------------------------*/

    public void buscarAvion(String id) {
        model.getFiltroAvion().setIdTipoAvion(id);
        model.setAviones(aerolinea.logica.ModelAviones.instanciar().buscar(model.getFiltroAvion().getIdTipoAvion()));
    }
    public void updateAvion(Avion a) throws Exception {
        aerolinea.logica.ModelAviones.instanciar().modificar(a);
    }
    public void insertarAvion() throws Exception {
        aerolinea.logica.ModelAviones.instanciar().agregar(model.filtroAvion);
    }
    public void editarAviones(int row) throws Exception {
        aerolinea.logica.ModelAviones.instanciar().editar(model.getFiltroAvion().getIdTipoAvion());
    }
    public Avion consultarAvion(String s) throws Exception{
        Avion result = aerolinea.logica.ModelAviones.instanciar().consultar(s);
        return result;
    }
    public void deleteAviones(String text) throws Exception {
        aerolinea.logica.ModelAviones.instanciar().eliminar(text);
    }
    /*--------------------------------METODOS RUTAS-------------------------------------*/
    public void insertarRuta() throws Exception {
        aerolinea.logica.ModelRutas.instanciar().agregar(model.filtroRuta);
    }
    public void editarRuta(int row) throws Exception{
        aerolinea.logica.ModelRutas.instanciar().editar(model.getFiltroRuta().getCodigoRuta());
    }
    public void deleteRuta(String text) throws Exception{
        aerolinea.logica.ModelRutas.instanciar().eliminar(text);
    }
    public Ruta consultarRuta(String s) throws Exception{
        Ruta result = aerolinea.logica.ModelRutas.instanciar().consultar(s);
        return result;
    }
    public void buscarRuta(String s){
        model.getFiltroRuta().setCodigoRuta(s);
        model.setRutas(aerolinea.logica.ModelRutas.instanciar().buscar(model.getFiltroRuta().getCodigoRuta()));
    }
    public void updateRuta(Ruta ruta) throws Exception {
        aerolinea.logica.ModelRutas.instanciar().modificar(ruta);
    }
    /*---------------------------------METODOS HORARIOS-----------------------------------------*/
    public void insertarHorario() throws Exception {
        aerolinea.logica.ModelHorarios.instanciar().agregar(model.filtroHorario);
    }
    public void editarHorario(int row) throws Exception{
        aerolinea.logica.ModelHorarios.instanciar().editar(model.getFiltroHorario().getDuracion());
    }
    public void deleteHorario(String text) throws Exception{
        aerolinea.logica.ModelHorarios.instanciar().eliminar(text);
    }
    public Horario consultarHorario(String s) throws Exception{
        Horario result = aerolinea.logica.ModelHorarios.instanciar().consultar(s);
        return result;
    }
    public void buscarHorario(String s){
        model.getFiltroHorario().setDuracion(s);
        model.setHorarios(aerolinea.logica.ModelHorarios.instanciar().buscar(model.getFiltroHorario().getDuracion()));
    }
    public void updateHorario(Horario horario) throws Exception {
        aerolinea.logica.ModelHorarios.instanciar().modificar(horario);
    }
    /*----------------------------------METODOS DE VUELOS------------------------------*/
    public void insertarVuelo() throws Exception {
        aerolinea.logica.ModelVuelo.instanciar().agregar(model.filtrVuelo);
    }
    public void editarVuelo(int row) throws Exception{
        aerolinea.logica.ModelHorarios.instanciar().editar(model.getFiltroHorario().getDuracion());
    }
    public int getCant() throws Exception{
        return aerolinea.logica.ModelVuelo.instanciar().getCant();
    }
    public void deleteVuelo(String text) throws Exception{
        aerolinea.logica.ModelHorarios.instanciar().eliminar(text);
    }
    public void buscarVuelo(String s){
        model.getFiltrVuelo().setIdVuelo(s);
        model.setVuelos(aerolinea.logica.ModelVuelo.instanciar().buscar(model.getFiltrVuelo().getIdVuelo()));
    }
    public void updateVuelo(Horario horario) throws Exception {
        aerolinea.logica.ModelHorarios.instanciar().modificar(horario);
    }
    

}
