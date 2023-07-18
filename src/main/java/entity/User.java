/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author KHUSHI
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserIDPK", query = "SELECT u FROM User u WHERE u.userIDPK = :userIDPK"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByMobileno", query = "SELECT u FROM User u WHERE u.mobileno = :mobileno"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "User.findByUsertype", query = "SELECT u FROM User u WHERE u.usertype = :usertype")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userIDPK")
    private Integer userIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mobileno")
    private String mobileno;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIDFK")
    private Collection<Auth> authCollection;

    public User() {
    }

    public User(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public User(Integer userIDPK, String username, String address, String email, String mobileno, String password, String usertype) {
        this.userIDPK = userIDPK;
        this.username = username;
        this.address = address;
        this.email = email;
        this.mobileno = mobileno;
        this.password = password;
        this.usertype = usertype;
    }

    public Integer getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(Integer userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
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

    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Collection<Auth> getAuthCollection() {
        return authCollection;
    }

    public void setAuthCollection(Collection<Auth> authCollection) {
        this.authCollection = authCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIDPK != null ? userIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userIDPK == null && other.userIDPK != null) || (this.userIDPK != null && !this.userIDPK.equals(other.userIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ userIDPK=" + userIDPK + " ]";
    }
    
}
