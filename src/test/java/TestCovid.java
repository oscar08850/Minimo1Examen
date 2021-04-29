import edu.upc.dsa.clases.Vacuna;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCovid {


    private static Logger logger = Logger.getLogger(TestCovid.class);
    Covid19Manager pm = Covid19ManagerImpl.getInstance();

    @Before
    public void SetUp() {


        //
        Vacuna vacuna1 = new Vacuna("Astrazeneca");
        Vacuna vacuna2 = new Vacuna("Moderna");
        Vacuna vacuna3 = new Vacuna("Pfizer");

        //Metemos objetos en la lista
        pm.addVacunaALista(vacuna1);
        pm.addVacunaALista(vacuna2);
        pm.addVacunaALista(vacuna3);

        //Creamos los usuarios (addUser)
        //Añadimos los usuarios al HashMap
        pm.addUser("Oscar",null, null);
        pm.addUser("Alex",null, null);
        pm.addUser("Toni",null, null);

        pm.addVacunaAPersona("Oscar","Astrazeneca","1");
        pm.addVacunaAPersona("Alex","Pfizer","2");
    }


    //Aplica vacuna a un Usuario
    @Test
    public void test1(){
        User user = pm.getUserById ("Toni");
        logger.info("Usuario antes de la vacuna: Nombre" + user.getNombre() + ", Vacuna: " +user.getVacuna()+ ", Fecha: " + user.getFecha());
        logger.info("Aplicamos vacuna");
        pm.addVacunaAPersona("Toni","Astrazeneca","3");
        logger.info("Usuario Despues de la vacuna: Nombre" + user.getNombre() + ", Vacuna: " +user.getVacuna()+ ", Fecha: " + user.getFecha());

    }

    //Añadir un seguimiento a un usuario
    @Test
    public void test2(){
        User user = pm.getUserById ("Oscar");
        logger.info("seguimento list" + user.seguimientoList );
        pm.addSeguimiento("Oscar","1","Hoy estoy mal");
        pm.addSeguimiento("Oscar","2","Hoy estoy mejor");
        pm.addSeguimiento("Oscar","3","Hoy estoy bien");
        pm.addSeguimiento("Oscar","4","Hoy estoy perfecto");
        logger.info("Descripcion usuario: " + user.getNombre());
        pm.getDescripcionByUser("Oscar");
        }


    @After
    public void tearDown(){
        pm.clear();
    }
}
