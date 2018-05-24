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
import javax.persistence.ManyToOne;
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
@Table(name = "creditcards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c")
    , @NamedQuery(name = "Creditcard.findByCredid", query = "SELECT c FROM Creditcard c WHERE c.credid = :credid")
    , @NamedQuery(name = "Creditcard.findByType", query = "SELECT c FROM Creditcard c WHERE c.type = :type")
    , @NamedQuery(name = "Creditcard.findByFirstname", query = "SELECT c FROM Creditcard c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "Creditcard.findByLastname", query = "SELECT c FROM Creditcard c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "Creditcard.findByCardno", query = "SELECT c FROM Creditcard c WHERE c.cardno = :cardno")
    , @NamedQuery(name = "Creditcard.findByValidity", query = "SELECT c FROM Creditcard c WHERE c.validity = :validity")
    , @NamedQuery(name = "Creditcard.findByControllno", query = "SELECT c FROM Creditcard c WHERE c.controllno = :controllno")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credid")
    private Integer credid;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "cardno")
    private String cardno;
    @Basic(optional = false)
    @Column(name = "validity")
    private String validity;
    @Basic(optional = false)
    @Column(name = "controllno")
    private String controllno;
    
    
    @OneToOne(targetEntity=Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="customers_custid", referencedColumnName="custid")
    private Customer customer;
    
    public Creditcard() {
    }

    public Creditcard(Integer credid) {
        this.credid = credid;
    }

    public Creditcard(Integer credid, int type, String lastname, String cardno, String validity, String controllno) {
        this.credid = credid;
        this.type = type;
        this.lastname = lastname;
        this.cardno = cardno;
        this.validity = validity;
        this.controllno = controllno;
    }

    public Integer getCredid() {
        return credid;
    }

    public void setCredid(Integer credid) {
        this.credid = credid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getControllno() {
        return controllno;
    }

    public void setControllno(String controllno) {
        this.controllno = controllno;
    }

  

}
