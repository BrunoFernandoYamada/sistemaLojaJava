package dao;

import dominio.ItemProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import configDB.HibernateUtil;

public class ItemProdutoDAO {
    
    public void inserir(ItemProduto itemproduto){
        
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Insere o objeto na tabela
            sessao.save(itemproduto);
            
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
    
    public List<ItemProduto> listar(){
        
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemProduto.class);
            
            //Define a ordenação SELECT * FROM ItemEntrada ORDER BY codItem
            consulta.addOrder(Order.asc("codItem"));// precisa ser o no usado no objeto
            
            //agora executa a consulta
            List<ItemProduto> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
    
     public ItemProduto buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemProduto.class);
            
            //Define uma restrição - SELECT * FROM ItemEntrada WHERE codigo = ?
            consulta.add(Restrictions.eq("codProduto", codigo));
            
            //Executa a consulta
            ItemProduto resultado = (ItemProduto) consulta.uniqueResult();
            
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
     
     public void excluir(ItemProduto itemproduto){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM ItemEntrada WHERE codigo = ?
            sessao.delete(itemproduto);
            
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
     
      public void editar(ItemProduto itemproduto){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE ItemEntrada SET quantidade  = ? WHERE codigo = ?
            sessao.update(itemproduto);
            
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

    public List<ItemProduto> listarPorCodigo(int codVenda) {
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(ItemProduto.class);
            
            //Define a ordenação SELECT * FROM ItemEntrada ORDER BY codItem
            consulta.createCriteria("codVenda").add(Expression.eq("codVenda", codVenda));// precisa ser o no usado no objeto
            consulta.addOrder(Order.asc("codVenda"));
            //agora executa a consulta
            List<ItemProduto> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
}