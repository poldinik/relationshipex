package com.cosmink.models.User;

import com.cosmink.models.Authority.Authority;
import com.cosmink.models.BaseEntity;
import com.cosmink.models.UserCredentials.UserCredentials;
import com.cosmink.models.UserGroup.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")

})
public class User extends BaseEntity {

    private String username;
    private String firstname;
    private String lastname;
    private Date joinDate;


    @Embedded private UserCredentials userCredentials;

    //element collections vanno sui metodi sennò non risolve la dipendenza, dà errore se la notazione viene messa direttamente sull'attributo

    private Set<Authority> authorities;

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    @XmlTransient
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @XmlTransient
    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

   /* private List<UserGroup> userGroups = new ArrayList<UserGroup>();

    @ManyToMany(cascade = CascadeType.ALL)
    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }*/

    Set<UserGroup> userGroups = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name="UserGroupMembership",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="GROUP_ID", referencedColumnName="id"))
    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }


}
