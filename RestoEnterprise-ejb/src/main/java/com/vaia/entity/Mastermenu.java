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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
   @NamedQuery(name = "Mastermenu.findAll", query = "SELECT m FROM Mastermenu m"),
   @NamedQuery(name = "Mastermenu.findByMenuid", query = "SELECT m FROM Mastermenu m WHERE m.menuid = :menuid"),
   @NamedQuery(name = "Mastermenu.findByName", query = "SELECT m FROM Mastermenu m WHERE m.name = :name"),
   @NamedQuery(name = "Mastermenu.findByAlias", query = "SELECT m FROM Mastermenu m WHERE m.alias = :alias"),
   @NamedQuery(name = "Mastermenu.findByOrdering", query = "SELECT m FROM Mastermenu m WHERE m.ordering = :ordering"),
   @NamedQuery(name = "Mastermenu.findByLevel", query = "SELECT m FROM Mastermenu m WHERE m.level = :level"),
   @NamedQuery(name = "Mastermenu.findByLink", query = "SELECT m FROM Mastermenu m WHERE m.link = :link"),
   @NamedQuery(name = "Mastermenu.findByDeleted", query = "SELECT m FROM Mastermenu m WHERE m.deleted = :deleted"),
   @NamedQuery(name = "Mastermenu.findByStatus", query = "SELECT m FROM Mastermenu m WHERE m.status = :status")})
public class Mastermenu implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer menuid;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 40)
   @Column(nullable = false, length = 40)
   private String name;
   @Size(max = 40)
   @Column(length = 40)
   private String alias;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private int ordering;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private int level;
   @Size(max = 40)
   @Column(length = 40)
   private String link;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean deleted;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean status;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuid")
   private List<Accessusermenu> accessusermenuList;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentmenuid")
   private List<Mastermenu> mastermenuList;
   @JoinColumn(name = "parentmenuid", referencedColumnName = "menuid", nullable = false)
   @ManyToOne(optional = false)
   private Mastermenu parentmenuid;

   public Mastermenu() {
   }

   public Mastermenu(Integer menuid) {
      this.menuid = menuid;
   }

   public Mastermenu(Integer menuid, String name, int ordering, int level, boolean deleted, boolean status) {
      this.menuid = menuid;
      this.name = name;
      this.ordering = ordering;
      this.level = level;
      this.deleted = deleted;
      this.status = status;
   }

   public Integer getMenuid() {
      return menuid;
   }

   public void setMenuid(Integer menuid) {
      this.menuid = menuid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAlias() {
      return alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public int getOrdering() {
      return ordering;
   }

   public void setOrdering(int ordering) {
      this.ordering = ordering;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public String getLink() {
      return link;
   }

   public void setLink(String link) {
      this.link = link;
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
   public List<Accessusermenu> getAccessusermenuList() {
      return accessusermenuList;
   }

   public void setAccessusermenuList(List<Accessusermenu> accessusermenuList) {
      this.accessusermenuList = accessusermenuList;
   }

   @XmlTransient
   public List<Mastermenu> getMastermenuList() {
      return mastermenuList;
   }

   public void setMastermenuList(List<Mastermenu> mastermenuList) {
      this.mastermenuList = mastermenuList;
   }

   public Mastermenu getParentmenuid() {
      return parentmenuid;
   }

   public void setParentmenuid(Mastermenu parentmenuid) {
      this.parentmenuid = parentmenuid;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (menuid != null ? menuid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Mastermenu)) {
         return false;
      }
      Mastermenu other = (Mastermenu) object;
      if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Mastermenu[ menuid=" + menuid + " ]";
   }

}
