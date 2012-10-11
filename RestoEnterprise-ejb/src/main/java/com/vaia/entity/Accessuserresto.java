/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author awank
 */
@Entity
@Table(catalog = "DB_RESTO", schema = "public")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Accessuserresto.findAll", query = "SELECT a FROM Accessuserresto a"),
   @NamedQuery(name = "Accessuserresto.findByAccessuserrestoid", query = "SELECT a FROM Accessuserresto a WHERE a.accessuserrestoid = :accessuserrestoid")})
public class Accessuserresto implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer accessuserrestoid;
   @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
   @ManyToOne(optional = false)
   private Masteruser userid;
   @JoinColumn(name = "restoid", referencedColumnName = "restoid", nullable = false)
   @ManyToOne(optional = false)
   private Masterresto restoid;

   public Accessuserresto() {
   }

   public Accessuserresto(Integer accessuserrestoid) {
      this.accessuserrestoid = accessuserrestoid;
   }

   public Integer getAccessuserrestoid() {
      return accessuserrestoid;
   }

   public void setAccessuserrestoid(Integer accessuserrestoid) {
      this.accessuserrestoid = accessuserrestoid;
   }

   public Masteruser getUserid() {
      return userid;
   }

   public void setUserid(Masteruser userid) {
      this.userid = userid;
   }

   public Masterresto getRestoid() {
      return restoid;
   }

   public void setRestoid(Masterresto restoid) {
      this.restoid = restoid;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (accessuserrestoid != null ? accessuserrestoid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Accessuserresto)) {
         return false;
      }
      Accessuserresto other = (Accessuserresto) object;
      if ((this.accessuserrestoid == null && other.accessuserrestoid != null) || (this.accessuserrestoid != null && !this.accessuserrestoid.equals(other.accessuserrestoid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Accessuserresto[ accessuserrestoid=" + accessuserrestoid + " ]";
   }

}
