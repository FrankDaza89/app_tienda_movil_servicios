/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.servicio;

import com.sun.jersey.api.client.ClientResponse;
import ec.tienda.movil.financiero.dao.HoraDao;
import ec.tienda.movil.financiero.modelo.Hora;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author ANFP-08
 */
@Path("HoraServicio")
public class HoraServicio {

    @POST
    @Path("/insertarHora/{horaEntrega1}&{horaEntrega2}&{estadoHora}")
    @Produces(MediaType.TEXT_PLAIN)
    public String insertarHora(@PathParam("horaEntrega1") String horaEntrega1,
            @PathParam("horaEntrega2") String horaEntrega2, @PathParam("estadoHora") String estadoHora) {

        boolean respuesta = false;
        HoraDao dao = new HoraDao();
        Hora hora = new Hora();
        hora.setHoraEntrega1(horaEntrega1);
        hora.setHoraEntrega2(horaEntrega2);
        hora.setEstadoHora(estadoHora);
        try {
            respuesta = dao.insertarHora(hora);
        } catch (Exception ex) {
            Logger.getLogger(HoraServicio.class.getSimpleName()).log(Level.ERROR, null, ex);
        }
        return String.valueOf(respuesta);
    }

    @POST
    @Path("/obtenerHoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerHoras() {

        HoraDao dao = new HoraDao();
        List<Hora> horas = null;
        try {
            horas = dao.obtenerHoras();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HoraServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        GenericEntity< List< Hora>> entity;
        entity = new GenericEntity< List< Hora>>(horas) {
        };
        return Response.status(200).entity(entity).build();
    }
}
