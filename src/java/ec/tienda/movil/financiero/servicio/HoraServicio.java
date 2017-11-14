/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.servicio;

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

    /**
     * Inserta un registro en la tabla Hora
     *
     * @param horaEntrega1
     * @param horaEntrega2
     * @param estadoHora
     * @return
     */
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

    /**
     * Consulta todas las horas registradas
     *
     * @return
     */
    @POST
    @Path("/obtenerHoras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerHoras() {

        Response response = null;
        HoraDao dao = new HoraDao();
        List<Hora> horas = null;
        try {
            horas = dao.obtenerHoras();
            GenericEntity< List< Hora>> entity;
            entity = new GenericEntity< List< Hora>>(horas) {
            };
            response = Response.status(200).entity(entity).build();
        } catch (Exception ex) {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            Logger.getLogger(HoraServicio.class.getName()).log(Level.ERROR, null, ex);
        }
        return response;
    }
}
