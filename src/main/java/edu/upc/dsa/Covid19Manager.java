package edu.upc.dsa;

import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Vacuna;

import java.util.List;

public interface Covid19Manager {
    //Aplicar una vacuna a una persona
    public void addVacunaAPersona( String idUser, String marcaVacuna, String fecha);

    //Listar las vacunaciones ordenadas por vacunas y dentro de las vacunas por
    //orden de vacunación
    public List<Vacuna> sortVacunasFecha();

    //Listado de marcas de vacunas ordenado descendentemente por el número de
    //vacunas aplicadas.
    public List<Vacuna> sortDescVacunasAplicadas();

    //Añadir un seguimiento sobre un usuario que se haya vacunado, indicando la
    //fecha del seguimiento y una descripción del estado de esa persona.
    public void addSeguimiento(String idUser, String fecha, String descripcion);

    //Listado de seguimientos realizados a una persona.
    public List<Seguimiento> getSeguimientos(String id);


///AUXILIARES
    public int usuariosSize();
    public void addVacunaALista(Vacuna vacuna);
    public void clear();
    public void addUser(String nombre, String vacuna, String fecha);
    public User getUserById(String idUser);
    public void getDescripcionByUser(String nombre);
    public Vacuna getVacunaByName(String marcaVacuna);
    public List<User> findAll();









    }
