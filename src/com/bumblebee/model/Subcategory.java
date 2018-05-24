/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "subcategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s")
    , @NamedQuery(name = "Subcategory.findBySubcatid", query = "SELECT s FROM Subcategory s WHERE s.subcatid = :subcatid")
    , @NamedQuery(name = "Subcategory.findBySubcatname", query = "SELECT s FROM Subcategory s WHERE s.subcatname = :subcatname")})
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcatid")
    private Integer subcatid;
    @Basic(optional = false)
    @Column(name = "subcatname")
    private String subcatname;
    
    
    @ManyToOne(targetEntity=Primecategory.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "primecategory_primeid", referencedColumnName = "primeid")
    private Primecategory primecategory;
    
    
    @OneToMany(targetEntity=Subcategory.class, mappedBy="subcategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles;

    public Subcategory() {
    }

    public Subcategory(Integer subcatid) {
        this.subcatid = subcatid;
    }

    public Subcategory(Integer subcatid, String subcatname) {
        this.subcatid = subcatid;
        this.subcatname = subcatname;
    }

    public Integer getSubcatid() {
        return subcatid;
    }

    public void setSubcatid(Integer subcatid) {
        this.subcatid = subcatid;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public Primecategory getPrimecategory() {
        return primecategory;
    }

    public void setPrimecategory(Primecategory primecategory) {
        this.primecategory = primecategory;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    

  
    
}
