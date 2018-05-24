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
@Table(name = "primecategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Primecategories.findAll", query = "SELECT p FROM Primecategories p")
    , @NamedQuery(name = "Primecategories.findByPrimeid", query = "SELECT p FROM Primecategories p WHERE p.primeid = :primeid")
    , @NamedQuery(name = "Primecategories.findByPrimename", query = "SELECT p FROM Primecategories p WHERE p.primename = :primename")})
public class Primecategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "primeid")
    private Integer primeid;
    @Basic(optional = false)
    @Column(name = "primename")
    private String primename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primecategoriesPrimeid")
    private Collection<Subcategories> subcategoriesCollection;

    public Primecategories() {
    }

    public Primecategories(Integer primeid) {
        this.primeid = primeid;
    }

    public Primecategories(Integer primeid, String primename) {
        this.primeid = primeid;
        this.primename = primename;
    }

    public Integer getPrimeid() {
        return primeid;
    }

    public void setPrimeid(Integer primeid) {
        this.primeid = primeid;
    }

    public String getPrimename() {
        return primename;
    }

    public void setPrimename(String primename) {
        this.primename = primename;
    }

    @XmlTransient
    public Collection<Subcategories> getSubcategoriesCollection() {
        return subcategoriesCollection;
    }

    public void setSubcategoriesCollection(Collection<Subcategories> subcategoriesCollection) {
        this.subcategoriesCollection = subcategoriesCollection;
    }
    
}
