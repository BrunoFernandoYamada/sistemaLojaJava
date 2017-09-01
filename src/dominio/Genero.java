package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codGenero;
    
    @Column(length = 45,nullable = false, unique = true)
    private String nome;

    public Integer getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(Integer codGenero) {
        this.codGenero = codGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "codGenero=" + codGenero + ", nome=" + nome + '}';
    }
    
    
}
