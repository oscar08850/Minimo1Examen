package edu.upc.dsa.clases;

public class Seguimiento {
    public String fecha;
    public String descripcion;


    public Seguimiento(String fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Seguimiento(){}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
