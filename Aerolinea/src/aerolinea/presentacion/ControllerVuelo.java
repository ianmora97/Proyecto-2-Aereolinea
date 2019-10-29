
package aerolinea.presentacion;

import aerolinea.logica.Ciudad;
import aerolinea.logica.Vuelo;


public class ControllerVuelo {
     ModelVuelo model;
    ViewVuelo view;

    public ControllerVuelo(ModelVuelo m, ViewVuelo v) {
        this.model = m;
        this.view = v;
        view.setModel(model);
          model.setCiudades(aerolinea.logica.ModelVuelo.instanciar().ciudadBuscar(""));
        view.setControladora(this);
    }

    public void consultar(String id) {
        try {
            model.setVuelo(aerolinea.logica.ModelVuelo.instanciar().consultar(id));
        } catch (Exception ex) {
            model.setVuelo(new Vuelo(id, "", new Ciudad(), new Ciudad()));
        }

    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    public void modificar(Vuelo v) {
        try {
            aerolinea.logica.ModelVuelo.instanciar().modificar(v);
           aerolinea.Application.Listado_Controlador.buscar(v.getDia());
        } catch (Exception ex) {
        }
    }

    public void agregar(Vuelo v) {
        try {
            aerolinea.logica.ModelVuelo.instanciar().agregar(v);
            model.setVuelo(new Vuelo("",""));
    
        } catch (Exception ex) {

        }
    }

}
