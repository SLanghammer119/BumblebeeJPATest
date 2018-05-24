/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teilnehmer2
 */
@Entity
@Table(name = "coupons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupons.findAll", query = "SELECT c FROM Coupons c")
    , @NamedQuery(name = "Coupons.findByCoupid", query = "SELECT c FROM Coupons c WHERE c.coupid = :coupid")
    , @NamedQuery(name = "Coupons.findByCouponno", query = "SELECT c FROM Coupons c WHERE c.couponno = :couponno")
    , @NamedQuery(name = "Coupons.findByOrigvalue", query = "SELECT c FROM Coupons c WHERE c.origvalue = :origvalue")
    , @NamedQuery(name = "Coupons.findByCurvalue", query = "SELECT c FROM Coupons c WHERE c.curvalue = :curvalue")
    , @NamedQuery(name = "Coupons.findByCoupondate", query = "SELECT c FROM Coupons c WHERE c.coupondate = :coupondate")})
public class Coupons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupid")
    private Integer coupid;
    @Column(name = "couponno")
    private String couponno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "origvalue")
    private BigDecimal origvalue;
    @Column(name = "curvalue")
    private BigDecimal curvalue;
    @Column(name = "coupondate")
    @Temporal(TemporalType.DATE)
    private Date coupondate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couponsCoupid")
    private Collection<Orders> ordersCollection;

    public Coupons() {
    }

    public Coupons(Integer coupid) {
        this.coupid = coupid;
    }

    public Integer getCoupid() {
        return coupid;
    }

    public void setCoupid(Integer coupid) {
        this.coupid = coupid;
    }

    public String getCouponno() {
        return couponno;
    }

    public void setCouponno(String couponno) {
        this.couponno = couponno;
    }

    public BigDecimal getOrigvalue() {
        return origvalue;
    }

    public void setOrigvalue(BigDecimal origvalue) {
        this.origvalue = origvalue;
    }

    public BigDecimal getCurvalue() {
        return curvalue;
    }

    public void setCurvalue(BigDecimal curvalue) {
        this.curvalue = curvalue;
    }

    public Date getCoupondate() {
        return coupondate;
    }

    public void setCoupondate(Date coupondate) {
        this.coupondate = coupondate;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
    
}
