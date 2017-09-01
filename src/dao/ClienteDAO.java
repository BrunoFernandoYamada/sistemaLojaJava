
package dao;

import dominio.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;

public class ClienteDAO {
    
    public void inserir(Cliente cliente){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.save(cliente);
            
            transacao.commit();
            
            }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
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
    
    public List<Cliente> Listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Cliente.class);
            
            consulta.addOrder(Order.asc("nome"));
            
            List<Cliente> resultado = consulta.list();
            
            return resultado;
            
        }catch(RuntimeException erro){
            
            throw erro;
            
        } finally{
            sessao.close();
        }
        
    }
    
    public Cliente buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Cliente
            Criteria consulta = sessao.createCriteria(Cliente.class);
            
            //Define uma restrição - SELECT * FROM Cliente WHERE codigo = ?
            consulta.add(Restrictions.eq("codCliente", codigo));
            
            //Executa a consulta
            Cliente resultado = (Cliente) consulta.uniqueResult();
            
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
     
     public void excluir(Cliente cliente){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Produto WHERE codigo = ?
            sessao.delete(cliente);
            
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
     
      public void editar(Cliente cliente){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Produto SET descricao  = ? WHERE codigo = ?
            sessao.update(cliente);
            
            //encerra a transação
            transacao.commit();
            
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
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

    public List<Cliente> buscar(String palavra) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(Cliente.class);
            consulta.add(Restrictions.like("nome", "%"+palavra+"%"));
            List<Cliente> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
     public Cliente buscarCPF(String cpf){
            
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            
            try {
                Criteria consulta = sessao.createCriteria(Cliente.class);
                consulta.add(Restrictions.eq("cpfCnpj", cpf));
                Cliente resultado = (Cliente) consulta.uniqueResult();
                return resultado;
            } catch (Exception e) {
                throw e;
            }
    }
}