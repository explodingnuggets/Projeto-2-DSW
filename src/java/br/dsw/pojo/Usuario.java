package br.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(
        name="Usuario.findAll",
        query="SELECT u from Usuario u"
    ),
    @NamedQuery(
        name="Usuario.findByEmail",
        query="SELECT u FROM Usuario u WHERE u.email = :email"
    )
})
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id = -1;
    @Column(unique=true)
    private String email;
    private String senha;
    private boolean isAdmin = false;
    
    public Usuario() {}
    
    public Usuario(String email, String senha, boolean isAdmin) {
        this.email = email;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }
    
    public long getId() { return this.id; }
    
    public void setId(long id) { this.id = id; }
    
    public String getEmail() { return this.email; }
    
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return this.senha; }
    
    public void setSenha(String senha) { this.senha = senha; }
    
    public boolean getAdmin() { return this.isAdmin; }
    
    public void setAdmin(boolean admin) { this.isAdmin = admin; }

    @Override
    public String toString() {
        return  String.valueOf(id);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
