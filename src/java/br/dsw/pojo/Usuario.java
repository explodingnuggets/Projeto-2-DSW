package br.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="Usuario.findAll", query="SELECT u from Usuario u")
})
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String email;
    private String senha;
    private boolean isAdmin = false;
    
    public long getId() { return this.id; }
    
    public void setId(long id) { this.id = id; }
    
    public String getEmail() { return this.email; }
    
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return this.senha; }
    
    public void setSenha(String senha) { this.senha = senha; }
    
    public boolean getAdmin() { return this.isAdmin; }
    
    public void setAdmin(boolean admin) { this.isAdmin = admin; }
}
