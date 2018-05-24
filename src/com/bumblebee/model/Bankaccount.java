/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "bankaccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankaccount.findAll", query = "SELECT b FROM Bankaccount b")
    , @NamedQuery(name = "Bankaccount.findByBankid", query = "SELECT b FROM Bankaccount b WHERE b.bankid = :bankid")
    , @NamedQuery(name = "Bankaccount.findByFirstname", query = "SELECT b FROM Bankaccount b WHERE b.firstname = :firstname")
    , @NamedQuery(name = "Bankaccount.findByLastname", query = "SELECT b FROM Bankaccount b WHERE b.lastname = :lastname")
    , @NamedQuery(name = "Bankaccount.findByIban", query = "SELECT b FROM Bankaccount b WHERE b.iban = :iban")
    , @NamedQuery(name = "Bankaccount.findByBic", query = "SELECT b FROM Bankaccount b WHERE b.bic = :bic")
    , @NamedQuery(name = "Bankaccount.findByBankname", query = "SELECT b FROM Bankaccount b WHERE b.bankname = :bankname")})
public class Bankaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bankid")
    private Integer bankid;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "iban")
    private String iban;
    @Column(name = "bic")
    private String bic;
    @Column(name = "bankname")
    private String bankname;

    
    @OneToOne(targetEntity=Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="customers_custid", referencedColumnName="custid")
    private Customer customer;

    public Bankaccount() {
    }

    public Bankaccount(Integer bankid) {
        this.bankid = bankid;
    }

    public Bankaccount(Integer bankid, String lastname, String iban) {
        this.bankid = bankid;
        this.lastname = lastname;
        this.iban = iban;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankid != null ? bankid.hashCode() : 0);
        return hash;
    }
}
