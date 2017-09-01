package dao;

import dominio.Entrada;
import dominio.Fornecedor;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class EntradaDAOTeste {
    
    @Test
    public void inserir(){
        //Cria um objeto de acesso aos dados do Fornecedor
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        //Busca a categoria
        Fornecedor fornecedor = fornecedorDAO.buscar(1);
        
        //criação de um objeto de dominio
        Entrada entrada = new Entrada();
        
        //Preenchimento dos campos
        entrada.setDataEntrada(new Date());
        entrada.setCodFornecedor(fornecedor);
        
        //cria um objeto DAO
        EntradaDAO entradaDAO = new EntradaDAO();
        
        //chama o metodo 
        entradaDAO.inserir(entrada);
    }
    
    @Test
   
    public void listar(){
        
        //Criar um objeto do tippo DAO
        EntradaDAO entradaDAO = new EntradaDAO();
        
        //Captura o resultado da consulta
        List<Entrada> resultado = entradaDAO.listar();
        
        //Percorre o resultado
        for(Entrada entrada : resultado){
            System.out.println(entrada);
        }      
    }
    
    @Test
    
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        EntradaDAO entradaDAO = new EntradaDAO();
        
        //Realiza a consulta
        Entrada resultado = entradaDAO.buscar(codigo);
        
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
        EntradaDAO entradaDAO = new EntradaDAO();
        
        //Realiza a consulta
        Entrada resultado = entradaDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        entradaDAO.excluir(resultado);
    }
    
    @Test
    
    public void editar(){
        //Cria o objeto de acesso aos dados
        EntradaDAO entradaDAO = new EntradaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        //Realiza a consulta
        Entrada resultado = entradaDAO.buscar(1);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Realiza a consulta
        Fornecedor fornecedor = fornecedorDAO.buscar(1);
        
        //Altera os dados
        resultado.setCodFornecedor(fornecedor);
        resultado.setDataEntrada(new Date());
        
        // Edita o objeto
        entradaDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}