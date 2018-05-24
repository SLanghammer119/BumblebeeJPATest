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
@Table(name = "articledescriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articledescriptions.findAll", query = "SELECT a FROM Articledescriptions a")
    , @NamedQuery(name = "Articledescriptions.findByArtdesid", query = "SELECT a FROM Articledescriptions a WHERE a.artdesid = :artdesid")})
public class Articledescriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artdesid")
    private Integer artdesid;
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    @ManyToOne(optional = false)
    private Article articlesArtid;
    @JoinColumn(name = "descriptions_desid", referencedColumnName = "desid")
    @ManyToOne(optional = false)
    private Descriptions descriptionsDesid;

    public Articledescriptions() {
    }

    public Articledescriptions(Integer artdesid) {
        this.artdesid = artdesid;
    }

    public Integer getArtdesid() {
        return artdesid;
    }

    public void setArtdesid(Integer artdesid) {
        this.artdesid = artdesid;
    }

    public Article getArticlesArtid() {
        return articlesArtid;
    }

    public void setArticlesArtid(Article articlesArtid) {
        this.articlesArtid = articlesArtid;
    }

    public Descriptions getDescriptionsDesid() {
        return descriptionsDesid;
    }

    public void setDescriptionsDesid(Descriptions descriptionsDesid) {
        this.descriptionsDesid = descriptionsDesid;
    }
    
}
