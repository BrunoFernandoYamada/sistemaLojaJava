package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codFornecedor;
    
    @Column(length = 14,nullable = false, unique = true)
    private String cnpj;
    
    @Column(nullable = false, unique = false)
    private String razaoSocial;
    
    @Column(length = 11,nullable = false, unique = false)
    private String telefone;
    
    @Column(length = 45,nullable = true, unique = false)
    private String email;
    
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
    
    

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Fornecedor{" + "codFornecedor=" + codFornecedor + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", telefone=" + telefone + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + '}';
    }         
}
