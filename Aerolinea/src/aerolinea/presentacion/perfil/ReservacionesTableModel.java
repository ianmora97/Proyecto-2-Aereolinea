/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.perfil;

import aerolinea.logica.Reservacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class ReservacionesTableModel extends AbstractTableModel {
    List<Reservacion> reservas;

    public ReservacionesTableModel(List<Reservacion> reservas) {
        this.reservas = reservas;
    }

    public List<Reservacion> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservacion> reservas) {
        this.reservas = reservas;
    }
    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 1: return "Vuelo";
            case 2: return "Asiento";
            case 3: return "Pago_id";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservacion v = reservas.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getIdReserva();
            case 1: return v.getVuelo();
            case 2: return v.getAsiento().toString();
            case 3: return v.getPago_id();
            default: return "";
        }
    }
    
}
