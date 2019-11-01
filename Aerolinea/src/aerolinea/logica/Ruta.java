/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.util.Objects;

/**
 *
 * @author Ian Rodriguez
 */
public class Ruta {
    String codigoRuta, //primary Key
            ciudadDestino,
            ciudadOrigen;

    public Ruta() {
        this.codigoRuta = "";
        this.ciudadDestino = "";
        this.ciudadOrigen = "";
    }

    public Ruta(String codigoRuta, String ciudadDestino, String ciudadOrigen) {
        this.codigoRuta = codigoRuta;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(String codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    @Override
    public String toString() {
        return "Ruta{" + "codigoRuta=" + codigoRuta + ", ciudadDestino=" + ciudadDestino + ", ciudadOrigen=" + ciudadOrigen + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigoRuta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ruta other = (Ruta) obj;
        if (!Objects.equals(this.codigoRuta, other.codigoRuta)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
