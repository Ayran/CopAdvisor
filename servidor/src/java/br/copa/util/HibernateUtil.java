/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.copa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
            try {
                    // Cria o SessionFactory a partir da configuracao existente no
                    //hibernate.cfg.xml
                    sessionFactory =
                            new AnnotationConfiguration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                    // Make sure you log the exception, as it might be swallowed
                    System.err.println("Erro ao criar o SessionFactory." + ex);
                    throw new ExceptionInInitializerError(ex);
            }
    }

    //qualquer pessoa que queira uma nova conexao chama getSessionFactory
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
