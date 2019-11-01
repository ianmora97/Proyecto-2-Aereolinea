/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.usuarios;

import aerolinea.logica.Usuario;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class UsuarioTableModel extends AbstractTableModel {

    List<Usuario> usuarios;

    public UsuarioTableModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Usuario";
            case 1:
                return "Contraseña";
            case 2:
                return "Nombre";
            case 3:
                return "Apellidos";
            case 4:
                return "Correo";
            case 5:
                return "Nacimiento";
            case 6:
                return "Direccion";
            case 7:
                return "Telefono Trabajo";
            case 8:
                return "Celular";
            case 9:
                return "Sexo";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getIdUsuario();
            case 1:
                return u.getContrasenna();
            case 2:
                return u.getNombre();
            case 3:
                return u.getApellidos();
            case 4:
                return u.getCorreo();
            case 5:
                return u.getFechaNacimiento();
            case 6:
                return u.getDireccion();
            case 7:
                return u.getTelefonoTrabajo();
            case 8:
                return u.getCelular();
//            case 9:
//                return sexo(u);
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 9:
                return Icon.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    private Icon sexo(Usuario p) {
        String file = "";
        switch (p.getSexo()) {
            case "M":
                file = "male.png";
                break;
            case "F":
                file = "female.png";
                break;
            default:
                file = "male.png";
                break;
        }
        return new ImageIcon(getClass().getResource("src/aerolinea/media/"+file));
    }
}
