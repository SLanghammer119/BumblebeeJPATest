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
import javax.persistence.Lob;
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
@Table(name = "colors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colors.findAll", query = "SELECT c FROM Colors c")
    , @NamedQuery(name = "Colors.findByColid", query = "SELECT c FROM Colors c WHERE c.colid = :colid")
    , @NamedQuery(name = "Colors.findByColor", query = "SELECT c FROM Colors c WHERE c.color = :color")})
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colid")
    private Integer colid;
    @Column(name = "color")
    private String color;
    @Lob
    @Column(name = "colorphoto")
    private byte[] colorphoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorsColid")
    private Collection<Articlecolors> articlecolorsCollection;

    public Colors() {
    }

    public Colors(Integer colid) {
        this.colid = colid;
    }

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getColorphoto() {
        return colorphoto;
    }

    public void setColorphoto(byte[] colorphoto) {
        this.colorphoto = colorphoto;
    }

    @XmlTransient
    public Collection<Articlecolors> getArticlecolorsCollection() {
        return articlecolorsCollection;
    }

    public void setArticlecolorsCollection(Collection<Articlecolors> articlecolorsCollection) {
        this.articlecolorsCollection = articlecolorsCollection;
    }
    
}
