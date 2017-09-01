
package dao;

import dominio.Cliente;
import java.sql.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Ignore;
import org.junit.Test;
import configDB.HibernateUtil;

public class ClienteDAOTeste {
   
    @Test
   
    //metodo para testar o inserir
    public void inserir(){
        
        Cliente cliente = new Cliente();
            
        cliente.setNome("Bruno Fernando Yamada");
        cliente.setCpfCnpj("3333333333");
        cliente.setRg("411111100");
        cliente.setRua("João Batista furlani");
        cliente.setNumero("216");
        cliente.setBairro("Jardim Matilde");
        cliente.setCidade("Ourinhos");
        cliente.setCep("19901030");
        cliente.setDataNascimento(new Date(19830920));
        cliente.setEmail("yamada_bruno@hotmail.com");
        cliente.setTelFixo("1433224742");
        cliente.setTelMovel("14996208270");
        cliente.setTipo("admin");
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.inserir(cliente);   
    }
    
    @Test
    
    public void listar(){
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        List<Cliente> resultado = clienteDAO.Listar();
        
        for(Cliente cliente: resultado){
            System.out.println(cliente);
        }
    }
    
    @Test
    
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Realiza a coonsulta
        Cliente resultado = clienteDAO.buscar(codigo);
        
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
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Realiza a consulta
        Cliente resultado = clienteDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        clienteDAO.excluir(resultado);
    }
    
    @Test
    
    public void editar(){
        //Define o critério da busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso aos dados
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Realiza a consulta
        Cliente resultado = clienteDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Altera os valores dos atributos
        resultado.setBairro("Vila Menk");
        
        // Edita o objeto
        clienteDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
        
       
}