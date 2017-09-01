
package util;

import configDB.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateUtilTeste {
    @Test
    public void conectar(){
        
        SessionFactory fabrica = HibernateUtil.getSessionFactory();
        
        Session sessao = fabrica.openSession();

        sessao.close();
        
        fabrica.close();
    }
}
