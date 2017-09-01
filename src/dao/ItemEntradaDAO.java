package dao;

import dominio.Entrada;
import dominio.ItemEntrada;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import configDB.HibernateUtil;

public class ItemEntradaDAO {
    
    public void inserir(ItemEntrada itementrada){
        
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Insere o objeto na tabela
            sessao.save(itementrada);
            
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
    
    public List<ItemEntrada> listar(){
        
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemEntrada.class);
            
            //Define a ordenação SELECT * FROM ItemEntrada ORDER BY codItem
            consulta.addOrder(Order.asc("codItem"));// precisa ser o no usado no objeto
            
            //agora executa a consulta
            List<ItemEntrada> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
    
   
    
     public ItemEntrada buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemEntrada.class);
            
            //Define uma restrição - SELECT * FROM ItemEntrada WHERE codigo = ?
            consulta.add(Restrictions.eq("codItem", codigo));
            
            //Executa a consulta
            ItemEntrada resultado = (ItemEntrada) consulta.uniqueResult();
            
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
     
     public void excluir(ItemEntrada itementrada){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM ItemEntrada WHERE codigo = ?
            sessao.delete(itementrada);
            
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
     
      public void editar(ItemEntrada itementrada){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE ItemEntrada SET quantidade  = ? WHERE codigo = ?
            sessao.update(itementrada);
            
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

    public List<ItemEntrada> listarPorCodigo(int cod) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemEntrada.class);
            
            consulta.createCriteria("codEntrada").add(Expression.eq("codEntrada", cod));
            consulta.addOrder(Order.asc("codEntrada"));
            
            //agora executa a consulta
            List<ItemEntrada> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
    
    
    
    public void excluirItens(ItemEntrada itementrada){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM ItemEntrada WHERE codigo = ?
            sessao.delete(itementrada);
            
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
}
