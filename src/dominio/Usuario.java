package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codUsuario;
    
    @Column(length = 45,nullable = false, unique = true)
    private String nome;
    
    @Column(length = 10,nullable = false, unique = false)
    private String tipo;
    
    @Column(length = 11,nullable = false, unique = true)
    private String cpf;
    
    @Column(length = 45,nullable = false, unique = false)
    private String rua;
    
    @Column(length = 11,nullable = false, unique = false)
    private String numero;
    
    @Column(length = 45,nullable = false, unique = false)
    private String bairro;
    
    @Column(length = 45,nullable = false, unique = false)
    private String cidade;
    
    @Column(length = 8,nullable = false, unique = false)
    private String cep;
    
    @Column(length = 11,nullable = false, unique = false)
    private String telefone;
    
    @Column(length = 16,nullable = false, unique = true)
    private String login;
    
    @Column(length = 8,nullable = false, unique = false)
    private String senha;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nome=" + nome + ", tipo=" + tipo + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", telefone=" + telefone + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
}
