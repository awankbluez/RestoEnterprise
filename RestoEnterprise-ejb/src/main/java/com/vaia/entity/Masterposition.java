/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
   @NamedQuery(name = "Masterposition.findAll", query = "SELECT m FROM Masterposition m"),
   @NamedQuery(name = "Masterposition.findByCode", query = "SELECT m FROM Masterposition m WHERE m.code = :code"),
   @NamedQuery(name = "Masterposition.findByName", query = "SELECT m FROM Masterposition m WHERE m.name = :name"),
   @NamedQuery(name = "Masterposition.findByPositionid", query = "SELECT m FROM Masterposition m WHERE m.positionid = :positionid"),
   @NamedQuery(name = "Masterposition.findByDeleted", query = "SELECT m FROM Masterposition m WHERE m.deleted = :deleted"),
   @NamedQuery(name = "Masterposition.findByStatus", query = "SELECT m FROM Masterposition m WHERE m.status = :status")})
public class Masterposition implements Serializable {
   private static final long serialVersionUID = 1L;
   @Basic(optional = false)
   @Column(nullable = false)
   private int code;
   @Size(max = 15)
   @Column(length = 15)
   private String name;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer positionid;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean deleted;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean status;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionid")
   private List<Masteruser> masteruserList;

   public Masterposition() {
   }

   public Masterposition(Integer positionid) {
      this.positionid = positionid;
   }

   public Masterposition(Integer positionid, int code, boolean deleted, boolean status) {
      this.positionid = positionid;
      this.code = code;
      this.deleted = deleted;
      this.status = status;
   }

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getPositionid() {
      return positionid;
   }

   public void setPositionid(Integer positionid) {
      this.positionid = positionid;
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
   public List<Masteruser> getMasteruserList() {
      return masteruserList;
   }

   public void setMasteruserList(List<Masteruser> masteruserList) {
      this.masteruserList = masteruserList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (positionid != null ? positionid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Masterposition)) {
         return false;
      }
      Masterposition other = (Masterposition) object;
      if ((this.positionid == null && other.positionid != null) || (this.positionid != null && !this.positionid.equals(other.positionid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Masterposition[ positionid=" + positionid + " ]";
   }

}
