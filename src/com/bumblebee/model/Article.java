/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a")
    , @NamedQuery(name = "Articles.findByArtid", query = "SELECT a FROM Articles a WHERE a.artid = :artid")
    , @NamedQuery(name = "Articles.findByArticleno", query = "SELECT a FROM Articles a WHERE a.articleno = :articleno")
    , @NamedQuery(name = "Articles.findByName", query = "SELECT a FROM Articles a WHERE a.name = :name")
    , @NamedQuery(name = "Articles.findByPrice", query = "SELECT a FROM Articles a WHERE a.price = :price")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Articledescriptions> articledescriptionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Articlesizes> articlesizesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Articlecolors> articlecolorsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Articlematerials> articlematerialsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Orderitems> orderitemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesArtid")
    private Collection<Shoppingitems> shoppingitemsCollection;
    @JoinColumn(name = "care_careid", referencedColumnName = "careid")
    @ManyToOne(optional = false)
    private Care careCareid;
    @JoinColumn(name = "subcategories_subid", referencedColumnName = "subcatid")
    @ManyToOne(optional = false)
    private Subcategories subcategoriesSubid;

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

    @XmlTransient
    public Collection<Articledescriptions> getArticledescriptionsCollection() {
        return articledescriptionsCollection;
    }

    public void setArticledescriptionsCollection(Collection<Articledescriptions> articledescriptionsCollection) {
        this.articledescriptionsCollection = articledescriptionsCollection;
    }

    @XmlTransient
    public Collection<Articlesizes> getArticlesizesCollection() {
        return articlesizesCollection;
    }

    public void setArticlesizesCollection(Collection<Articlesizes> articlesizesCollection) {
        this.articlesizesCollection = articlesizesCollection;
    }

    @XmlTransient
    public Collection<Articlecolors> getArticlecolorsCollection() {
        return articlecolorsCollection;
    }

    public void setArticlecolorsCollection(Collection<Articlecolors> articlecolorsCollection) {
        this.articlecolorsCollection = articlecolorsCollection;
    }

    @XmlTransient
    public Collection<Articlematerials> getArticlematerialsCollection() {
        return articlematerialsCollection;
    }

    public void setArticlematerialsCollection(Collection<Articlematerials> articlematerialsCollection) {
        this.articlematerialsCollection = articlematerialsCollection;
    }

    @XmlTransient
    public Collection<Orderitems> getOrderitemsCollection() {
        return orderitemsCollection;
    }

    public void setOrderitemsCollection(Collection<Orderitems> orderitemsCollection) {
        this.orderitemsCollection = orderitemsCollection;
    }

    @XmlTransient
    public Collection<Shoppingitems> getShoppingitemsCollection() {
        return shoppingitemsCollection;
    }

    public void setShoppingitemsCollection(Collection<Shoppingitems> shoppingitemsCollection) {
        this.shoppingitemsCollection = shoppingitemsCollection;
    }

    public Care getCareCareid() {
        return careCareid;
    }

    public void setCareCareid(Care careCareid) {
        this.careCareid = careCareid;
    }

    public Subcategories getSubcategoriesSubid() {
        return subcategoriesSubid;
    }

    public void setSubcategoriesSubid(Subcategories subcategoriesSubid) {
        this.subcategoriesSubid = subcategoriesSubid;
    }
    
}
