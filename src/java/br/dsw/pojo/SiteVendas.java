package br.dsw.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQuery(
        name="SiteVendas.findAll",
        query="SELECT s FROM SiteVendas s"
)
@Entity
public class SiteVendas implements Serializable {

    @OneToOne
    @JoinColumn(unique=true)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Promocao> promocoes;

    private String url; 
    @Id
    private String nome;
    private String telefone;

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String getUrl() { return this.url; }
    
    public void setUrl(String url) { this.url = url; }
    
    public String getNome() { return this.nome; }
    
    public void setNome(String nome) { this.nome = nome; }
    
    public String getTelefone() { return this.telefone; }
    
    public void setTelefone(String telefone) { this.telefone = telefone; }

     @Override 
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SiteVendas other = (SiteVendas) obj;
        if (nome != other.getNome()) {
            return false;
        }
        return true;
    }


}
