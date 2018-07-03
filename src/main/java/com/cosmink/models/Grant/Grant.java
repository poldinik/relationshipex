package com.cosmink.models.Grant;

import com.cosmink.models.BaseEntity;
import com.cosmink.models.GrantDetails.GrantDetails;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Entity
public class Grant extends BaseEntity{

    @Embedded private GrantDetails grantDetails;
    private String token;

    public GrantDetails getGrantDetails() {
        return grantDetails;
    }

    public void setGrantDetails(GrantDetails grantDetails) {
        this.grantDetails = grantDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
