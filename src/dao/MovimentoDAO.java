
package dao;

import dominio.Movimento;
import dominio.TipoMovimento;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import configDB.HibernateUtil;

public class MovimentoDAO {
    
    public void inserir(Movimento Movimento){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try {
            
            transacao = sessao.beginTransaction();
            
            sessao.save(Movimento);
            
            transacao.commit();
            
        } catch (Exception e) {
            
            if(transacao != null)
                transacao.rollback();
        }
    }
    
     public List<Movimento> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Movimento.class);
            
            consulta.addOrder(Order.asc("tipoMov"));
            
            List<Movimento> resultado = consulta.list();
            
            return resultado;
    
        }catch(RuntimeException erro){
            throw erro;
        } finally{
            sessao.close();
        }
    }
      
      public Movimento buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
        
            Criteria consulta = sessao.createCriteria(Movimento.class);
            
            
            consulta.add(Restrictions.eq("codMovimento", codigo));
            
           
            Movimento resultado = (Movimento) consulta.uniqueResult();
            
            
            return resultado;
            
        } catch(RuntimeException erro) {
            
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
      
       public void excluir(Movimento Movimento){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
    
            transacao = sessao.beginTransaction();
            sessao.delete(Movimento);
            transacao.commit();
            
        }catch(RuntimeException erro){
            if(transacao != null){
                transacao.rollback();
            }

            throw erro;
        }finally {
        sessao.close();
        }
    }
       
        public void editar(Movimento Movimento){

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();

            sessao.update(Movimento);
            
            transacao.commit();
            
        }catch(RuntimeException erro){

            if(transacao != null){

                transacao.rollback();
            }

            throw erro;
        }finally {
        sessao.close();
        }
    }
        
        public List<Movimento> buscar(String palavra) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(TipoMovimento.class);
            consulta.add(Restrictions.like("tipoMovimento","%"+palavra+"%"));
            List<Movimento> listaTipoMovimento = consulta.list();
            return listaTipoMovimento;
            
        } catch (RuntimeException e) {
            throw e;
        }
        
    }

    public List<Movimento> listarRelatorio(Date dataInicio, Date dataFim) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Criando a consulta SELECT * FROM ItemEntrada
            Criteria consulta = sessao.createCriteria(Movimento.class);
            
            consulta.add(Restrictions.between("dataExecucao", dataInicio, dataFim));
            consulta.addOrder(Order.asc("codMovimento"));
            //agora executa a consulta
            List<Movimento> resultado = consulta.list();
            
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
