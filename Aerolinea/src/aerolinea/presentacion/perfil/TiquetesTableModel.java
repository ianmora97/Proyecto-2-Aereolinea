/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.perfil;

import aerolinea.logica.Tiquete;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class TiquetesTableModel extends AbstractTableModel{
    List<Tiquete> tiquetes;

    public TiquetesTableModel(List<Tiquete> reservas) {
        this.tiquetes = reservas;
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(List<Tiquete> reservas) {
        this.tiquetes = reservas;
    }
    @Override
    public int getRowCount() {
        return tiquetes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 1: return "Reserva";
            case 2: return "Usuario";
            case 3: return "Asiento";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tiquete v = tiquetes.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getNumTiquete();
            case 1: return v.getReservacion();
            case 2: return v.getUsuario();
            case 3: return v.getAsiento();
            default: return "";
        }
    }
    
}
