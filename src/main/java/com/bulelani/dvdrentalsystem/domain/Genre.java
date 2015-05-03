/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bulelani.dvdrentalsystem.domain;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bulelani
 */
@Entity
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date yearReleased;

    private Genre(){
        
    }
    
    public Genre(Builder builder){
        title = builder.title;
        yearReleased = builder.yearReleased;
    }
    public static class Builder{
        private String title;
        private Date yearReleased;
       
        public Builder(String title){
            this.title = title;
        }
        
        public Builder yearReleased(Date value){
            this.yearReleased = value;
            return this;
        }
        public Builder copy(Genre value){
            this.title = value.getTitle();
            this.yearReleased = value.getYearReleased();
            return this;
        }
        
        public Genre build(){
            return new Genre(this);
        }
    }

    public Date getYearReleased() {
        return yearReleased;
    }
    
    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bulelani.dvdrentalsystem.domain.Genre[ id=" + id + " ]";
    }
    
}
