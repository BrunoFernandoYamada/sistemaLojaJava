package dao;

import dominio.ItemProduto;
import dominio.Venda;
import dominio.Produto;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class ItemProdutoDAOTeste {
    
    @Test
    public void inserir(){
        
        //Cria um objeto de acesso aos dados da Venda
        VendaDAO vendaDAO = new VendaDAO();
        
        //Busca a venda
        Venda venda = vendaDAO.buscar(1);
        
        // Cria um objeto de acesso aos dados do Produto
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Busca o produto
        Produto produto = produtoDAO.buscar(1);
        
        // Cria um objeto de acesso aos dados do 
        ItemProduto itemproduto = new ItemProduto();
        
        //Cria o domínio
        ItemProdutoDAO itemprodutoDAO = new ItemProdutoDAO();
        
        //chama o metodo 
        itemprodutoDAO.inserir(itemproduto);
    }


    @Test
    public void listar(){
        
        ItemProdutoDAO itemprodutoDAO = new ItemProdutoDAO();
        
        List<ItemProduto> resultado = itemprodutoDAO.listar();
        
        for(ItemProduto itemproduto: resultado){
            System.out.println(itemproduto);
        }
    }

    @Test
    public void buscar(){
        //Define o critério de busca
        Integer codigo = 1;
        
        //Cria o objeto de acesso a dados
        ItemProdutoDAO itemprodutoDAO = new ItemProdutoDAO();
        
        //Realiza a coonsulta
        ItemProduto resultado = itemprodutoDAO.buscar(codigo);
        
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
        ItemProdutoDAO itemprodutoDAO = new ItemProdutoDAO();
        
        //Realiza a consulta
        ItemProduto resultado = itemprodutoDAO.buscar(codigo);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Remove o objeto
        itemprodutoDAO.excluir(resultado);
    }
    
    @Test
    public void editar(){
        //Cria o objeto de acesso aos dados
        ItemProdutoDAO itemprodutoDAO = new ItemProdutoDAO();
        VendaDAO vendaDAO = new VendaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Realiza a consulta
        ItemProduto resultado = itemprodutoDAO.buscar(1);
        
        //Imprime o objeto encontrado
        System.out.println("Objeto Encontrado: " + resultado);
        
        //Realiza a consulta
        Produto produto = produtoDAO.buscar(1);
        Venda venda = vendaDAO.buscar(1);
        
        //Altera os valores dos atributos
        resultado.setQuantidade(9);
        resultado.setCodProduto(produto);
        resultado.setCodVenda(venda);
        
        // Edita o objeto
        itemprodutoDAO.editar(resultado);
        
        //Imprime o objeto editado
        System.out.println("Objeto editado: " + resultado);
    }
}