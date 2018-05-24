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
 * @author Teilnehmer2
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orders.findByOrderno", query = "SELECT o FROM Orders o WHERE o.orderno = :orderno")
    , @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total")
    , @NamedQuery(name = "Orders.findByShipping", query = "SELECT o FROM Orders o WHERE o.shipping = :shipping")
    , @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orders.findByCoupondiscount", query = "SELECT o FROM Orders o WHERE o.coupondiscount = :coupondiscount")})
public class Orders implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordersOrderid")
    private Collection<Orderitems> orderitemsCollection;
    @JoinColumn(name = "coupons_coupid", referencedColumnName = "coupid")
    @ManyToOne(optional = false)
    private Coupons couponsCoupid;
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer customersCustid;

    public Orders() {
    }

    public Orders(Integer orderid) {
        this.orderid = orderid;
    }

    public Orders(Integer orderid, String orderno) {
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

    @XmlTransient
    public Collection<Orderitems> getOrderitemsCollection() {
        return orderitemsCollection;
    }

    public void setOrderitemsCollection(Collection<Orderitems> orderitemsCollection) {
        this.orderitemsCollection = orderitemsCollection;
    }

    public Coupons getCouponsCoupid() {
        return couponsCoupid;
    }

    public void setCouponsCoupid(Coupons couponsCoupid) {
        this.couponsCoupid = couponsCoupid;
    }

    public Customer getCustomersCustid() {
        return customersCustid;
    }

    public void setCustomersCustid(Customer customersCustid) {
        this.customersCustid = customersCustid;
    }
    
}
