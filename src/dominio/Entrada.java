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
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codEntrada;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Column(length = 10, nullable = false, unique = true)
    private String notafiscal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Fornecedor codFornecedor;

    public Integer getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(Integer codEntrada) {
        this.codEntrada = codEntrada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Fornecedor getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Fornecedor codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(String notafiscal) {
        this.notafiscal = notafiscal;
    }

    @Override
    public String toString() {
        return "Entrada{" + "codEntrada=" + codEntrada + ", dataEntrada=" + dataEntrada + ", notafiscal=" + notafiscal + ", codFornecedor=" + codFornecedor + '}';
    }

}