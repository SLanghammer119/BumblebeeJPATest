/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "orderitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitems.findAll", query = "SELECT o FROM Orderitems o")
    , @NamedQuery(name = "Orderitems.findByOrditid", query = "SELECT o FROM Orderitems o WHERE o.orditid = :orditid")
    , @NamedQuery(name = "Orderitems.findByNumber", query = "SELECT o FROM Orderitems o WHERE o.number = :number")
    , @NamedQuery(name = "Orderitems.findByTotalline", query = "SELECT o FROM Orderitems o WHERE o.totalline = :totalline")})
public class Orderitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orditid")
    private Integer orditid;
    @Column(name = "number")
    private Integer number;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalline")
    private BigDecimal totalline;
    
    @ManyToOne(targetEntity=Article.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    @ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_orderid", referencedColumnName = "orderid")
    private Order order;

    public Orderitems() {
    }

    public Orderitems(Integer orditid) {
        this.orditid = orditid;
    }

    public Integer getOrditid() {
        return orditid;
    }

    public void setOrditid(Integer orditid) {
        this.orditid = orditid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalline() {
        return totalline;
    }

    public void setTotalline(BigDecimal totalline) {
        this.totalline = totalline;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

 
}
