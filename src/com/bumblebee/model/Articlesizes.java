/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articlesizes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articlesize.findAll", query = "SELECT a FROM Articlesize a")
    , @NamedQuery(name = "Articlesize.findByArtsizid", query = "SELECT a FROM Articlesize a WHERE a.artsizid = :artsizid")})
public class Articlesizes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artsizid")
    private Integer artsizid;
    
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    @ManyToOne(targetEntity=Unit.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "units_unitid", referencedColumnName = "unitid")
    private Unit unit;

    public Articlesizes() {
    }

    public Articlesizes(Integer artsizid) {
        this.artsizid = artsizid;
    }

    public Integer getArtsizid() {
        return artsizid;
    }

    public void setArtsizid(Integer artsizid) {
        this.artsizid = artsizid;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    

    
}
