/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Ruta;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Ian Rodriguez
 */
public class RutaTableModel extends AbstractTableModel{
    List<Ruta> rutas;

    public RutaTableModel(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }
    
    @Override
    public int getRowCount() {
        return rutas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Codigo";
            case 1: return "Destino";
            case 2: return "Origen";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ruta v = rutas.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getCodigoRuta();
            case 1: return v.getCiudadDestino();
            case 2: return v.getCiudadOrigen();
            default: return "";
        }
    }
}
