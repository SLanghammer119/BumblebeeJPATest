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
@Table(name = "units")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Units.findAll", query = "SELECT u FROM Units u")
    , @NamedQuery(name = "Units.findByUnitid", query = "SELECT u FROM Units u WHERE u.unitid = :unitid")
    , @NamedQuery(name = "Units.findByUnit", query = "SELECT u FROM Units u WHERE u.unit = :unit")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unitid")
    private Integer unitid;
    @Column(name = "unit")
    private String unit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitsUnitid")
    private Collection<Articlesizes> articlesizesCollection;

    public Unit() {
    }

    public Unit(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public Collection<Articlesizes> getArticlesizesCollection() {
        return articlesizesCollection;
    }

    public void setArticlesizesCollection(Collection<Articlesizes> articlesizesCollection) {
        this.articlesizesCollection = articlesizesCollection;
    }
    
}
