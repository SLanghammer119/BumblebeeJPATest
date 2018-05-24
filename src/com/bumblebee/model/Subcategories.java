/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teilnehmer2
 */
@Entity
@Table(name = "subcategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategories.findAll", query = "SELECT s FROM Subcategories s")
    , @NamedQuery(name = "Subcategories.findBySubcatid", query = "SELECT s FROM Subcategories s WHERE s.subcatid = :subcatid")
    , @NamedQuery(name = "Subcategories.findBySubcatname", query = "SELECT s FROM Subcategories s WHERE s.subcatname = :subcatname")})
public class Subcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcatid")
    private Integer subcatid;
    @Basic(optional = false)
    @Column(name = "subcatname")
    private String subcatname;
    @JoinColumn(name = "primecategories_primeid", referencedColumnName = "primeid")
    @ManyToOne(optional = false)
    private Primecategories primecategoriesPrimeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoriesSubid")
    private Collection<Article> articlesCollection;

    public Subcategories() {
    }

    public Subcategories(Integer subcatid) {
        this.subcatid = subcatid;
    }

    public Subcategories(Integer subcatid, String subcatname) {
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

    public Primecategories getPrimecategoriesPrimeid() {
        return primecategoriesPrimeid;
    }

    public void setPrimecategoriesPrimeid(Primecategories primecategoriesPrimeid) {
        this.primecategoriesPrimeid = primecategoriesPrimeid;
    }

    @XmlTransient
    public Collection<Article> getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(Collection<Article> articlesCollection) {
        this.articlesCollection = articlesCollection;
    }
    
}
