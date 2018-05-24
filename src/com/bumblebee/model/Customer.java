/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
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
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustid", query = "SELECT c FROM Customer c WHERE c.custid = :custid")
    , @NamedQuery(name = "Customer.findByCustomerno", query = "SELECT c FROM Customer c WHERE c.customerno = :customerno")
    , @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "Customer.findByStreet", query = "SELECT c FROM Customer c WHERE c.street = :street")
    , @NamedQuery(name = "Customer.findByHouseno", query = "SELECT c FROM Customer c WHERE c.houseno = :houseno")
    , @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode")
    , @NamedQuery(name = "Customer.findByTown", query = "SELECT c FROM Customer c WHERE c.town = :town")
    , @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")
    , @NamedQuery(name = "Customer.findByCategory", query = "SELECT c FROM Customer c WHERE c.category = :category")})

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "custid")
    private Integer custid;
    @Basic(optional = false)
    @Column(name = "customerno")
    private String customerno;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "houseno")
    private String houseno;
    @Basic(optional = false)
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @Column(name = "town")
    private String town;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    
    @OneToMany(targetEntity=Deliveryadresses.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    private List<Deliveryadresses> deliveryadresses;
    
    
    @OneToOne(targetEntity=Bankaccount.class, mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bankaccount bankaccount;
    
    
    @OneToOne(targetEntity=Creditcard.class, mappedBy="customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Creditcard creditcard;
    
    
    @OneToOne(targetEntity=Shoppingcart.class, mappedBy="customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Shoppingcart shoppingcart;
    
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customersCustid")
//    private Creditcard creditcard;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
//    private List<Orders> orders;

    public Customer() {
    }

    public Customer(Integer custid) {
        this.custid = custid;
    }

    public Customer(Integer custid, String customerno, String lastname, String street, String houseno, String postcode, String town, String email, String password, String category) {
        this.custid = custid;
        this.customerno = customerno;
        this.lastname = lastname;
        this.street = street;
        this.houseno = houseno;
        this.postcode = postcode;
        this.town = town;
        this.email = email;
        this.password = password;
        this.category = category;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    @XmlTransient
//    public Collection<Shoppingcarts> getShoppingcartsCollection() {
//        return shoppingcartsCollection;
//    }
//
//    public void setShoppingcartsCollection(Collection<Shoppingcarts> shoppingcartsCollection) {
//        this.shoppingcartsCollection = shoppingcartsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Deliveryadresses> getDeliveryadressesCollection() {
//        return deliveryadressesCollection;
//    }
//
//    public void setDeliveryadressesCollection(Collection<Deliveryadresses> deliveryadressesCollection) {
//        this.deliveryadressesCollection = deliveryadressesCollection;
//    }
//
//    @XmlTransient
//    public Collection<Bankaccounts> getBankaccountsCollection() {
//        return bankaccountsCollection;
//    }
//
//    public void setBankaccountsCollection(Collection<Bankaccounts> bankaccountsCollection) {
//        this.bankaccountsCollection = bankaccountsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Creditcards> getCreditcardsCollection() {
//        return creditcardsCollection;
//    }
//
//    public void setCreditcardsCollection(Collection<Creditcards> creditcardsCollection) {
//        this.creditcardsCollection = creditcardsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Orders> getOrdersCollection() {
//        return ordersCollection;
//    }
//
//    public void setOrdersCollection(Collection<Orders> ordersCollection) {
//        this.ordersCollection = ordersCollection;
//    }
//    
}
