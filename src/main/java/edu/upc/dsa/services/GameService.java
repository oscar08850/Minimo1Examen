package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;

import edu.upc.dsa.clases.Seguimiento;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.clases.Vacuna;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Api(value = "/Covid", description = "Endpoint to Text Service")
@Path("/users")
public class GameService {

    private Covid19Manager pm;
    private boolean inicio = true;

    public GameService() {
        this.pm = Covid19ManagerImpl.getInstance();

        if (this.pm.usuariosSize()==0 && inicio) {
            //
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
        inicio = false;
        }
    }






}
