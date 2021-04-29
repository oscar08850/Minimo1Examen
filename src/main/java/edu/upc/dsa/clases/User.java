package edu.upc.dsa.clases;

import edu.upc.dsa.Covid19ManagerImpl;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String nombre;
    private String vacuna = null;
    private String fecha = null;

    public List<Seguimiento> seguimientoList = new LinkedList<>();


    static final Logger log = Logger.getLogger(Covid19ManagerImpl.class.getName());

    public User(String nombre, String vacuna, String fecha) {
        this.nombre = nombre;
        this.vacuna = vacuna;
        this.fecha = fecha;
    }

    public User(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }
}