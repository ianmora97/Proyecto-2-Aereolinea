/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado;

/**
 *
 * @author Gaby
 */
public class ControllerVuelo {
       ModelVuelo model;
    ViewVuelo view;

    public ControllerVuelo(ModelVuelo model, ViewVuelo view) {
        this.model = model;
        this.view = view;
        view.setModelo(model);
        view.setControlador(this);
    }
    
    public void buscar(String dia){
        model.getFiltro().setDia(dia);
        this.refrescar();
    }

    public void refrescar() {
        model.setPersonas(aerolinea.logica.ModelVuelo.instanciar().buscar(model.getFiltro().getDia()));        
    }    

    public void editar(int row){
       // Application.Edicion_Controlador.consultar(model.getPersonas().get(row).getId());
       
    }
    
    public void show(){
        view.setVisible(true);
    }

    public void hide(){
        view.setVisible(false);
    }      
    
}
