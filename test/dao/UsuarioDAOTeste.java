package dao;

import dominio.Usuario;
import java.util.List;
import org.junit.Test;

public class UsuarioDAOTeste {
    
    @Test
    public void inserir(){
        
        Usuario usuario = new Usuario();
        usuario.setNome("Pedro Domingues");
        usuario.setTipo("Admin");
        usuario.setCpf("11111111111");
        usuario.setLogin("e");
        usuario.setSenha("e");
        usuario.setRua("Nove de Julho");
        usuario.setNumero("12");
        usuario.setBairro("Jardim Martilde");
        usuario.setCidade("Ourinhos");
        usuario.setTelefone("33222278");
        usuario.setCep("99229999");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }
    
    @Test
    public void listar(){
        
        //Criar um objeto do tippo DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //CAPtura o resultado da consulta
        List<Usuario> resultado = usuarioDAO.listar();
        
        //Percorre o resultado
        for(Usuario usuario : resultado){
            System.out.println(usuario);
        }      
    }
    
    @Test
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Realiza a coonsulta
        Usuario resultado = usuarioDAO.buscar(codigo);
        
        //Verifica se o resultado é diferente de nulo
        //Assert.assertNotNull(resultado);
        
        //Imprime o resultado
        System.out.println("Objeto Encontrado: " + resultado);
    }
    
    @Test
    public void excluir(){
        //Define o critério da busca
        Integer codigo = 4;
        
        //Cria o objeto de acesso aos dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Realiza a consulta
        Usuario resultado = usuarioDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        usuarioDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Define o critério da busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso aos dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Realiza a consulta
        Usuario resultado = usuarioDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Altera os valores dos atributos
        resultado.setNome("Rua 1234 de 5");
        
        // Edita o objeto
        usuarioDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}