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
@Table(name = "shoppingitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingitems.findAll", query = "SELECT s FROM Shoppingitems s")
    , @NamedQuery(name = "Shoppingitems.findByShopitemid", query = "SELECT s FROM Shoppingitems s WHERE s.shopitemid = :shopitemid")
    , @NamedQuery(name = "Shoppingitems.findByNumber", query = "SELECT s FROM Shoppingitems s WHERE s.number = :number")
    , @NamedQuery(name = "Shoppingitems.findByTotalLine", query = "SELECT s FROM Shoppingitems s WHERE s.totalLine = :totalLine")})
public class Shoppingitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shopitemid")
    private Integer shopitemid;
    @Column(name = "number")
    private Integer number;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalLine")
    private BigDecimal totalLine;
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    public Shoppingitems() {
    }

    public Shoppingitems(Integer shopitemid) {
        this.shopitemid = shopitemid;
    }

    public Integer getShopitemid() {
        return shopitemid;
    }

    public void setShopitemid(Integer shopitemid) {
        this.shopitemid = shopitemid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(BigDecimal totalLine) {
        this.totalLine = totalLine;
    }


    
}
