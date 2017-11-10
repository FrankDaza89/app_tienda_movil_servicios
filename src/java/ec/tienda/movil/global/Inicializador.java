/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.global;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author ANFP-08
 */
public class Inicializador implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Logger.getLogger(Propiedades.class.getName()).log(Level.INFO, "El contexto ha sido destruido");
    }

    //este metodo se ejecuta cuando se inicia la aplicacion o bien el contexto.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Global.init();
        Logger.getLogger(Propiedades.class.getName()).log(Level.INFO, "Contexto inicializado");
    }

}
