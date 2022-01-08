package org.dis.back;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {

    /*Atributos de la clase usuario:*/
    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("departamento")
    private String departamento;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("ubicacion")
    private String ubicacion;

    /*Constructor vacio*/
    public Usuario() {
    }

    /*Constructor completo*/
    public Usuario(int id, String nombre, String departamento, String telefono, String correo, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.telefono = telefono;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario{\n" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                "}\n";
    }

    public void modificarUsuario(Usuario usuarioACopiar){
        this.setNombre(usuarioACopiar.getNombre());
        this.setCorreo(usuarioACopiar.getCorreo());
        this.setDepartamento(usuarioACopiar.getDepartamento());
        this.setTelefono(usuarioACopiar.getTelefono());
        this.setUbicacion(usuarioACopiar.getUbicacion());
    }

    /*Getters and setters:*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
