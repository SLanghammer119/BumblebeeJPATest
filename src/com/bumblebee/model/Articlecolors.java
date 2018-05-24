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
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articlecolors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articlecolors.findAll", query = "SELECT a FROM Articlecolors a")
    , @NamedQuery(name = "Articlecolors.findByArtcolid", query = "SELECT a FROM Articlecolors a WHERE a.artcolid = :artcolid")})
public class Articlecolors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artcolid")
    private Integer artcolid;
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    @ManyToOne(optional = false)
    private Article articlesArtid;
    @JoinColumn(name = "colors_colid", referencedColumnName = "colid")
    @ManyToOne(optional = false)
    private Colors colorsColid;

    public Articlecolors() {
    }

    public Articlecolors(Integer artcolid) {
        this.artcolid = artcolid;
    }

    public Integer getArtcolid() {
        return artcolid;
    }

    public void setArtcolid(Integer artcolid) {
        this.artcolid = artcolid;
    }

    public Article getArticlesArtid() {
        return articlesArtid;
    }

    public void setArticlesArtid(Article articlesArtid) {
        this.articlesArtid = articlesArtid;
    }

    public Colors getColorsColid() {
        return colorsColid;
    }

    public void setColorsColid(Colors colorsColid) {
        this.colorsColid = colorsColid;
    }

}
