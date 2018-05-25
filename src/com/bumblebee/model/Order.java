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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
    , @NamedQuery(name = "Order.findByOrderid", query = "SELECT o FROM Order o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Order.findByOrderno", query = "SELECT o FROM Order o WHERE o.orderno = :orderno")
    , @NamedQuery(name = "Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total")
    , @NamedQuery(name = "Order.findByShipping", query = "SELECT o FROM Order o WHERE o.shipping = :shipping")
    , @NamedQuery(name = "Order.findByOrderdate", query = "SELECT o FROM Order o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Order.findByCoupondiscount", query = "SELECT o FROM Order o WHERE o.coupondiscount = :coupondiscount")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderid")
    private Integer orderid;
    @Basic(optional = false)
    @Column(name = "orderno")
    private String orderno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "shipping")
    private BigDecimal shipping;
    @Column(name = "orderdate")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "coupondiscount")
    private BigDecimal coupondiscount;
    @Lob
    @Column(name = "confirmation")
    private byte[] confirmation;
    @Lob
    @Column(name = "invoice")
    private byte[] invoice;
    
    
    @OneToMany(targetEntity=Orderitems.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private List<Orderitems> orderitems;
    
    
    
    @ManyToOne(targetEntity=Coupon.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "coupons_coupid", referencedColumnName = "coupid")
    private Coupon coupon;
    
    
    @ManyToOne(targetEntity=Customer.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderid) {
        this.orderid = orderid;
    }

    public Order(Integer orderid, String orderno) {
        this.orderid = orderid;
        this.orderno = orderno;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public BigDecimal getCoupondiscount() {
        return coupondiscount;
    }

    public void setCoupondiscount(BigDecimal coupondiscount) {
        this.coupondiscount = coupondiscount;
    }

    public byte[] getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(byte[] confirmation) {
        this.confirmation = confirmation;
    }

    public byte[] getInvoice() {
        return invoice;
    }

    public void setInvoice(byte[] invoice) {
        this.invoice = invoice;
    }

    public List<Orderitems> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitems> orderitems) {
        this.orderitems = orderitems;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
