/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

/**
 *
 * @author Gaby
 */
public class Vuelo {
    String idVuelo;
    String dia;
   Ciudad origen;
    Ciudad destino;
 

    public Vuelo() {
    }

    public Vuelo(String idVuelo, String dia, Ciudad origen, Ciudad destino) {
        this.idVuelo = idVuelo;
        this.dia = dia;
        this.origen = origen;
        this.destino = destino;
    }

    public Vuelo(String idVuelo, String dia) {
        this.idVuelo = idVuelo;
        this.dia = dia;
        this.origen=new Ciudad("","");
        this.destino=new Ciudad("","");
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

 

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

 
    
  
    
}
