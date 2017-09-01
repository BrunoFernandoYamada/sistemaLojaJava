package dao;

import dominio.Venda;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import configDB.HibernateUtil;

public class VendaDAO {
    
    public void inserir(Venda venda){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Insere o objeto na tabela
            sessao.save(venda);
            
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
    
    public List<Venda> listar(){
        
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM Produto
            Criteria consulta = sessao.createCriteria(Venda.class);
            
            //Define a ordenação SELECT * FROM Venda ORDER BY codVenda
            consulta.addOrder(Order.asc("codVenda"));// precisa ser o no usado no objeto
            
            //agora executa a consulta
            List<Venda> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
    
     public Venda buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Venda
            Criteria consulta = sessao.createCriteria(Venda.class);
            
            //Define uma restrição - SELECT * FROM Venda WHERE codigo = ?
            consulta.add(Restrictions.eq("codVenda", codigo));
            
            //Executa a consulta
            Venda resultado = (Venda) consulta.uniqueResult();
            
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
     
     public void excluir(Venda venda){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Venda WHERE codigo = ?
            sessao.delete(venda);
            
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
     
      public void editar(Venda venda){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Venda SET descricao  = ? WHERE codigo = ?
            sessao.update(venda);
            
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

    public List<Venda> listarRelatorio(Date dataInicio, Date dataFim) {
        
         Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(Venda.class);
            
            consulta.add(Restrictions.between("dataVenda", dataInicio, dataFim));
            //agora executa a consulta
            List<Venda> resultado = consulta.list();
            
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
