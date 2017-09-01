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
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codItemProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Venda codVenda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Produto codProduto;

    @Column(nullable = false, unique = false)
    private Integer quantidade;

    @Column(nullable = false, unique = false)
    private Float precoUnitario;

    public Integer getCodItemProduto() {
        return codItemProduto;
    }

    public void setCodItemProduto(Integer codItemProduto) {
        this.codItemProduto = codItemProduto;
    }

    public Venda getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Venda codVenda) {
        this.codVenda = codVenda;
    }

    public Produto getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Produto codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemProduto{" + "codItemProduto=" + codItemProduto + ", codVenda=" + codVenda + ", codProduto=" + codProduto + ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario + '}';
    }
}
