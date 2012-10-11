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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author awank
 */
@Entity
@Table(catalog = "DB_RESTO", schema = "public")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Masterprovince.findAll", query = "SELECT m FROM Masterprovince m"),
   @NamedQuery(name = "Masterprovince.findByCode", query = "SELECT m FROM Masterprovince m WHERE m.code = :code"),
   @NamedQuery(name = "Masterprovince.findByName", query = "SELECT m FROM Masterprovince m WHERE m.name = :name"),
   @NamedQuery(name = "Masterprovince.findByProvinceid", query = "SELECT m FROM Masterprovince m WHERE m.provinceid = :provinceid"),
   @NamedQuery(name = "Masterprovince.findByDeleted", query = "SELECT m FROM Masterprovince m WHERE m.deleted = :deleted"),
   @NamedQuery(name = "Masterprovince.findByStatus", query = "SELECT m FROM Masterprovince m WHERE m.status = :status")})
public class Masterprovince implements Serializable {
   private static final long serialVersionUID = 1L;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 6)
   @Column(nullable = false, length = 6)
   private String code;
   @Size(max = 15)
   @Column(length = 15)
   private String name;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer provinceid;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean deleted;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean status;

   public Masterprovince() {
   }

   public Masterprovince(Integer provinceid) {
      this.provinceid = provinceid;
   }

   public Masterprovince(Integer provinceid, String code, boolean deleted, boolean status) {
      this.provinceid = provinceid;
      this.code = code;
      this.deleted = deleted;
      this.status = status;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getProvinceid() {
      return provinceid;
   }

   public void setProvinceid(Integer provinceid) {
      this.provinceid = provinceid;
   }

   public boolean getDeleted() {
      return deleted;
   }

   public void setDeleted(boolean deleted) {
      this.deleted = deleted;
   }

   public boolean getStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (provinceid != null ? provinceid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Masterprovince)) {
         return false;
      }
      Masterprovince other = (Masterprovince) object;
      if ((this.provinceid == null && other.provinceid != null) || (this.provinceid != null && !this.provinceid.equals(other.provinceid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Masterprovince[ provinceid=" + provinceid + " ]";
   }

}
