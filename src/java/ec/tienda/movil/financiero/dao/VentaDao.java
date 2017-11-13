/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.dao;

import ec.tienda.movil.financiero.modelo.Venta;
import ec.tienda.movil.global.HibernateUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pancho
 */
public class VentaDao {

    public Boolean insertarSalidaPago(Venta venta) throws Exception {
        Boolean bandera = false;
        Transaction transaction = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(venta);
            bandera = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            bandera = false;
            Logger.getLogger(VentaDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return bandera;
    }

    public boolean actualizarSalidaPago(Venta venta) {
        boolean estado = false;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(venta);
            estado = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            Logger.getLogger(VentaDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return estado;
    }

    public Venta obtenerSalidaPagoPorId(Integer idVenta) {
        Venta obj = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Query q = session.createQuery("from Venta where idVenta=:idVenta");
            q.setParameter("idVenta", idVenta);
            obj = (Venta) q.uniqueResult();
        } catch (Exception ex) {
            Logger.getLogger(VentaDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return obj;
    }
}
