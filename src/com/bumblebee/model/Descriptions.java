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
@Table(name = "descriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descriptions.findAll", query = "SELECT d FROM Descriptions d")
    , @NamedQuery(name = "Descriptions.findByDesid", query = "SELECT d FROM Descriptions d WHERE d.desid = :desid")
    , @NamedQuery(name = "Descriptions.findByFeature", query = "SELECT d FROM Descriptions d WHERE d.feature = :feature")})
public class Descriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desid")
    private Integer desid;
    @Column(name = "feature")
    private String feature;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descriptionsDesid")
    private Collection<Articledescriptions> articledescriptionsCollection;

    public Descriptions() {
    }

    public Descriptions(Integer desid) {
        this.desid = desid;
    }

    public Integer getDesid() {
        return desid;
    }

    public void setDesid(Integer desid) {
        this.desid = desid;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @XmlTransient
    public Collection<Articledescriptions> getArticledescriptionsCollection() {
        return articledescriptionsCollection;
    }

    public void setArticledescriptionsCollection(Collection<Articledescriptions> articledescriptionsCollection) {
        this.articledescriptionsCollection = articledescriptionsCollection;
    }
    
}
