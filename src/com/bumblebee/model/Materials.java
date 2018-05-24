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
@Table(name = "materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m")
    , @NamedQuery(name = "Materials.findByMatid", query = "SELECT m FROM Materials m WHERE m.matid = :matid")
    , @NamedQuery(name = "Materials.findByMaterial", query = "SELECT m FROM Materials m WHERE m.material = :material")})
public class Materials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matid")
    private Integer matid;
    @Column(name = "material")
    private String material;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialsMatid")
    private Collection<Articlematerials> articlematerialsCollection;

    public Materials() {
    }

    public Materials(Integer matid) {
        this.matid = matid;
    }

    public Integer getMatid() {
        return matid;
    }

    public void setMatid(Integer matid) {
        this.matid = matid;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @XmlTransient
    public Collection<Articlematerials> getArticlematerialsCollection() {
        return articlematerialsCollection;
    }

    public void setArticlematerialsCollection(Collection<Articlematerials> articlematerialsCollection) {
        this.articlematerialsCollection = articlematerialsCollection;
    }
    
}
