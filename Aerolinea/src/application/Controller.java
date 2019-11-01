
package application;
import aerolinea.Application;
import aerolinea.datos.DaoUsuario;
import aerolinea.logica.Usuario;
import java.util.List;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Ian Rodriguez
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
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
    }
    public void show(){
        view.setVisible(true);
    }
    public void usuariosListadoShow(){
        Application.Listado_Usuarios_Controller.show();
    }
    public Usuario consultar(String id) throws Exception{
        return aerolinea.logica.ModelUsuarios.instanciar().consultar(id);
    }
    public void registrarShow(){
        Application.Registro_Controller.show();
    }
}
