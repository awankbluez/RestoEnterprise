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
   @NamedQuery(name = "Masterresto.findAll", query = "SELECT m FROM Masterresto m"),
   @NamedQuery(name = "Masterresto.findByRestoid", query = "SELECT m FROM Masterresto m WHERE m.restoid = :restoid"),
   @NamedQuery(name = "Masterresto.findByName", query = "SELECT m FROM Masterresto m WHERE m.name = :name"),
   @NamedQuery(name = "Masterresto.findByAddress", query = "SELECT m FROM Masterresto m WHERE m.address = :address"),
   @NamedQuery(name = "Masterresto.findByLocation", query = "SELECT m FROM Masterresto m WHERE m.location = :location"),
   @NamedQuery(name = "Masterresto.findByCode", query = "SELECT m FROM Masterresto m WHERE m.code = :code"),
   @NamedQuery(name = "Masterresto.findByEmail", query = "SELECT m FROM Masterresto m WHERE m.email = :email"),
   @NamedQuery(name = "Masterresto.findByZipcode", query = "SELECT m FROM Masterresto m WHERE m.zipcode = :zipcode"),
   @NamedQuery(name = "Masterresto.findByPhone", query = "SELECT m FROM Masterresto m WHERE m.phone = :phone"),
   @NamedQuery(name = "Masterresto.findByFax", query = "SELECT m FROM Masterresto m WHERE m.fax = :fax"),
   @NamedQuery(name = "Masterresto.findByStatus", query = "SELECT m FROM Masterresto m WHERE m.status = :status"),
   @NamedQuery(name = "Masterresto.findByLatitude", query = "SELECT m FROM Masterresto m WHERE m.latitude = :latitude"),
   @NamedQuery(name = "Masterresto.findByLongitude", query = "SELECT m FROM Masterresto m WHERE m.longitude = :longitude")})
public class Masterresto implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer restoid;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 32)
   @Column(nullable = false, length = 32)
   private String name;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 64)
   @Column(nullable = false, length = 64)
   private String address;
   @Size(max = 128)
   @Column(length = 128)
   private String location;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 6)
   @Column(nullable = false, length = 6)
   private String code;
   // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 32)
   @Column(nullable = false, length = 32)
   private String email;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private int zipcode;
   // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 12)
   @Column(nullable = false, length = 12)
   private String phone;
   // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
   @Size(max = 32)
   @Column(length = 32)
   private String fax;
   @Basic(optional = false)
   @NotNull
   @Column(nullable = false)
   private boolean status;
   @Size(max = 16)
   @Column(length = 16)
   private String latitude;
   @Size(max = 16)
   @Column(length = 16)
   private String longitude;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "restoid")
   private List<Accessuserresto> accessuserrestoList;
   @JoinColumn(name = "cityid", referencedColumnName = "cityid")
   @ManyToOne
   private Mastercity cityid;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "restoid")
   private List<Masteruser> masteruserList;

   public Masterresto() {
   }

   public Masterresto(Integer restoid) {
      this.restoid = restoid;
   }

   public Masterresto(Integer restoid, String name, String address, String code, String email, int zipcode, String phone, boolean status) {
      this.restoid = restoid;
      this.name = name;
      this.address = address;
      this.code = code;
      this.email = email;
      this.zipcode = zipcode;
      this.phone = phone;
      this.status = status;
   }

   public Integer getRestoid() {
      return restoid;
   }

   public void setRestoid(Integer restoid) {
      this.restoid = restoid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getZipcode() {
      return zipcode;
   }

   public void setZipcode(int zipcode) {
      this.zipcode = zipcode;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getFax() {
      return fax;
   }

   public void setFax(String fax) {
      this.fax = fax;
   }

   public boolean getStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   public String getLatitude() {
      return latitude;
   }

   public void setLatitude(String latitude) {
      this.latitude = latitude;
   }

   public String getLongitude() {
      return longitude;
   }

   public void setLongitude(String longitude) {
      this.longitude = longitude;
   }

   @XmlTransient
   public List<Accessuserresto> getAccessuserrestoList() {
      return accessuserrestoList;
   }

   public void setAccessuserrestoList(List<Accessuserresto> accessuserrestoList) {
      this.accessuserrestoList = accessuserrestoList;
   }

   public Mastercity getCityid() {
      return cityid;
   }

   public void setCityid(Mastercity cityid) {
      this.cityid = cityid;
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
      hash += (restoid != null ? restoid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Masterresto)) {
         return false;
      }
      Masterresto other = (Masterresto) object;
      if ((this.restoid == null && other.restoid != null) || (this.restoid != null && !this.restoid.equals(other.restoid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Masterresto[ restoid=" + restoid + " ]";
   }

}
