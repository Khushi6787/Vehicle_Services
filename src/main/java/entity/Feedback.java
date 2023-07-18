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
@Table(name = "feedback")
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFeedbackIDPK", query = "SELECT f FROM Feedback f WHERE f.feedbackIDPK = :feedbackIDPK"),
    @NamedQuery(name = "Feedback.findByComment", query = "SELECT f FROM Feedback f WHERE f.comment = :comment"),
    @NamedQuery(name = "Feedback.findByUsername", query = "SELECT f FROM Feedback f WHERE f.username = :username"),
    @NamedQuery(name = "Feedback.findByMechanicIDFK", query = "SELECT f FROM Feedback f WHERE f.mechanicIDFK = :mechanicIDFK"),
    @NamedQuery(name = "Feedback.findByMechanicname", query = "SELECT f FROM Feedback f WHERE f.mechanicname = :mechanicname")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "feedbackIDPK")
    private Integer feedbackIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mechanicIDFK")
    private int mechanicIDFK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mechanicname")
    private String mechanicname;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK")
    @ManyToOne(optional = false)
    private User userIDFK;

    public Feedback() {
    }

    public Feedback(Integer feedbackIDPK) {
        this.feedbackIDPK = feedbackIDPK;
    }

    public Feedback(Integer feedbackIDPK, String comment, String username, int mechanicIDFK, String mechanicname) {
        this.feedbackIDPK = feedbackIDPK;
        this.comment = comment;
        this.username = username;
        this.mechanicIDFK = mechanicIDFK;
        this.mechanicname = mechanicname;
    }

    public Integer getFeedbackIDPK() {
        return feedbackIDPK;
    }

    public void setFeedbackIDPK(Integer feedbackIDPK) {
        this.feedbackIDPK = feedbackIDPK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(int mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
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
        hash += (feedbackIDPK != null ? feedbackIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackIDPK == null && other.feedbackIDPK != null) || (this.feedbackIDPK != null && !this.feedbackIDPK.equals(other.feedbackIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Feedback[ feedbackIDPK=" + feedbackIDPK + " ]";
    }
    
}
