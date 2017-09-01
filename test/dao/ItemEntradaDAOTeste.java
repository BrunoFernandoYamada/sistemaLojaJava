package dao;

import dominio.Entrada;
import dominio.ItemEntrada;
import dominio.Produto;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class ItemEntradaDAOTeste {
    
    @Test
    public void inserir(){
        //Cria um objeto de acesso aos dados da Entrada
        EntradaDAO entradaDAO = new EntradaDAO();
        
        //Busca a categoria
        Entrada entrada = entradaDAO.buscar(2);
        
        // Cria um objeto de acesso aos dados do Produto
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Busca o produto
        Produto produto = produtoDAO.buscar(6);
        
        // Cria um objeto de acesso aos dados do 
        ItemEntrada itementrada = new ItemEntrada();
        
        //Preenche os campos
        itementrada.setCodEntrada(entrada);
        itementrada.setCodProduto(produto);
        itementrada.setPrecoCusto((float)200.0);
        itementrada.setQuantidade(10);
        
        //Cria o domínio
        ItemEntradaDAO itementradaDAO = new ItemEntradaDAO();
        
        //chama o metodo 
        itementradaDAO.inserir(itementrada);
    }


    @Test
    @Ignore
    public void listar(){
        
        ItemEntradaDAO itementradaDAO = new ItemEntradaDAO();
        
        List<ItemEntrada> resultado = itementradaDAO.listar();
        
        for(ItemEntrada itementrada: resultado){
            System.out.println(itementrada);
        }
    }

    @Test
    @Ignore
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        ItemEntradaDAO itementradaDAO = new ItemEntradaDAO();
        
        //Realiza a coonsulta
        ItemEntrada resultado = itementradaDAO.buscar(codigo);
        
        //Verifica se o resultado é diferente de nulo
        //Assert.assertNotNull(resultado);
        
        //Imprime o resultado
        System.out.println("Objeto Encontrado: " + resultado);
    }
    
    @Test
    @Ignore
    public void excluir(){
        //Define o critério da busca
        Integer codigo = 4;
        
        //Cria o objeto de acesso aos dados
        ItemEntradaDAO itementradaDAO = new ItemEntradaDAO();
        
        //Realiza a consulta
        ItemEntrada resultado = itementradaDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        itementradaDAO.excluir(resultado);
    }
    
    @Test
    
    public void editar(){        
        //Cria o objeto de acesso aos dados
        ItemEntradaDAO itementradaDAO = new ItemEntradaDAO();
        EntradaDAO entradaDAO = new EntradaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Realiza a consulta
        ItemEntrada resultado = itementradaDAO.buscar(1);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Realiza a consulta
        Entrada entrada = entradaDAO.buscar(1);
        Produto produto = produtoDAO.buscar(1);
        
        //Altera os valores dos atributos
        resultado.setQuantidade(9);
        resultado.setCodEntrada(entrada);
        resultado.setCodProduto(produto);
        resultado.setPrecoCusto((float) 900.00);
        
        // Edita o objeto
        itementradaDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}