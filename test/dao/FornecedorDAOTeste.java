
package dao;

import dominio.Fornecedor;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class FornecedorDAOTeste {
    
    @Test
    public void inserir(){
        
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setRazaoSocial("Tagima");
        fornecedor.setCnpj("11111111111111");
        fornecedor.setRua("Gastão Vidigal");
        fornecedor.setNumero("1223");
        fornecedor.setBairro("Jardim Matilde");
        fornecedor.setCidade("Ourinhos");
        fornecedor.setCep("12345123");
        fornecedor.setTelefone("33224455");
        
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.inserir(fornecedor);
    }
    @Test
    public void listar(){
        
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        List<Fornecedor> resultado = fornecedorDAO.listar();
        
        for(Fornecedor fornecedor: resultado){
            System.out.println(fornecedor);
        }
    }
    
    @Test
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        //Realiza a coonsulta
        Fornecedor resultado = fornecedorDAO.buscar(codigo);
        
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
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        //Realiza a consulta
        Fornecedor resultado = fornecedorDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        fornecedorDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Define o critério da busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso aos dados
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        //Realiza a consulta
        Fornecedor resultado = fornecedorDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Altera os valores dos atributos
        resultado.setRazaoSocial("Mc Donalds");
        
        // Edita o objeto
        fornecedorDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}