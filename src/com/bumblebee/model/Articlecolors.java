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
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    @ManyToOne(targetEntity=Color.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "colors_colid", referencedColumnName = "colid")
    private Color color;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

  

}
