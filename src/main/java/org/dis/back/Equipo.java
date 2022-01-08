package org.dis.back;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipo {

    /*Atributos de la clase equipo:*/
    @JsonProperty("id")
    private int id;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("tipoDeUso")
    private String tipoDeUso;
    @JsonProperty("versionSO")
    private String versionSO;
    @JsonProperty("nombreSO")
    private String nombreSO;
    @JsonProperty("procesador")
    private String procesador;
    @JsonProperty("ram")
    private int ram;
    @JsonProperty("valocidadRam")
    private int valocidadRam;
    @JsonProperty("tipoDiscoDuro")
    private String tipoDiscoDuro;
    @JsonProperty("capacidadDiscoDuro")
    private int capacidadDiscoDuro;
    @JsonProperty("diagonalPantalla")
    private int diagonalPantalla;
    @JsonProperty("resolucionPantalla")
    private String resolucionPantalla;
    @JsonProperty("nombreSoftwarePago")
    private String nombreSoftwarePago;
    @JsonProperty("versionSoftwarePago")
    private String versionSoftwarePago;
    @JsonProperty("tipoSoftwarePago")
    private String tipoSoftwarePago;
    @JsonProperty("nombreSoftwareLibre")
    private String nombreSoftwareLibre;
    @JsonProperty("versionSoftwareLibre")
    private String versionSoftwareLibre;

    /*Constructor vacio*/
    public Equipo() {
    }

    /*Constructor completo*/
    public Equipo(int id, String tipo, String marca, String tipoDeUso, String versionSO, String nombreSO, String procesador,
                  int ram, int valocidadRam, String tipoDiscoDuro, int capacidadDiscoDuro, int diagonalPantalla,
                  String resolucionPantalla, String nombreSoftwarePago, String versionSoftwarePago, String tipoSoftwarePago,
                  String nombreSoftwareLibre, String versionSoftwareLibre) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.tipoDeUso = tipoDeUso;
        this.versionSO = versionSO;
        this.nombreSO = nombreSO;
        this.procesador = procesador;
        this.ram = ram;
        this.valocidadRam = valocidadRam;
        this.tipoDiscoDuro = tipoDiscoDuro;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.diagonalPantalla = diagonalPantalla;
        this.resolucionPantalla = resolucionPantalla;
        this.nombreSoftwarePago = nombreSoftwarePago;
        this.versionSoftwarePago = versionSoftwarePago;
        this.tipoSoftwarePago = tipoSoftwarePago;
        this.nombreSoftwareLibre = nombreSoftwareLibre;
        this.versionSoftwareLibre = versionSoftwareLibre;
    }

    @Override
    public String toString() {
        return "Equipo{\n" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", tipoDeUso='" + tipoDeUso + '\'' +
                ", versionSO='" + versionSO + '\'' +
                ", nombreSO='" + nombreSO + '\'' +
                ", procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", valocidadRam=" + valocidadRam +
                ", tipoDiscoDuro='" + tipoDiscoDuro + '\'' +
                ", capacidadDiscoDuro=" + capacidadDiscoDuro +
                ", diagonalPantalla=" + diagonalPantalla +
                ", resolucionPantalla='" + resolucionPantalla + '\'' +
                ", nombreSoftwarePago='" + nombreSoftwarePago + '\'' +
                ", versionSoftwarePago='" + versionSoftwarePago + '\'' +
                ", tipoSoftwarePago='" + tipoSoftwarePago + '\'' +
                ", nombreSoftwareLibre='" + nombreSoftwareLibre + '\'' +
                ", versionSoftwareLibre='" + versionSoftwareLibre + '\'' +
                "}\n";
    }

    /*Getters and setters*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoDeUso() {
        return tipoDeUso;
    }

    public void setTipoDeUso(String tipoDeUso) {
        this.tipoDeUso = tipoDeUso;
    }

    public String getVersionSO() {
        return versionSO;
    }

    public void setVersionSO(String versionSO) {
        this.versionSO = versionSO;
    }

    public String getNombreSO() {
        return nombreSO;
    }

    public void setNombreSO(String nombreSO) {
        this.nombreSO = nombreSO;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getValocidadRam() {
        return valocidadRam;
    }

    public void setValocidadRam(int valocidadRam) {
        this.valocidadRam = valocidadRam;
    }

    public String getTipoDiscoDuro() {
        return tipoDiscoDuro;
    }

    public void setTipoDiscoDuro(String tipoDiscoDuro) {
        this.tipoDiscoDuro = tipoDiscoDuro;
    }

    public int getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    public void setCapacidadDiscoDuro(int capacidadDiscoDuro) {
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    public int getDiagonalPantalla() {
        return diagonalPantalla;
    }

    public void setDiagonalPantalla(int diagonalPantalla) {
        this.diagonalPantalla = diagonalPantalla;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public void setResolucionPantalla(String resolucionPantalla) {
        this.resolucionPantalla = resolucionPantalla;
    }

    public String getNombreSoftwarePago() {
        return nombreSoftwarePago;
    }

    public void setNombreSoftwarePago(String nombreSoftwarePago) {
        this.nombreSoftwarePago = nombreSoftwarePago;
    }

    public String getVersionSoftwarePago() {
        return versionSoftwarePago;
    }

    public void setVersionSoftwarePago(String versionSoftwarePago) {
        this.versionSoftwarePago = versionSoftwarePago;
    }

    public String getTipoSoftwarePago() {
        return tipoSoftwarePago;
    }

    public void setTipoSoftwarePago(String tipoSoftwarePago) {
        this.tipoSoftwarePago = tipoSoftwarePago;
    }

    public String getNombreSoftwareLibre() {
        return nombreSoftwareLibre;
    }

    public void setNombreSoftwareLibre(String nombreSoftwareLibre) {
        this.nombreSoftwareLibre = nombreSoftwareLibre;
    }

    public String getVersionSoftwareLibre() {
        return versionSoftwareLibre;
    }

    public void setVersionSoftwareLibre(String versionSoftwareLibre) {
        this.versionSoftwareLibre = versionSoftwareLibre;
    }
}
