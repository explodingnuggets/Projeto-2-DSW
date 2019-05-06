package br.dsw.pojo;

import javax.persistence.Entity;

@Entity
public class SiteVendas extends Usuario {
    private String url;
    private String nome;
    private String telefone;
    
    public String getUrl() { return this.url; }
    
    public void setUrl(String url) { this.url = url; }
    
    public String getNome() { return this.nome; }
    
    public void setNome(String nome) { this.nome = nome; }
    
    public String getTelefone() { return this.telefone; }
    
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
