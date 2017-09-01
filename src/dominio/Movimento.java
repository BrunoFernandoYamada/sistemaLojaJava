/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Movimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMovimento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false )
    private TipoMovimento tipoMovimento;
    
    @Column(unique = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataExecucao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(unique = false, nullable = false)
    private Usuario usuario;

    public Integer getCodMovimento() {
        return codMovimento;
    }

    public void setCodMovimento(Integer codMovimento) {
        this.codMovimento = codMovimento;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Movimento{" + "codMovimento=" + codMovimento + ", tipoMovimento=" + tipoMovimento + ", dataExecucao=" + dataExecucao + ", usuario=" + usuario + '}';
    }
    
    
    
}
