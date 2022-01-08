package org.dis.back;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Prestamo {

    /*Atributos de la clase prestamo:*/
    @JsonProperty("id")
    private int id;
    @JsonProperty("usuarioID")
    private int usuarioID;
    @JsonProperty("equipoID")
    private int equipoID;
    @JsonProperty("fechaInicio")
    private String fechaInicio;
    @JsonProperty("fechaFin")
    private String fechaFin;
    @JsonProperty("fechaReal")
    private String fechaReal;
    @JsonProperty("comentarios")
    private String comentarios;

    /*Constructor vacio*/
    public Prestamo() {
    }

    /*Constructor completo*/
    public Prestamo(int id, int usuarioID, int equipoID, String fechaInicio, String fechaFin, String fechaReal, String comentarios) {
        this.id = id;
        this.usuarioID = usuarioID;
        this.equipoID = equipoID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaReal = fechaReal;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Prestamo{\n" +
                "id=" + id +
                ", usuarioID=" + usuarioID +
                ", equipoID=" + equipoID +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaReal=" + fechaReal +
                ", comentarios='" + comentarios + '\'' +
                "}\n";
    }

    public void modificarPrestamo(Prestamo prestamoACopiar){
        this.setComentarios(prestamoACopiar.getComentarios());
        this.setEquipoID(prestamoACopiar.getEquipoID());
        this.setFechaFin(prestamoACopiar.getFechaFin());
        this.setFechaInicio(prestamoACopiar.getFechaInicio());
        this.setFechaReal(prestamoACopiar.getFechaReal());
        this.setUsuarioID(prestamoACopiar.getUsuarioID());
    }

    /*Getters and setters*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(String fechaReal) {
        this.fechaReal = fechaReal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
