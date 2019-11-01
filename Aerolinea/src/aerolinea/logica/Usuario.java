/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.util.Objects;

/**
 *
 * @author Gaby
 */
public class Usuario {
    String idUsuario, contrasenna, nombre, apellidos,correo,fechaNacimiento,direccion,telefonoTrabajo,celular,sexo;

    public Usuario(String idUsuario, String contrasenna, String nombre, String apellidos, String correo, String fechaNacimiento, String direccion, String telefonoTrabajo, String celular) {
        this.idUsuario = idUsuario;
        this.contrasenna = contrasenna;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoTrabajo = telefonoTrabajo;
        this.celular = celular;
        this.sexo = "";
    }

    public Usuario() {
        this.idUsuario = "";
        this.contrasenna = "";
        this.nombre = "";
        this.apellidos = "";
        this.correo = "";
        this.fechaNacimiento = "";
        this.direccion = "";
        this.telefonoTrabajo = "";
        this.celular = "";
        this.sexo = "";
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public String getCelular() {
        return celular;
    }
    public String getSexo(){
        return sexo;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setSexo(String s){
        this.sexo =s;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }
    
}
