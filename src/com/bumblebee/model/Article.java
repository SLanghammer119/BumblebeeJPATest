/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByArtid", query = "SELECT a FROM Article a WHERE a.artid = :artid")
    , @NamedQuery(name = "Article.findByArticleno", query = "SELECT a FROM Article a WHERE a.articleno = :articleno")
    , @NamedQuery(name = "Article.findByName", query = "SELECT a FROM Article a WHERE a.name = :name")
    , @NamedQuery(name = "Article.findByPrice", query = "SELECT a FROM Article a WHERE a.price = :price")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artid")
    private Integer artid;
    @Column(name = "articleno")
    private String articleno;
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
//    private Collection<Articledescriptions> articledescriptionsCollection;
    
    @OneToMany(targetEntity = Articlesizes.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlesizes> articlesizes;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
//    private Collection<Articlecolors> articlecolorsCollection;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
//    private Collection<Articlematerials> articlematerialsCollection;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
//    private Collection<Orderitems> orderitemsCollection;
    
    @OneToMany(targetEntity=Shoppingitems.class, mappedBy="articles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shoppingitems> shoppingitems;
    
    
//    @JoinColumn(name = "care_careid", referencedColumnName = "careid")
//    @ManyToOne(optional = false)
//    private Care careCareid;
    
    
    @ManyToOne(targetEntity=Subcategory.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_subcatid", referencedColumnName = "subcatid")
    private Subcategory subcategory;

    public Article() {
    }

    public Article(Integer artid) {
        this.artid = artid;
    }

    public Integer getArtid() {
        return artid;
    }

    public void setArtid(Integer artid) {
        this.artid = artid;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


//    public Care getCareCareid() {
//        return careCareid;
//    }
//
//    public void setCareCareid(Care careCareid) {
//        this.careCareid = careCareid;
//    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
    
}
