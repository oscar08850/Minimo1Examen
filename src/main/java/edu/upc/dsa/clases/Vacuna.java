package edu.upc.dsa.clases;

import java.util.List;

public class Vacuna {

    public String marca;
    public int vacunasAplicadas = 0;

    public List<User> vacunadosList = null;

    public Vacuna(String marca) {
        this.marca = marca;
    }

    public Vacuna(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVacunasAplicadas() {
        return vacunasAplicadas;
    }

    public void setVacunasAplicadas(int vacunasAplicadas) {
        this.vacunasAplicadas = vacunasAplicadas;
    }

    public List<User> getVacunadosList() {
        return vacunadosList;
    }

    public void setVacunadosList(List<User> vacunadosList) {
        this.vacunadosList = vacunadosList;
    }

    public void addContadorVacunas(){
        this.vacunasAplicadas++;
    }
}
