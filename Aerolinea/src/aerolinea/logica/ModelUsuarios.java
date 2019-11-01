/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import aerolinea.datos.DaoUsuario;
import java.util.List;

/**
 *
 * @author Ian Rodriguez
 */
public class ModelUsuarios {
    DaoUsuario usuarios;

    public ModelUsuarios() {
       usuarios = new DaoUsuario();
    }

    public void agregar(Usuario v) throws Exception {
        usuarios.UsuarioAdd(v);
    }

    public Usuario consultar(String id) throws Exception {
        Usuario result = usuarios.getUsuario(id);
        return result;
    }

    public void modificar(Usuario v) throws Exception {
        usuarios.UsuarioUpdate(v);
    }

    public List<Usuario> buscar(String nombre) {
        List<Usuario> result = usuarios.UsuarioSearch(nombre);
        return result;
    }
    public List<Usuario> buscarTodos() {
        List<Usuario> result = usuarios.UsuarioSearchEO();
        return result;
    }
    
    static ModelUsuarios instancia;

    public static ModelUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ModelUsuarios();
        }
        return instancia;
    }
}
