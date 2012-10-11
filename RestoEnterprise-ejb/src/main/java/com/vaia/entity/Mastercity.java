/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author awank
 */
@Entity
@Table(catalog = "DB_RESTO", schema = "public")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Mastercity.findAll", query = "SELECT m FROM Mastercity m"),
   @NamedQuery(name = "Mastercity.findByCode", query = "SELECT m FROM Mastercity m WHERE m.code = :code"),
   @NamedQuery(name = "Mastercity.findByName", query = "SELECT m FROM Mastercity m WHERE m.name = :name"),
   @NamedQuery(name = "Mastercity.findByCityid", query = "SELECT m FROM Mastercity m WHERE m.cityid = :cityid"),
   @NamedQuery(name = "Mastercity.findByDeleted", query = "SELECT m FROM Mastercity m WHERE m.deleted = :deleted"),
   @NamedQuery(name = "Mastercity.findByStatus", query = "SELECT m FROM Mastercity m WHERE m.status = :status")})
public class Mastercity implements Serializable {
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
   private Integer cityid;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean deleted;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean status;
   @OneToMany(mappedBy = "cityid")
   private List<Masterresto> masterrestoList;

   public Mastercity() {
   }

   public Mastercity(Integer cityid) {
      this.cityid = cityid;
   }

   public Mastercity(Integer cityid, String code, boolean deleted, boolean status) {
      this.cityid = cityid;
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

   public Integer getCityid() {
      return cityid;
   }

   public void setCityid(Integer cityid) {
      this.cityid = cityid;
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

   @XmlTransient
   public List<Masterresto> getMasterrestoList() {
      return masterrestoList;
   }

   public void setMasterrestoList(List<Masterresto> masterrestoList) {
      this.masterrestoList = masterrestoList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (cityid != null ? cityid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Mastercity)) {
         return false;
      }
      Mastercity other = (Mastercity) object;
      if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Mastercity[ cityid=" + cityid + " ]";
   }

}
