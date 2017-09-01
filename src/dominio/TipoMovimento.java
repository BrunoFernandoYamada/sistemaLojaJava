/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoMovimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMov;
    
    @Column(length = 45, unique = true, nullable = false)
    private String tipoMov;

    public Integer getCodMov() {
        return codMov;
    }

    public void setCodMov(Integer codMov) {
        this.codMov = codMov;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    @Override
    public String toString() {
        return "TipoMovimento{" + "codMov=" + codMov + ", tipoMov=" + tipoMov + '}';
    }
    
    
    
}
