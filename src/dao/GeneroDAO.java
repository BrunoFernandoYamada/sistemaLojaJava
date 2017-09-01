
package dao;

import dominio.Genero;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;


public class GeneroDAO {
    
    public void inserir(Genero genero){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.save(genero);
            
            transacao.commit();
            
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Genero já cadastrado!");
            if(transacao != null){
                transacao.rollback();
            }
            throw consErro;
        
            
        }catch(RuntimeException erro){
            
            if(transacao != null){
                transacao.rollback();
            }
            
            throw erro;
            
        }finally{
            sessao.close();
        }
    }
    
    public List<Genero> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Genero.class);
            consulta.addOrder(Order.asc("nome"));
            
            List<Genero> resultado = consulta.list();
            
            return resultado;
            
        }catch(RuntimeException erro){
            
            throw erro;
        }finally{
            sessao.close();
        }
    }
    
    public List<Genero> listar(String nome){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Genero
            Criteria consulta = sessao.createCriteria(Genero.class);
            
            //Define uma restrição - SELECT * FROM Genero WHERE codigo = ?
            consulta.add(Restrictions.like("nome", "%"+nome+"%")).addOrder(Order.asc("codGenero"));
            
            
            //Executa a consulta
            List<Genero> resultado = consulta.list();
            
            //Retorna o resultado
            return resultado;
            
        } catch(RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
    
    
    public Genero buscar(Integer codGenero){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Genero
            Criteria consulta = sessao.createCriteria(Genero.class);
            
            //Define uma restrição - SELECT * FROM Genero WHERE codigo = ?
            consulta.add(Restrictions.eq("codGenero", codGenero));
            
            //Executa a consulta
            Genero resultado = (Genero) consulta.uniqueResult();
            
            //Retorna o resultado
            return resultado;
            
        } catch(RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
   
    public Genero buscar(String nome){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Genero
            Criteria consulta = sessao.createCriteria(Genero.class);
            
            //Define uma restrição - SELECT * FROM Genero WHERE codigo = ?
            consulta.add(Restrictions.eq("nome", nome));
            
            //Executa a consulta
            Genero resultado = (Genero) consulta.uniqueResult();
            
            //Retorna o resultado
            return resultado;
            
        } catch(RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
    
     public void excluir(Genero genero){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Genero WHERE codigo = ?
            sessao.delete(genero);
            
            //encerra a transação
            transacao.commit();
            
        }catch(RuntimeException erro){
            //verifica se a transação foi iniciada
            if(transacao != null){
                //cancela a transação
                transacao.rollback();
            }
            //repropago a transação
            throw erro;
        }finally {
        sessao.close();
        }
    }
     
      public void editar(Genero genero){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Genero SET descricao  = ? WHERE codigo = ?
            sessao.update(genero);
            
            //encerra a transação
            transacao.commit();
            
         }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Genero já cadastrado!");
            if(transacao != null){
                transacao.rollback();
            }
            throw consErro;
            
        }catch(RuntimeException erro){
            //verifica se a transação foi iniciada
            if(transacao != null){
                //cancela a transação
                transacao.rollback();
            }
            //repropago a transação
            throw erro;
        }finally {
        sessao.close();
        }
    }
}
