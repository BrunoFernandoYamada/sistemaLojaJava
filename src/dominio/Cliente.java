package dominio;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer codCliente;
   
   @Column(length = 14,nullable = false, unique = true)
   private String cpfCnpj;
   
   @Column(length = 9,nullable = false, unique = true)
   private String rg;
   
   @Column(length = 8,nullable = false, unique = false)
   private String tipo;
   
   @Column(length = 45,nullable = false, unique = false)
   private String nome;
   
   @Column(length = 11,nullable = false, unique = false)
   private String telFixo;
   
   @Column(length = 11,nullable = false, unique = false)
   private String telMovel;
   
   @Column(length = 45,nullable = false, unique = true)
   private String email;
   
   @Temporal(TemporalType.DATE)
   private Date dataNascimento;
   
   @Column(length = 45,nullable = false, unique = false)
   private String rua;
   
   @Column(length = 5,nullable = false, unique = false)
   private String numero;
   
   @Column(length = 45,nullable = false, unique = false)
   private String bairro;
   
   @Column(length = 45,nullable = false, unique = false)
   private String cidade;
   
   @Column(length = 10,nullable = false, unique = false)
   private String cep;


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
   
   
    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelMovel() {
        return telMovel;
    }

    public void setTelMovel(String telMovel) {
        this.telMovel = telMovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return "Cliente{" + "codCliente=" + codCliente + ", cpfCnpj=" + cpfCnpj + ", rg=" + rg + ", tipo=" + tipo + ", nome=" + nome + ", telFixo=" + telFixo + ", telMovel=" + telMovel + ", email=" + email + ", dataNascimento=" + dataNascimento + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + '}';
    }
   
   
}
