package com.cosmink.models.UserGroup;

import com.cosmink.models.BaseEntity;
import com.cosmink.models.GroupDetails.GroupDetails;
import com.cosmink.models.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "UserGroup.findById", query = "SELECT ug FROM UserGroup ug WHERE ug.id = :id")

})
public class UserGroup extends BaseEntity{

    /*private List<User> users = new ArrayList<User>();

    //FIXME: correggere relazione many to many
    @ManyToMany(mappedBy = "userGroups")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/
    @Embedded private GroupDetails groupDetails;


    public GroupDetails getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(GroupDetails groupDetails) {
        this.groupDetails = groupDetails;
    }

    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "userGroups")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
        user.getUserGroups().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.getUserGroups().remove(this);
    }
}
