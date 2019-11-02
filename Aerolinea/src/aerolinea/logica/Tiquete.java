/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

/**
 *
 * @author Ian Rodriguez
 */
public class Tiquete {
    String numTiquete;
    String reservacion;
    String usuario;
    String asiento;

    public Tiquete(String numTiquete, String reservacion, String usuario,String asiento) {
        this.numTiquete = numTiquete;
        this.reservacion = reservacion;
        this.usuario = usuario;
        this.asiento= asiento;
    }

    public Tiquete() {
        this.numTiquete = "";
        this.reservacion = "";
        this.usuario = "";
        this.asiento= "";
    }
    
    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    
    public String getNumTiquete() {
        return numTiquete;
    }

    public void setNumTiquete(String numTiquete) {
        this.numTiquete = numTiquete;
    }

    public String getReservacion() {
        return reservacion;
    }

    public void setReservacion(String reservacion) {
        this.reservacion = reservacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
