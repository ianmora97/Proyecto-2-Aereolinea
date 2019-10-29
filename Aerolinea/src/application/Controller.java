
package application;
import aerolinea.Application;

/**
 *
 * @author Gaby
 */
public class Controller {
        
    Model model;
    View view;
    
    public Controller(Model m, View v)
    {
        this.model = m;
        this.view = v;
        view.setModel(model);
        view.setControladora(this);
        view.setVisible(true);
    }
    public void personasEdicionShow()
    {
  
       Application.Edicion_Controlador.show();
    }
    public void personasListadoShow()
    {
        Application.Listado_Controlador.show();
    }
}
