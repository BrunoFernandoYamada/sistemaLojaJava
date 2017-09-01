package dao;

import dominio.Entrada;
import dominio.ItemEntrada;
import dominio.Produto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransientObjectException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;

public class EntradaDAO {
    
    public void inserir(Entrada entrada){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.save(entrada);
            
            transacao.commit();
        
        }catch(PropertyValueException e){
            
        }
        catch(ConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "Não é possível incluir esta entrada");
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
            
        }catch(RuntimeException erro){
            
            if(transacao != null){
                transacao.rollback();
            }
            
            throw erro;
        }finally{
            sessao.close();
        }  
    }
    
    public List<Entrada> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Entrada.class);
            
            consulta.addOrder(Order.asc("codEntrada"));
            
            List<Entrada> resultado = consulta.list();
            
            return resultado;
    
        }catch(RuntimeException erro){
            throw erro;
        } finally{
            sessao.close();
        }
    }
    
     public List<Entrada> listarRelatorio(Date dtInicio, Date dtFim ){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(Entrada.class);
            
            consulta.add(Restrictions.between("dataEntrada", dtInicio, dtFim));
            //agora executa a consulta
            List<Entrada> resultado = consulta.list();
            
            //retorna o resultado
            return resultado;
            
        }catch(RuntimeException erro){
         
            throw erro;
        }finally {
            //Fecha a sessão
        sessao.close();
        }
    }
    
    public Entrada buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Entrada
            Criteria consulta = sessao.createCriteria(Entrada.class);
            
            //Define uma restrição - SELECT * FROM Entrada WHERE codigo = ?
            consulta.add(Restrictions.eq("codEntrada", codigo));
            
            //Executa a consulta
            Entrada resultado = (Entrada) consulta.uniqueResult();
            
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
     
     public void excluir(Entrada entrada){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Entrada WHERE codigo = ?
            sessao.delete(entrada);
            
            //encerra a transação
            transacao.commit();
            
        }catch(ConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "Não é possível excluir esta entrada");
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
            
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
     
      public void editar(Entrada entrada){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Entrada SET dataEntrada  = ? WHERE codigo = ?
            sessao.update(entrada);
            
            //encerra a transação
            transacao.commit();
            
        } catch(ConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "Não é possível excluir esta entrada pois há itens que dependem dela", "Atenção", 2);
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
            
        }catch(TransientObjectException e){
            JOptionPane.showMessageDialog(null, "Nenhum campo foi editado para alterar esta entrada", "Atenção", 2);
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
        }
        catch(RuntimeException erro){
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
    
      public void editarProduto(Produto produto) {
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        //declara um objeto que irá controlar a transação
        Transaction transacao = null;

        try {
            //inicia a transação
            transacao = sessao.beginTransaction();

            //Remove o objeto na tabela - UPDATE Produto SET descricao  = ? WHERE codigo = ?
            sessao.update(produto);

            //encerra a transação
            transacao.commit();

        } catch (RuntimeException erro) {
            //verifica se a transação foi iniciada
            if (transacao != null) {
                //cancela a transação
                transacao.rollback();
            }
            //repropago a transação
            throw erro;
        } finally {
            sessao.close();
        }
    }
      
      public ItemEntrada buscarEntrada(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Entrada
            Criteria consulta = sessao.createCriteria(ItemEntrada.class);
            
            //Define uma restrição - SELECT * FROM Entrada WHERE codigo = ?
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

    public Entrada buscaPorNota(String notafiscal) {
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Entrada
            Criteria consulta = sessao.createCriteria(Entrada.class);
            
            //Define uma restrição - SELECT * FROM Entrada WHERE codigo = ?
            consulta.add(Restrictions.eq("notafiscal", notafiscal));
            
            //Executa a consulta
            Entrada resultado = (Entrada) consulta.uniqueResult();
            
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
}
