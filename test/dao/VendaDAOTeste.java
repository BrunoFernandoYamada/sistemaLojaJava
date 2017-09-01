package dao;

import dominio.Cliente;
import dominio.Usuario;
import dominio.Venda;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class VendaDAOTeste {

    @Test
    public void inserir(){
        //Cria um objeto de acesso aos dados do Usuario
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Busca o usuario
        Usuario usuario = usuarioDAO.buscar(1);
        
        //Cria um objeto de acesso aos dados do cliente
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Busca o cliente
        Cliente cliente = clienteDAO.buscar(1);
        
        //criação de um objeto de dominio
        Venda venda = new Venda();
        
        //Preenchimento das informações
        venda.setCodCliente(cliente);
        venda.setCodUsuario(usuario);
        venda.setValorTotal((float)499.00);
        
        //cria um objeto DAO
        VendaDAO vendaDAO = new VendaDAO();
        
        //chama o metodo 
        vendaDAO.inserir(venda);
    }
    
    @Test
    public void listar(){
        
        //Criar um objeto do tipo DAO
        VendaDAO vendaDAO = new VendaDAO();
        
        //CAPtura o resultado da consulta
        List<Venda> resultado = vendaDAO.listar();
        
        //Percorre o resultado
        for(Venda venda : resultado){
            System.out.println(venda);
        }      
    }
    
    @Test
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        VendaDAO vendaDAO = new VendaDAO();
        
        //Realiza a consulta
        Venda resultado = vendaDAO.buscar(codigo);
        
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
        VendaDAO vendaDAO = new VendaDAO();
        
        //Realiza a consulta
        Venda resultado = vendaDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        vendaDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Cria o objeto de acesso aos dados
        ClienteDAO clienteDAO = new ClienteDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        VendaDAO vendaDAO = new VendaDAO();
        
        //Realiza a consulta
        Venda resultado = vendaDAO.buscar(1);
        
        // Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Realiza a consulta de usuarios e clientes
        Cliente cliente = clienteDAO.buscar(1);
        Usuario usuario = usuarioDAO.buscar(1);
        
        //Altera os valores dos atributos
        resultado.setValorTotal((float)2999.00);
        resultado.setCodCliente(cliente);
        resultado.setCodUsuario(usuario);
        
        // Edita o objeto
        vendaDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}
