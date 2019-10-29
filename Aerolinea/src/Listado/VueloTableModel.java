/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado;

import aerolinea.logica.Vuelo;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class VueloTableModel extends AbstractTableModel {

       List<Vuelo> vuelos;   

    public VueloTableModel(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    
    
    @Override
    public int getRowCount() {
        return vuelos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 1: return "Dia";
            case 2: return "Origen";
            case 3: return "Destino";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vuelo v=vuelos.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getIdVuelo();
            case 1: return v.getDia();
            case 2: return v.getOrigen();
            case 3: return v.getDestino();
            default: return "";
        }
    }
    





    
}
