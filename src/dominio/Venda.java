package dominio;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codVenda;
    
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @Column(nullable = false, unique = false)
    private Float valorTotal;
    
    @Column(nullable = false, unique = false)
    private Boolean parcelamento;
    
    @Column(nullable = true, unique = false)
    private String juros;
    
    @Column(nullable = true, unique = false)
    private Integer qtdParcelas;
    
    @Column(nullable = true, unique = false)
    private Float valorParcela;
    
    @Column(nullable = true, unique = false)
    private Float entrada;   
    
    @Column(nullable = false, unique = false)
    private String formaPgt;
    
    @Column(nullable = true, unique = false)
    private Float desconto;

    @Column(nullable = true, unique = false)
    private Float valorParcelado;

    public Float getValorParcelado() {
        return valorParcelado;
    }

    public void setValorParcelado(Float valorParcelado) {
        this.valorParcelado = valorParcelado;
    }
    
    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, unique = false)
    private Cliente codCliente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Usuario codUsuario;

    public String getFormaPgt() {
        return formaPgt;
    }

    public void setFormaPgt(String formaPgt) {
        this.formaPgt = formaPgt;
    }
    
    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Boolean getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(Boolean parcelamento) {
        this.parcelamento = parcelamento;
    }

    public String getJuros() {
        return juros;
    }

    public void setJuros(String juros) {
        this.juros = juros;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Float valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Float getEntrada() {
        return entrada;
    }

    public void setEntrada(Float entrada) {
        this.entrada = entrada;
    }
    
  

    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + ", codCliente=" + codCliente + ", codUsuario=" + codUsuario + '}';
    }
    
}
