/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.main;


import aerolinea.logica.Vuelo;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Ian Rodriguez
 */
public class DescuentoTableModel extends AbstractTableModel{
    List<Vuelo> vuelos;
    public DescuentoTableModel(List<Vuelo> vuelos){
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
        return 13;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Vuelo";
            case 1: return "Ruta";
            case 2: return "Destino";
            case 3: return "Origen";
            case 4: return "Fecha";
            case 5: return "Salida";
            case 6: return "Llegada";
            case 7: return "Duracion";
            case 8: return "Precio";
            case 9: return "Cantidad";
            case 10: return "Marca";
            case 11: return "Modelo";
            case 12: return "Año";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vuelo v = vuelos.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getIdVuelo();
            case 1: return v.getRuta().getCodigoRuta();
            case 2: return v.getRuta().getCiudadDestino();
            case 3: return v.getRuta().getCiudadOrigen();
            case 4: return v.getHorario().getFecha();
            case 5: return v.getHorario().getHoraSalida();
            case 6: return v.getHorario().getHoraLlegada();
            case 7: return v.getHorario().getDuracion();
            case 8: return v.getHorario().getPrecio();
            case 9: return v.getAvion().getNumPasajeros();
            case 10: return v.getAvion().getMarca();
            case 11: return v.getAvion().getModelo();
            case 12: return v.getAvion().getAnno();
            default: return "";
        }
    }
}
