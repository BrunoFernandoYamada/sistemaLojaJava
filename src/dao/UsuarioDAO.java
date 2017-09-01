
package dao;

import dominio.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.MatchMode.EXACT;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.type.StringType;
import configDB.HibernateUtil;

public class UsuarioDAO {

    
    
    public void inserir(Usuario usuario){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            sessao.save(usuario);
            transacao.commit();
        
        }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
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
    
    public List<Usuario> listar(){
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            
            Criteria consulta = sessao.createCriteria(Usuario.class);
            consulta.addOrder(Order.asc("nome"));
            List<Usuario> resultado = consulta.list();
            return resultado;
            
        }catch(RuntimeException erro){
            throw erro;
        }finally{
            sessao.close();
        }
    }
    
    public Usuario buscar(Integer codigo){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Usuario
            Criteria consulta = sessao.createCriteria(Usuario.class);
            
            //Define uma restrição - SELECT * FROM Usuario WHERE codigo = ?
            consulta.add(Restrictions.eq("codUsuario", codigo));
            
            //Executa a consulta
            Usuario resultado = (Usuario) consulta.uniqueResult();
            
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
     
     public void excluir(Usuario usuario){
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - DELETE FROM Usuario WHERE codigo = ?
            sessao.delete(usuario);
            
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
     
      public void editar(Usuario usuario){
    //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;
        
        try{
            //inicia a transação
            transacao = sessao.beginTransaction();
            
            //Remove o objeto na tabela - UPDATE Usuario SET descricao  = ? WHERE codigo = ?
            sessao.update(usuario);
            
            //encerra a transação
            transacao.commit();
            
        
         }catch(ConstraintViolationException consErro){    
            
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
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
      
      public Usuario ConfirmarUsuario(String login,String senha){
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            //Cria a consulta - SELECT * FROM Usuario
            Criteria consulta = sessao.createCriteria(Usuario.class);
            
            consulta.add(Restrictions.eq("login", login));
            
            consulta.add(Restrictions.eq("senha", senha));
                     
            //Executa a consulta
            Usuario resultado = (Usuario) consulta.uniqueResult();
            if(resultado == null){
                return null;
            }else{
            return resultado;
            }
       
        } catch(RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }
      
      public static List<Usuario> buscar(String palavra) {
        
          Session sessao = HibernateUtil.getSessionFactory().openSession();
          
          try {
              Criteria consulta = sessao.createCriteria(Usuario.class);
              consulta.add(Restrictions.like("nome", "%"+palavra+"%"));
              List<Usuario> resultado = consulta.list();
              return resultado;
          } catch (RuntimeException e) {
              throw e;
          }
    }
     
}