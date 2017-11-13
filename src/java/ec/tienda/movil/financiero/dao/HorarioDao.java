/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.tienda.movil.financiero.dao;

import ec.tienda.movil.financiero.modelo.Horario;
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
public class HorarioDao {

    public Boolean insertarHorario(Horario horario) throws Exception {
        Boolean bandera = false;
        Transaction transaction = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(horario);
            bandera = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            bandera = false;
            Logger.getLogger(HorarioDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return bandera;
    }

    public boolean actualizarHorario(Horario horario) {
        boolean estado = false;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            session.update(horario);
            estado = true;
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            Logger.getLogger(HorarioDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return estado;
    }

    public Horario obtenerHorarioPorId(Integer idHorario) {
        Horario obj = null;
        Session session = HibernateUtil.getSESION_FINANCIERO().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            Query q = session.createQuery("from Horario where idHorario=:idHorario");
            q.setParameter("idHorario", idHorario);
            obj = (Horario) q.uniqueResult();
        } catch (Exception ex) {
            Logger.getLogger(HorarioDao.class.getSimpleName()).log(Level.ERROR, null, ex);
        } finally {
            session.flush();
            session.close();
        }
        return obj;
    }
}
