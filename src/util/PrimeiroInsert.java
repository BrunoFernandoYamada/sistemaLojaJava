/*
 * This class create the first user in the Users table when the system will be installed.
 */
package util;

import dao.UsuarioDAO;
import dominio.Usuario;

public class PrimeiroInsert {
   
    public void inserirAdmin(){
        
        Usuario usuario = new Usuario();
           
            usuario.setNome("Admin");
            usuario.setCpf("00000000000");
            usuario.setTelefone("00000000");
            usuario.setRua("sem rua");
            usuario.setNumero("sem número");
            usuario.setBairro("sem bairro");
            usuario.setCidade("sem cidade");
            usuario.setCep("00000000");
            usuario.setLogin("admin");
            usuario.setSenha("admin");
            usuario.setTipo("Admin");
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.inserir(usuario);

    }
   
}
