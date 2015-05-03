/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bulelani
 */
@Entity
public class Subscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double monthlyFees;

    private Subscription(){
        
    }
    
    public Subscription(Builder builder){
        name = builder.name;
        monthlyFees = builder.monthlyFees;
    }
    
    public static class Builder{
        private String name;
        private double monthlyFees;
        
        public Builder(String name){
            this.name = name;
        }
        
        public Builder monthlyFees(double value){
            this.monthlyFees = value;
            return this;
        }
        
        public Builder copy(Subscription value){
            this.name = value.getName();
            this.monthlyFees = value.getMonthlyFees();
            return this;
        }
        
        public Subscription build(){
            return new Subscription(this);
        }
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFees() {
        return monthlyFees;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bulelani.dvdrentalsystem.domain.Subscription[ id=" + id + " ]";
    }
    
}
