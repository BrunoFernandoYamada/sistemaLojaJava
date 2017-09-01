package dao;

import dominio.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import configDB.HibernateUtil;

public class ProdutoDAO {

    public void inserir(Produto produto) {

        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //declara um objeto que irá controlar a transação
        Transaction transacao = null;

        try {
            //inicia a transação
            transacao = sessao.beginTransaction();

            //Insere o objeto na tabela
            sessao.save(produto);

            //encerra a transação
            transacao.commit();

        } catch (ConstraintViolationException consErro) {

            JOptionPane.showMessageDialog(null, "Produto já cadastrado!");
            if (transacao != null) {
                transacao.rollback();
            }
            throw consErro;

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

    public List<Produto> listar() {

        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            //Criando a consulta SELECT * FROM Produto
            Criteria consulta = sessao.createCriteria(Produto.class);

            //Define a ordenação SELECT * FROM Produto ORDER BY nomeProduto
            consulta.addOrder(Order.asc("nomeProduto"));// precisa ser o no usado no objeto

            //agora executa a consulta
            List<Produto> resultado = consulta.list();

            //retorna o resultado
            return resultado;

        } catch (RuntimeException erro) {

            throw erro;
        } finally {
            //Fecha a sessão
            sessao.close();
        }
    }

    public Produto buscar(Integer codigo) {
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            //Cria a consulta - SELECT * FROM Produto
            Criteria consulta = sessao.createCriteria(Produto.class);

            //Define uma restrição - SELECT * FROM Produto WHERE codigo = ?
            consulta.add(Restrictions.eq("codProduto", codigo));

            //Executa a consulta
            Produto resultado = (Produto) consulta.uniqueResult();

            //Retorna o resultado
            return resultado;

        } catch (RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }

    public Produto buscarBarras(String codigo) {
        //Captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            //Cria a consulta - SELECT * FROM Produto
            Criteria consulta = sessao.createCriteria(Produto.class);

            //Define uma restrição - SELECT * FROM Produto WHERE codigo = ?
            consulta.add(Restrictions.eq("codBarras", codigo));

            //Executa a consulta
            Produto resultado = (Produto) consulta.uniqueResult();

            //Retorna o resultado
            return resultado;

        } catch (RuntimeException erro) {
            //Repropaga a exceção
            throw erro;
        } finally {
            //fecha a sessão
            sessao.close();
        }
    }

    public void excluir(Produto produto) {
        //captura uma sessão
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        //declara um objeto que irá controlar a transação
        Transaction transacao = null;

        try {
            //inicia a transação
            transacao = sessao.beginTransaction();

            //Remove o objeto na tabela - DELETE FROM Produto WHERE codigo = ?
            sessao.delete(produto);

            //encerra a transação
            transacao.commit();

        } catch(ConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "Não é possível excluir este produto pois existem entradas que dependem dele", "Atenção", 2);
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
            
        }catch (RuntimeException erro) {
            //verifica se a transação foi iniciada
            if (transacao != null) {
                //cancela a transação
                transacao.rollback();
            }
            //repropago a transação
            throw erro;
        }finally {
            sessao.close();
        }
    }

    public void editar(Produto produto) {
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

    public List<Produto> buscar(String palavra) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Produto.class);
            consulta.add(Restrictions.like("nomeProduto", "%" + palavra + "%"));
            List<Produto> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public Produto buscarPorNome(String palavra) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Produto.class);
            consulta.add(Restrictions.like("nomeProduto", palavra));
            Produto produto = (Produto) consulta.uniqueResult();
            return produto;

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
