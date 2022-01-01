package co.com.sofka.biblioteca.dtos;

import co.com.sofka.biblioteca.helpers.AreaTematica;
import co.com.sofka.biblioteca.helpers.Tipo;

import java.util.Date;

public class RecursoDTO {

    private String id;
    private String nombre;
    private Boolean disponible;
    private Date fechaPrestamo;
    private Tipo tipo;
    private AreaTematica areaTematica;

    public RecursoDTO() {
    }

    public RecursoDTO(String nombre, Tipo tipo, AreaTematica areaTematica) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaTematica = areaTematica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }
}
