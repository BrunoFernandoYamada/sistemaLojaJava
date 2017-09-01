package dao;

import dominio.Genero;
import dominio.Produto;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class ProdutoDAOTeste {
    
    @Test
    public void inserir(){
        //Cria um objeto de acesso aos dados do Gênero
        GeneroDAO generoDAO = new GeneroDAO();
        
        //Busca a categoria
        Genero genero = generoDAO.buscar("Cordas");
        
        //criação de um objeto de dominio
        Produto produto = new Produto();
        
        //preenchimento da informações
        produto.setNomeProduto("Violão");
        produto.setGenero(genero);
        produto.setMarca("Tagima");
        produto.setModelo("sbsb20");
        produto.setPreco((float)3000.00);
        produto.setImposto((float)20.0);
        produto.setDescricao("Tviolão");
        produto.setCodBarras("123456734");
        produto.setQtdEstoque(0);
        
        //cria um objeto DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //chama o metodo 
        produtoDAO.inserir(produto);
    }
    
    @Test
    public void listar(){
        
        //Criar um objeto do tippo DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //CAPtura o resultado da consulta
        List<Produto> resultado = produtoDAO.listar();
        
        //Percorre o resultado
        for(Produto produto : resultado){
            System.out.println(produto);
        }      
    }
    
    @Test
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Realiza a coonsulta
        Produto resultado = produtoDAO.buscar(codigo);
        
        //Verifica se o resultado é diferente de nulo
        //Assert.assertNotNull(resultado);
        
        //Imprime o resultado
        System.out.println("Objeto Encontrado: " + resultado);
    }
    
    @Test
    public void excluir(){
        //Define o critério da busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso aos dados
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Realiza a consulta
        Produto resultado = produtoDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        produtoDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Cria o objeto de acesso aos dados
        ProdutoDAO produtoDAO = new ProdutoDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        
        //Realiza a consulta
        Produto resultado = produtoDAO.buscar(1);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Realiza a consulta
        Genero genero = generoDAO.buscar("Cordas");
        
        //Altera os valores dos atributos
        resultado.setPreco((float)2999.00);
        resultado.setGenero(genero);
        
        // Edita o objeto
        produtoDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}