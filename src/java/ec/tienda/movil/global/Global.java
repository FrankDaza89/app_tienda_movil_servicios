/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.global;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Pancho
 */
public class Global {

    public static String AMBIENTE_PROYECTO = "";

    /**
     * Inicia las configuraciones iniciales del proyecto
     */
    public static void init() {
        Propiedades propiedades = new Propiedades();
        propiedades.cargarPropiedadesAmbiente();
        propiedades.cargarPropiedades();
        if (Log.configurarLog()) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.INFO, "Logger configurado");
        } else {
            Logger.getLogger(Propiedades.class.getName()).log(Level.ERROR, "Logger: error al configurar");
        }
    }
}
