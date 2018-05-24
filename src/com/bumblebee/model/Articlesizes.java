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
@Table(name = "articlesizes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articlesizes.findAll", query = "SELECT a FROM Articlesizes a")
    , @NamedQuery(name = "Articlesizes.findByArtsizid", query = "SELECT a FROM Articlesizes a WHERE a.artsizid = :artsizid")})
public class Articlesizes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artsizid")
    private Integer artsizid;
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    @ManyToOne(optional = false)
    private Article articlesArtid;
    @JoinColumn(name = "units_unitid", referencedColumnName = "unitid")
    @ManyToOne(optional = false)
    private Unit unitsUnitid;

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

    public Article getArticlesArtid() {
        return articlesArtid;
    }

    public void setArticlesArtid(Article articlesArtid) {
        this.articlesArtid = articlesArtid;
    }

    public Unit getUnitsUnitid() {
        return unitsUnitid;
    }

    public void setUnitsUnitid(Unit unitsUnitid) {
        this.unitsUnitid = unitsUnitid;
    }

    
}
