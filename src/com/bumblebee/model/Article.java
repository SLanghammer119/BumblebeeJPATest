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
    
    @Column(name = "price")
    private Double price;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    
    
    @OneToMany(targetEntity=Articledescriptions.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articledescriptions> articledescriptions;
    
    @OneToMany(targetEntity = Articlesizes.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlesizes> articlesizes;
    
    @OneToMany(targetEntity=Articlecolors.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlecolors> articlecolors;
    
    @OneToMany(targetEntity=Articlematerials.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlematerials> articlematerials;
    
    @OneToMany(targetEntity=Orderitems.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Orderitems> orderitems;
    
    @OneToMany(targetEntity=Shoppingitems.class, mappedBy="article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shoppingitems> shoppingitems;
    
    @ManyToOne(targetEntity=Care.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "care_careid", referencedColumnName = "careid")
    private Care care;
    
    @ManyToOne(targetEntity=Subcategory.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategories_subcatid", referencedColumnName = "subcatid")
    private Subcategory subcategory;

    public Article() {
    }

    public Article(Integer artid, String articleno, String name, Double price, byte[] photo, List<Articledescriptions> articledescriptions, List<Articlesizes> articlesizes, List<Articlecolors> articlecolors, List<Articlematerials> articlematerials, List<Orderitems> orderitems, List<Shoppingitems> shoppingitems, Care care, Subcategory subcategory) {
        this.artid = artid;
        this.articleno = articleno;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.articledescriptions = articledescriptions;
        this.articlesizes = articlesizes;
        this.articlecolors = articlecolors;
        this.articlematerials = articlematerials;
        this.orderitems = orderitems;
        this.shoppingitems = shoppingitems;
        this.care = care;
        this.subcategory = subcategory;
    }

    public Article(Integer artid, String articleno, String name, Double price, byte[] photo, List<Articledescriptions> articledescriptions, List<Articlesizes> articlesizes, List<Articlecolors> articlecolors, List<Articlematerials> articlematerials, Care care, Subcategory subcategory) {
        this.artid = artid;
        this.articleno = articleno;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.articledescriptions = articledescriptions;
        this.articlesizes = articlesizes;
        this.articlecolors = articlecolors;
        this.articlematerials = articlematerials;
        this.care = care;
        this.subcategory = subcategory;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Articledescriptions> getArticledescriptions() {
        return articledescriptions;
    }

    public void setArticledescriptions(List<Articledescriptions> articledescriptions) {
        this.articledescriptions = articledescriptions;
    }

    public List<Articlesizes> getArticlesizes() {
        return articlesizes;
    }

    public void setArticlesizes(List<Articlesizes> articlesizes) {
        this.articlesizes = articlesizes;
    }

    public List<Articlecolors> getArticlecolors() {
        return articlecolors;
    }

    public void setArticlecolors(List<Articlecolors> articlecolors) {
        this.articlecolors = articlecolors;
    }

    public List<Articlematerials> getArticlematerials() {
        return articlematerials;
    }

    public void setArticlematerials(List<Articlematerials> articlematerials) {
        this.articlematerials = articlematerials;
    }

    public List<Orderitems> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitems> orderitems) {
        this.orderitems = orderitems;
    }

    public List<Shoppingitems> getShoppingitems() {
        return shoppingitems;
    }

    public void setShoppingitems(List<Shoppingitems> shoppingitems) {
        this.shoppingitems = shoppingitems;
    }

    public Care getCare() {
        return care;
    }

    public void setCare(Care care) {
        this.care = care;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
    
}
