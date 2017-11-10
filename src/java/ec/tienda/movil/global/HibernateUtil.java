/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.global;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ANFP-08
 */
public class HibernateUtil {

    private static final SessionFactory SESION_USUARIO;
    private static final SessionFactory SESION_FINANCIERO;
    private static final SessionFactory SESION_ALMACEN;

    static {
        Configuration configUsuario = new Configuration();
        configUsuario.configure("hibernate.usuario." + Global.AMBIENTE_PROYECTO + ".cfg.xml");
        ServiceRegistry srUsuario = new StandardServiceRegistryBuilder().applySettings(configUsuario.getProperties()).build();
        SESION_USUARIO = configUsuario.buildSessionFactory(srUsuario);

        Configuration configFinanciero = new Configuration();
        configFinanciero.configure("hibernate.financiero." + Global.AMBIENTE_PROYECTO + ".cfg.xml");
        ServiceRegistry srFinanciero = new StandardServiceRegistryBuilder().applySettings(configFinanciero.getProperties()).build();
        SESION_FINANCIERO = configFinanciero.buildSessionFactory(srFinanciero);

        Configuration configAlmacen = new Configuration();
        configAlmacen.configure("hibernate.almacen." + Global.AMBIENTE_PROYECTO + ".cfg.xml");
        ServiceRegistry srAlmacen = new StandardServiceRegistryBuilder().applySettings(configAlmacen.getProperties()).build();
        SESION_ALMACEN = configAlmacen.buildSessionFactory(srAlmacen);
    }

    public static SessionFactory getSESION_USUARIO() {
        return SESION_USUARIO;
    }

    public static SessionFactory getSESION_FINANCIERO() {
        return SESION_FINANCIERO;
    }

    public static SessionFactory getSESION_ALMACEN() {
        return SESION_ALMACEN;
    }
}
