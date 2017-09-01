/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.TipoMovimento;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;

/**
 *
 * @author Bruno
 */
public class TipoMovimentoDAO {
    
     public void inserir(TipoMovimento tipoMovimento){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try {
            
            transacao = sessao.beginTransaction();
            
            sessao.save(tipoMovimento);
            
            transacao.commit();
            
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Tipo de Movimento já cadastrado!");
            if(transacao != null){
                transacao.rollback();
            }
            throw consErro;
        
            
        } catch (Exception e) {
            
            if(transacao != null)
                transacao.rollback();
        }
    }
     
      public List<TipoMovimento> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(TipoMovimento.class);
            
            consulta.addOrder(Order.asc("tipoMov"));
            
            List<TipoMovimento> resultado = consulta.list();
            
            return resultado;
    
        }catch(RuntimeException erro){
            throw erro;
        } finally{
            sessao.close();
        }
    }
      
      public TipoMovimento buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
        
            Criteria consulta = sessao.createCriteria(TipoMovimento.class);
            
            
            consulta.add(Restrictions.eq("codMov", codigo));
            
           
            TipoMovimento resultado = (TipoMovimento) consulta.uniqueResult();
            
            
            return resultado;
            
        } catch(RuntimeException erro) {
            
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
      
       public void excluir(TipoMovimento tipoMovimento){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
    
            transacao = sessao.beginTransaction();
            sessao.delete(tipoMovimento);
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
       
        public void editar(TipoMovimento tipoMovimento){

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();

            sessao.update(tipoMovimento);
            
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
        
        public List<TipoMovimento> buscar(String palavra) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Criteria consulta = sessao.createCriteria(TipoMovimento.class);
            consulta.add(Restrictions.like("razaoSocial","%"+palavra+"%"));
            List<TipoMovimento> listaTipoMovimento = consulta.list();
            return listaTipoMovimento;
            
        } catch (RuntimeException e) {
            throw e;
        }
        
    }
}

