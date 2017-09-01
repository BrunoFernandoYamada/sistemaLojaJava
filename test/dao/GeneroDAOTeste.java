package dao;

import dominio.Genero;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class GeneroDAOTeste {
   @Test
    public void inserir(){
        
        Genero genero = new Genero();
        
        genero.setNome("Cordas");
        
        GeneroDAO generoDAO =  new GeneroDAO();
        
        generoDAO.inserir(genero);
    }


    @Test
    public void listar(){
        
        GeneroDAO generoDAO = new GeneroDAO();
        
        List<Genero> resultado = generoDAO.listar();
        
        for(Genero genero: resultado){
            System.out.println(genero);
        }
    }

    @Test
    public void buscar(){
        //Define o critério de busca
        String nomeGenero = "Cordas";
        
        //Cria o objeto de acesso a dados
        GeneroDAO generoDAO = new GeneroDAO();
        
        //Realiza a coonsulta
        Genero resultado = generoDAO.buscar(nomeGenero);
        
        //Verifica se o resultado é diferente de nulo
        //Assert.assertNotNull(resultado);
        
        //Imprime o resultado
        System.out.println("Objeto Encontrado: " + resultado);
    }
    
    @Test
    public void excluir(){
        //Define o critério da busca
        String nomeGenero = "Cordas";
        
        //Cria o objeto de acesso aos dados
        GeneroDAO generoDAO = new GeneroDAO();
        
        //Realiza a consulta
        Genero resultado = generoDAO.buscar(nomeGenero);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        generoDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Define o critério da busca
        String nomeGenero = "Cordas";
        
        //Cria o objeto de acesso aos dados
        GeneroDAO generoDAO = new GeneroDAO();
        
        //Realiza a consulta
        Genero resultado = generoDAO.buscar(nomeGenero);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Altera os valores dos atributos
        resultado.setNome("Cordas"); 
        
        // Edita o objeto
        generoDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}