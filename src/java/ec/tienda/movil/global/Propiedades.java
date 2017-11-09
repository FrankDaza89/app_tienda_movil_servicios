/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Pancho
 */
public class Propiedades {

    public static String ARCHIVO_PROPIEDADES_AMBIENTE = "ambiente.properties";
    private String ambiente;

    /**
     * Carga propiedades del archivo ambiente.properties
     *
     * @return
     */
    public boolean cargarPropiedadesAmbiente() {
        boolean success = false;
        InputStream ambientePropiedades = null;
        try {
            ambientePropiedades = getClass().getClassLoader().getResourceAsStream(ARCHIVO_PROPIEDADES_AMBIENTE);
            Properties propertiesAmbiente = new Properties();
            if (ambientePropiedades != null) {
                propertiesAmbiente.load(ambientePropiedades);
                setAmbiente(limpiar(propertiesAmbiente.getProperty("ambiente")));
                Global.AMBIENTE_PROYECTO = ambiente;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.ERROR, null, ex);
        } finally {
            try {
                ambientePropiedades.close();
            } catch (IOException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return success;
    }

    /**
     * Carga propiedades del archivo facturacion.*.properties, aqui se hace la
     * lectura de las propiedades del proyecto
     *
     * @return
     */
    public boolean cargarPropiedades() {
        boolean success = false;
        InputStream proyectoPropiedades = null;
        try {
            proyectoPropiedades = getClass().getClassLoader().getResourceAsStream("rde." + ambiente + ".properties");
            Properties properties = new Properties();
            if (proyectoPropiedades != null) {
                properties.load(proyectoPropiedades);
                //Aqui lectura de propiedades 
                Log.LOG_RUTA = limpiar(properties.getProperty("log_ruta"));
                Log.LOG_NOMBRE = limpiar(properties.getProperty("log_nombre"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.ERROR, null, ex);
        } finally {
            try {
                proyectoPropiedades.close();
            } catch (IOException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return success;
    }

    private String limpiar(String propiedad) {
        return propiedad.trim();
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
}
