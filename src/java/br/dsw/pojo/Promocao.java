/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints={
        @UniqueConstraint(columnNames={"SITEVENDAS_ID", "diaHorario"}),
        @UniqueConstraint(columnNames={"TEATRO_ID", "diaHorario"})
    }
)
@NamedQuery(
        name="Promocao.findAll",
        query="SELECT p FROM Promocao p"
)
public class Promocao implements Serializable {

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double preco;
    @Temporal(TemporalType.DATE) 
    private Date diaHorario;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private SiteVendas siteVendas;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Teatro teatro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDiaHorario() {
        return diaHorario;
    }

    public void setDiaHorario(Date diaHorario) {
        this.diaHorario = diaHorario;
    }

    public SiteVendas getSiteVendas() {
        return siteVendas;
    }

    public void setSiteVendas(SiteVendas site) {
        this.siteVendas = site;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
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
    Promocao other = (Promocao) obj;
    if (id != other.id)
        return false;
    return true;
}
}
