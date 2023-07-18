/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author KHUSHI
 */
@Entity
@Table(name = "auth")
@NamedQueries({
    @NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a"),
    @NamedQuery(name = "Auth.findByAuthIDPK", query = "SELECT a FROM Auth a WHERE a.authIDPK = :authIDPK"),
    @NamedQuery(name = "Auth.findByUsername", query = "SELECT a FROM Auth a WHERE a.username = :username"),
    @NamedQuery(name = "Auth.findByEmail", query = "SELECT a FROM Auth a WHERE a.email = :email"),
    @NamedQuery(name = "Auth.findByPassword", query = "SELECT a FROM Auth a WHERE a.password = :password"),
    @NamedQuery(name = "Auth.findByUsertype", query = "SELECT a FROM Auth a WHERE a.usertype = :usertype")})
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authIDPK")
    private Integer authIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "usertype")
    private String usertype;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK")
    @ManyToOne(optional = false)
    private User userIDFK;

    public Auth() {
    }

    public Auth(Integer authIDPK) {
        this.authIDPK = authIDPK;
    }

    public Auth(Integer authIDPK, String username, String email, String password, String usertype) {
        this.authIDPK = authIDPK;
        this.username = username;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public Integer getAuthIDPK() {
        return authIDPK;
    }

    public void setAuthIDPK(Integer authIDPK) {
        this.authIDPK = authIDPK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authIDPK != null ? authIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) object;
        if ((this.authIDPK == null && other.authIDPK != null) || (this.authIDPK != null && !this.authIDPK.equals(other.authIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Auth[ authIDPK=" + authIDPK + " ]";
    }
    
}
