/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.copa.dao;

import br.copa.model.Estadio;
import br.copa.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author George
 */
public class EstadioDAO {
    
    private Session session;

    

    public void salvar(Estadio estadio_) {
        try{
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(estadio_);
        session.getTransaction().commit();
        }catch(HibernateException e){
           System.out.println("Erro ao gravar"+e.getMessage());
        }
    }
    
    public void update (Estadio estadio_){
       try{
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(estadio_);
        session.getTransaction().commit();
        }catch(HibernateException e){
           System.out.println("Erro ao atualizar "+e.getMessage());
        }
    }

    public List<Estadio> getEstadios() {
        List<Estadio> estadioList = new ArrayList<Estadio>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            estadioList = session.createQuery("from Estadio").list();
            return estadioList;
        } finally {
            session.close();
        }
    }

    public Estadio getEstadio(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Estadio estadio = (Estadio) session.createQuery(
                    "from Estadio e "
                    + "where e.id=:id").setParameter("id", id).uniqueResult();
            return estadio;
        } finally {
            session.close();
        }
    }


    
}
