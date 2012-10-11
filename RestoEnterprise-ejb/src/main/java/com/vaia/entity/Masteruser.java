/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author awank
 */
@Entity
@Table(catalog = "DB_RESTO", schema = "public")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Masteruser.findAll", query = "SELECT m FROM Masteruser m"),
   @NamedQuery(name = "Masteruser.findByUserid", query = "SELECT m FROM Masteruser m WHERE m.userid = :userid"),
   @NamedQuery(name = "Masteruser.findByUsername", query = "SELECT m FROM Masteruser m WHERE m.username = :username"),
   @NamedQuery(name = "Masteruser.findByPassword", query = "SELECT m FROM Masteruser m WHERE m.password = :password"),
   @NamedQuery(name = "Masteruser.findByFirstname", query = "SELECT m FROM Masteruser m WHERE m.firstname = :firstname"),
   @NamedQuery(name = "Masteruser.findByMiddlename", query = "SELECT m FROM Masteruser m WHERE m.middlename = :middlename"),
   @NamedQuery(name = "Masteruser.findByLastname", query = "SELECT m FROM Masteruser m WHERE m.lastname = :lastname"),
   @NamedQuery(name = "Masteruser.findByEmail", query = "SELECT m FROM Masteruser m WHERE m.email = :email")})
public class Masteruser implements Serializable, HttpSessionBindingListener {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(nullable = false)
   private Integer userid;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(nullable = false, length = 2147483647)
   private String username;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(nullable = false, length = 2147483647)
   private String password;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(nullable = false, length = 2147483647)
   private String firstname;
   @Size(max = 2147483647)
   @Column(length = 2147483647)
   private String middlename;
   @Size(max = 2147483647)
   @Column(length = 2147483647)
   private String lastname;
   // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 2147483647)
   @Column(nullable = false, length = 2147483647)
   private String email;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
   private List<Accessuserresto> accessuserrestoList;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
   private List<Accessusermenu> accessusermenuList;
   @JoinColumn(name = "restoid", referencedColumnName = "restoid", nullable = false)
   @ManyToOne(optional = false)
   private Masterresto restoid;
   @JoinColumn(name = "positionid", referencedColumnName = "positionid", nullable = false)
   @ManyToOne(optional = false)
   private Masterposition positionid;
   // All logins.
   private static Map<Masteruser, HttpSession> logins = new HashMap<Masteruser, HttpSession>();

   public Masteruser() {
   }

   public Masteruser(Integer userid) {
      this.userid = userid;
   }

   public Masteruser(Integer userid, String username, String password, String firstname, String email) {
      this.userid = userid;
      this.username = username;
      this.password = password;
      this.firstname = firstname;
      this.email = email;
   }

   public Integer getUserid() {
      return userid;
   }

   public void setUserid(Integer userid) {
      this.userid = userid;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getMiddlename() {
      return middlename;
   }

   public void setMiddlename(String middlename) {
      this.middlename = middlename;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @XmlTransient
   public List<Accessuserresto> getAccessuserrestoList() {
      return accessuserrestoList;
   }

   public void setAccessuserrestoList(List<Accessuserresto> accessuserrestoList) {
      this.accessuserrestoList = accessuserrestoList;
   }

   @XmlTransient
   public List<Accessusermenu> getAccessusermenuList() {
      return accessusermenuList;
   }

   public void setAccessusermenuList(List<Accessusermenu> accessusermenuList) {
      this.accessusermenuList = accessusermenuList;
   }

   public Masterresto getRestoid() {
      return restoid;
   }

   public void setRestoid(Masterresto restoid) {
      this.restoid = restoid;
   }

   public Masterposition getPositionid() {
      return positionid;
   }

   public void setPositionid(Masterposition positionid) {
      this.positionid = positionid;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (userid != null ? userid.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Masteruser)) {
         return false;
      }
      Masteruser other = (Masteruser) object;
      if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.vaia.entity.Masteruser[ userid=" + userid + " ]";
   }

   @Override
   public void valueBound(HttpSessionBindingEvent event) {
      HttpSession session = logins.remove(this);
      if (session != null) {
         session.invalidate();
      }
      logins.put(this, event.getSession());
   }

   @Override
   public void valueUnbound(HttpSessionBindingEvent event) {
      logins.remove(this);
   }
}
