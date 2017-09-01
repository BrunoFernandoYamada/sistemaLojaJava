/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configDB;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    
   static{
       try{
           sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
       }catch(Throwable ex){
           JOptionPane.showMessageDialog(null, "Não foi possível conectar com o Banco de Dados");
           System.err.println("Initial SessionFactory creation failed. " + ex);
           throw new ExceptionInInitializerError(ex);
       }
   }
   
   public static SessionFactory getSessionFactory() {
        return sessionFactory;
   }
}
