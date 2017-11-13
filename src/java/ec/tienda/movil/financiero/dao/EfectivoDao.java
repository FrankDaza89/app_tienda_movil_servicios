/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.dao;

import ec.tienda.movil.financiero.modelo.Efectivo;
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
public class EfectivoDao {

    public Boolean insertarEfectivo(Efectivo efectivo) throws Exception {
        Boolean bandera = false;
        Transaction transaction = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(efectivo);
            bandera = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            bandera = false;
            Logger.getLogger(EfectivoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return bandera;
    }

    public boolean actualizarEfectivo(Efectivo efectivo) {
        boolean estado = false;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(efectivo);
            estado = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            Logger.getLogger(EfectivoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return estado;
    }

    public Efectivo obtenerEfectivoPorId(Integer idEfectivo) {
        Efectivo obj = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Query q = session.createQuery("from Efectivo where idEfectivo=:idEfectivo");
            q.setParameter("idDineroElectronico", idEfectivo);
            obj = (Efectivo) q.uniqueResult();
        } catch (Exception ex) {
            Logger.getLogger(EfectivoDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return obj;
    }
}
