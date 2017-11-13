/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.dao;

import ec.tienda.movil.financiero.modelo.FormaPago;
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
public class FormaPagoDao {

    public Boolean insertarFormaPago(FormaPago formaPago) throws Exception {
        Boolean bandera = false;
        Transaction transaction = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(formaPago);
            bandera = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            bandera = false;
            Logger.getLogger(FormaPagoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return bandera;
    }

    public boolean actualizarFormaPago(FormaPago formaPago) {
        boolean estado = false;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(formaPago);
            estado = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            Logger.getLogger(FormaPagoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return estado;
    }

    public FormaPago obtenerEfectivoPorId(Integer idFormaPago) {
        FormaPago obj = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Query q = session.createQuery("from FormaPago where idFormaPago=:idFormaPago");
            q.setParameter("idFormaPago", idFormaPago);
            obj = (FormaPago) q.uniqueResult();
        } catch (Exception ex) {
            Logger.getLogger(FormaPagoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return obj;
    }
}
