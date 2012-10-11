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
   @NamedQuery(name = "Accessusermenu.findAll", query = "SELECT a FROM Accessusermenu a"),
   @NamedQuery(name = "Accessusermenu.findByAccessusermenuid", query = "SELECT a FROM Accessusermenu a WHERE a.accessusermenuid = :accessusermenuid")})
public class Accessusermenu implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer accessusermenuid;
   @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
   @ManyToOne(optional = false)
   private Masteruser userid;
   @JoinColumn(name = "menuid", referencedColumnName = "menuid", nullable = false)
   @ManyToOne(optional = false)
   private Mastermenu menuid;

   public Accessusermenu() {
   }

   public Accessusermenu(Integer accessusermenuid) {
      this.accessusermenuid = accessusermenuid;
   }

   public Integer getAccessusermenuid() {
      return accessusermenuid;
   }

   public void setAccessusermenuid(Integer accessusermenuid) {
      this.accessusermenuid = accessusermenuid;
   }

   public Masteruser getUserid() {
      return userid;
   }

   public void setUserid(Masteruser userid) {
      this.userid = userid;
   }

   public Mastermenu getMenuid() {
      return menuid;
   }

   public void setMenuid(Mastermenu menuid) {
      this.menuid = menuid;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (accessusermenuid != null ? accessusermenuid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Accessusermenu)) {
         return false;
      }
      Accessusermenu other = (Accessusermenu) object;
      if ((this.accessusermenuid == null && other.accessusermenuid != null) || (this.accessusermenuid != null && !this.accessusermenuid.equals(other.accessusermenuid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Accessusermenu[ accessusermenuid=" + accessusermenuid + " ]";
   }

}
