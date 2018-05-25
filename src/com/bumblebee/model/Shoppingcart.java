/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "shoppingcarts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s")
    , @NamedQuery(name = "Shoppingcart.findByShopid", query = "SELECT s FROM Shoppingcart s WHERE s.shopid = :shopid")
    , @NamedQuery(name = "Shoppingcart.findByShopcardno", query = "SELECT s FROM Shoppingcart s WHERE s.shopcardno = :shopcardno")
    , @NamedQuery(name = "Shoppingcart.findByTotal", query = "SELECT s FROM Shoppingcart s WHERE s.total = :total")
    , @NamedQuery(name = "Shoppingcart.findByShipping", query = "SELECT s FROM Shoppingcart s WHERE s.shipping = :shipping")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shopid")
    private Integer shopid;
    @Basic(optional = false)
    @Column(name = "shopcardno")
    private int shopcardno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "shipping")
    private Double shipping;
    
    @OneToOne(targetEntity=Customer.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    private Customer customer;
    
    
    @OneToMany(targetEntity=Shoppingitems.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="shoppingcarts_shopid", referencedColumnName="shopid")
    private List<Shoppingitems> shoppingitems;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer shopid) {
        this.shopid = shopid;
    }

    public Shoppingcart(Integer shopid, int shopcardno) {
        this.shopid = shopid;
        this.shopcardno = shopcardno;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public int getShopcardno() {
        return shopcardno;
    }

    public void setShopcardno(int shopcardno) {
        this.shopcardno = shopcardno;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Shoppingitems> getShoppingitems() {
        return shoppingitems;
    }

    public void setShoppingitems(List<Shoppingitems> shoppingitems) {
        this.shoppingitems = shoppingitems;
    }
    
    

   


    
}
