/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;
import aerolinea.presentacion.ControllerVuelo;
import aerolinea.presentacion.ModelVuelo;
import aerolinea.presentacion.ViewVuelo;


public class Application {

    public static void main(String[] args)
    {  
        ModelVuelo modelo = new ModelVuelo();
        ViewVuelo view = new ViewVuelo();
        ControllerVuelo controladora = new ControllerVuelo(modelo,view);
        Edicion_Controlador = controladora;
        
        Listado.ViewVuelo vista2=new Listado.ViewVuelo();
        Listado.ModelVuelo modelo2= new Listado.ModelVuelo();
        vista2.setModelo(modelo2);
        
        Listado.ControllerVuelo controlador2 = new Listado.ControllerVuelo(modelo2, vista2);
        Listado_Controlador = controlador2;
       
        application.Model modelo3 = new application.Model();
     application.View vista3 = new application.View();
     application.Controller controladora3 = new application.Controller(modelo3, vista3);
       
        
        vista3.panel.add(view);
        vista3.panel.add(vista2);
    }
    public static Listado.ControllerVuelo Listado_Controlador;
    public static ControllerVuelo Edicion_Controlador;
}
