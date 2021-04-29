package edu.upc.dsa;

import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Vacuna;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {

    //Estructura de datos
    HashMap<String, User> hashUsuarios = new HashMap<String, User>();
    List<Vacuna> vacunadosList = new LinkedList<>(); //Lista de los VACUNADOS
    ArrayList<Vacuna> vacunaArrayList = new ArrayList<>(); //1.Moderna 2.Pfizer
    List<Seguimiento> seguimientoList = new ArrayList<>();


    static final Logger log = Logger.getLogger(Covid19ManagerImpl.class.getName());
    private static Covid19ManagerImpl manager;

    public static Covid19ManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) {
            manager = new Covid19ManagerImpl();
        }
        return manager;
    }

    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        log.info("Instancia ProductManagerImpl borrada");
    }

    public Covid19ManagerImpl() {}

    public void clear(){
        vacunaArrayList.clear();
        vacunadosList.clear();
        seguimientoList.clear();
        hashUsuarios.clear();
    }

    @Override
    public void addVacunaAPersona(String idUser, String marcaVacuna, String fecha) {
        User userTemp = getUserById(idUser); //encuentro el user
        Vacuna objetoTemp = getVacunaByName(marcaVacuna); //Busco la vacuna
        if (userTemp != null) {
            log.info("User Found");
            userTemp.setFecha(fecha);
            userTemp.setVacuna(marcaVacuna);
            objetoTemp.addContadorVacunas();
            vacunadosList.add(objetoTemp);
        }
        else{
            log.error("User NOT Found");
        }
    }



    @Override
    public List<Vacuna> sortVacunasFecha() {
        List<Vacuna> resultado = new LinkedList<>();


        Collections.sort(resultado, new Comparator<Vacuna>() {
            @Override
            public int compare(Vacuna o1, Vacuna o2) {
                return 0;
            }
        });
        log.info("Lista ordenada alfabeticamente: " + resultado.toString());
        return resultado;
    }


    /*
    @Override
    public List<Caso> ordenarCasos(String idBrote) {
        Brote broteSeleccionado = brotes.get(idBrote);
        for (Caso f : broteSeleccionado.getCasosList()) {
            Collections.sort(broteSeleccionado.casosList, new Comparator<Caso>() {
                @Override
                public int compare(Caso o1, Caso o2) {
                    return o1.getClasificacion().compareTo(o2.getClasificacion());
                }
            });
            Collections.sort(broteSeleccionado.casosList, new Comparator<Caso>() {
                @Override
                public int compare(Caso o1, Caso o2) {

                    return o1.getFechaInforme().compareTo(o2.getFechaInforme());
                }

            });
        }
        return broteSeleccionado.casosList;
    }

     */

    @Override
    public List<Vacuna> sortDescVacunasAplicadas() {
        return null;
    }

    @Override
    public void addSeguimiento(String idUser, String fecha, String descripcion) {
        User user = getUserById(idUser);
        user.seguimientoList.add(dameSeguimiento(fecha,descripcion));
    }


    @Override
    public List<Seguimiento> getSeguimientos(String id) {
        User user = getUserById(id);
        List<Seguimiento> list = user.seguimientoList;
        return list;
    }





//Auxiliares
    public User getUserById(String idUser){
        User userTemp = this.hashUsuarios.get(idUser);
        return userTemp;
    }
    public Vacuna getVacunaByName(String marcaVacuna) {
        Vacuna vacunaTemp = null;
        for (Vacuna vacuna: this.vacunaArrayList){
            if (vacuna.getMarca().compareTo(marcaVacuna)==0) {
                vacunaTemp = vacuna;
            }
        }
        return vacunaTemp;
    }

    public Seguimiento dameSeguimiento(String fecha, String descripcion){
        Seguimiento seguimiento = new Seguimiento(fecha,descripcion);
        return seguimiento;
    }

    public int usuariosSize(){
        return this.hashUsuarios.size();
    }

    public void addVacunaALista(Vacuna vacuna){
        vacunaArrayList.add(vacuna);
    }

    public void addUser(String nombre, String vacuna, String fecha) {
        User userTemp = new User(nombre, vacuna, fecha);
        hashUsuarios.put(nombre,userTemp);
    }

    public void getDescripcionByUser(String nombre) {
        User usuario = getUserById(nombre);
        List<Seguimiento> seguimientos = usuario.getSeguimientoList();
        int i = 0;
        for (Seguimiento p : seguimientos) {
            log.info("Fecha: " + p.getFecha() + ", Descripcion: " + p.getDescripcion());
        }
    }

    public List<User> findAll(){
        if (hashUsuarios.size() != 0){
            List<User> list = new LinkedList<>(hashUsuarios.values());
            return list;
        }
        return null;
    }
}
