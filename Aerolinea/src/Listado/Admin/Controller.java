/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.Application;
import aerolinea.logica.Avion;
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
    public void leerDatos() {
        model.setAviones(aerolinea.logica.ModelAviones.instanciar().buscarTodos());
        model.setRutas(aerolinea.logica.ModelRutas.instanciar().buscarTodos());
    }
    public void editarAviones(int row) throws Exception {
        aerolinea.logica.ModelAviones.instanciar().editar(model.getFiltroAvion().getIdTipoAvion());
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
    public void buscarRuta(String s){
        model.getFiltroRuta().setCodigoRuta(s);
        model.setRutas(aerolinea.logica.ModelRutas.instanciar().buscar(model.getFiltroRuta().getCodigoRuta()));
    }
    public void updateRuta(Ruta ruta) throws Exception {
        aerolinea.logica.ModelRutas.instanciar().modificar(ruta);
    }
    /*---------------------------------METODOS HORARIOS-----------------------------------------*/
    
    
    
    

}
