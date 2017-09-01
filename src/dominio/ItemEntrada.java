package dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codItem;
    
    @Column(nullable = false, unique = false)
    private Integer quantidade;
    
    @Column(nullable = false, unique = false)
    private Float precoCusto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Entrada codEntrada;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Produto codProduto;

    public Integer getCodItem() {
        return codItem;
    }

    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Entrada getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(Entrada codEntrada) {
        this.codEntrada = codEntrada;
    }

    public Produto getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Produto codProduto) {
        this.codProduto = codProduto;
    }

    @Override
    public String toString() {
        return "ItemEntrada{" + "codItem=" + codItem + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto + ", codEntrada=" + codEntrada + ", codProduto=" + codProduto + '}';
    }
    
    
}
