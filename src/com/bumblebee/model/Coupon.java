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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "coupons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c")
    , @NamedQuery(name = "Coupon.findByCoupid", query = "SELECT c FROM Coupon c WHERE c.coupid = :coupid")
    , @NamedQuery(name = "Coupon.findByCouponno", query = "SELECT c FROM Coupon c WHERE c.couponno = :couponno")
    , @NamedQuery(name = "Coupon.findByOrigvalue", query = "SELECT c FROM Coupon c WHERE c.origvalue = :origvalue")
    , @NamedQuery(name = "Coupon.findByCurvalue", query = "SELECT c FROM Coupon c WHERE c.curvalue = :curvalue")
    , @NamedQuery(name = "Coupon.findByCoupondate", query = "SELECT c FROM Coupon c WHERE c.coupondate = :coupondate")})
public class Coupon implements Serializable {

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
    
    
    @OneToMany(targetEntity=Order.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "coupon")
    private List<Order> orders;

    public Coupon() {
    }

    public Coupon(Integer coupid) {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

  
    
}
