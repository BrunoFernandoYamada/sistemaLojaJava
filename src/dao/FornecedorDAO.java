
package dao;

import dominio.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;

public class FornecedorDAO {
   
    public void inserir(Fornecedor fornecedor){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.save(fornecedor);
            
            transacao.commit();
            
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!");
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
    
    public List<Fornecedor> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Fornecedor.class);
            
            consulta.addOrder(Order.asc("razaoSocial"));
            
            List<Fornecedor> resultado = consulta.list();
            
            return resultado;
    
        }catch(RuntimeException erro){
            throw erro;
        } finally{
            sessao.close();
        }
    }
    
    public Fornecedor buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Fornecedor
            Criteria consulta = sessao.createCriteria(Fornecedor.class);
            
            //Define uma restrição - SELECT * FROM Fornecedor WHERE codigo = ?
            consulta.add(Restrictions.eq("codFornecedor", codigo));
            
            //Executa a consulta
            Fornecedor resultado = (Fornecedor) consulta.uniqueResult();
            
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
     
     public void excluir(Fornecedor fornecedor){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Fornecedor WHERE codigo = ?
            sessao.delete(fornecedor);
            
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
     
      public void editar(Fornecedor fornecedor){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Fornecedor SET cnpj  = ? WHERE codigo = ?
            sessao.update(fornecedor);
            
            //encerra a transação
            transacao.commit();
            
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado!");
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

    public List<Fornecedor> buscar(String palavra) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(Fornecedor.class);
            consulta.add(Restrictions.like("razaoSocial","%"+palavra+"%"));
            List<Fornecedor> listaFornecedor = consulta.list();
            return listaFornecedor;
            
        } catch (RuntimeException e) {
            throw e;
        }
        
    }
    
    public Fornecedor buscarPorRazao(String palavra) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(Fornecedor.class);
            consulta.add(Restrictions.like("razaoSocial","%"+palavra+"%"));
            Fornecedor fornecedor = (Fornecedor) consulta.uniqueResult();
            return fornecedor;
            
        } catch (RuntimeException e) {
            throw e;
        }
        
    }
}
