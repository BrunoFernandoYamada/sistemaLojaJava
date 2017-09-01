package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codProduto; 
    
    @Column(length = 9, nullable = false, unique = true)
    private String codBarras;
    
    @Column(length = 45, nullable = false, unique = false)
    private String nomeProduto;
    
    @Column(nullable = false, unique = false)
    private Float preco;
    
    @Column(nullable = false, unique = false)
    private Float imposto;
    
    @Column(length = 45, nullable = false, unique = false)
    private String marca;
    
    @Column(length = 45, nullable = true, unique = false)
    private String modelo;
    
    @Column(nullable = true, unique = false)
    private String descricao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique=false)
    private Genero genero;
    
    @Column(nullable = true, unique = false)
    private Integer qtdEstoque;
    
    
    
    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getImposto() {
        return imposto;
    }

    public void setImposto(Float imposto) {
        this.imposto = imposto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
    
    
            
    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", imposto=" + imposto + ", marca=" + marca + ", modelo=" + modelo + ", descricao=" + descricao + ", genero=" + genero + ", qtdEstoque=" + qtdEstoque + ", codBarras=" + codBarras + '}';
    }
}
