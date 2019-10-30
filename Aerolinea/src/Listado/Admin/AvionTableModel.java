/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Avion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class AvionTableModel extends AbstractTableModel{
    List<Avion> aviones;

    public AvionTableModel(List<Avion> aviones) {
        this.aviones = aviones;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public int getRowCount() {
        return aviones.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 2: return "Cant Pasajeros";
            case 1: return "Filas";
            case 3: return "Asientos";
            case 4: return "Modelo";
            case 5: return "Marca";
            case 6: return "Anio";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avion v=aviones.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getIdTipoAvion();
            case 1: return v.getNumPasajeros();
            case 2: return v.getFilas();
            case 3: return v.getAsientos();
            case 4: return v.getModelo();
            case 5: return v.getMarca();
            case 6: return v.getAnno();  
            default: return "";
        }
    }
}
