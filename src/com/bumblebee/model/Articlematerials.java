/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Teilnehmer2
 */
@Entity
@Table(name = "articlematerials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articlematerials.findAll", query = "SELECT a FROM Articlematerials a")
    , @NamedQuery(name = "Articlematerials.findByArtmatid", query = "SELECT a FROM Articlematerials a WHERE a.artmatid = :artmatid")})
public class Articlematerials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artmatid")
    private Integer artmatid;
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    @ManyToOne(optional = false)
    private Article articlesArtid;
    @JoinColumn(name = "materials_matid", referencedColumnName = "matid")
    @ManyToOne(optional = false)
    private Materials materialsMatid;

    public Articlematerials() {
    }

    public Articlematerials(Integer artmatid) {
        this.artmatid = artmatid;
    }

    public Integer getArtmatid() {
        return artmatid;
    }

    public void setArtmatid(Integer artmatid) {
        this.artmatid = artmatid;
    }

    public Article getArticlesArtid() {
        return articlesArtid;
    }

    public void setArticlesArtid(Article articlesArtid) {
        this.articlesArtid = articlesArtid;
    }

    public Materials getMaterialsMatid() {
        return materialsMatid;
    }

    public void setMaterialsMatid(Materials materialsMatid) {
        this.materialsMatid = materialsMatid;
    }
    
}
