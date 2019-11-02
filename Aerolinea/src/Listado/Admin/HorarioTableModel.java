/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado.Admin;

import aerolinea.logica.Horario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ian Rodriguez
 */
public class HorarioTableModel extends AbstractTableModel {
    List<Horario> horarios;

    public HorarioTableModel(List<Horario> horarios) {
        this.horarios = horarios;
        
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    
    @Override
    public int getRowCount() {
        return horarios.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override    
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 1: return "Duracion";
            case 2: return "Fecha Salida";
            case 3: return "Hora Salida";
            case 4: return "Hora Llegada";
            case 5: return "Precio";
            default: return "";
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horario v=horarios.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getIdHorario();
            case 1: return v.getDuracion();
            case 2: return v.getFecha().toString();
            case 3: return v.getHoraSalida();
            case 4: return v.getHoraLlegada();
            case 5: return v.getPrecio(); 
            default: return "";
        }
    }
    
}
