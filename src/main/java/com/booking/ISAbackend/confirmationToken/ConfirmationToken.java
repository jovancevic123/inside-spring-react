package com.booking.ISAbackend.confirmationToken;

import com.booking.ISAbackend.model.MyUser;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
public class ConfirmationToken {
    // expiration time in minutes
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = MyUser.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(nullable = true, name = "my_user_id")
    private MyUser user;

    private Date expiryDate;

    public ConfirmationToken() {
        expiryDate = calculateExpiryDate();
    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, ConfirmationToken.EXPIRATION);
        return new Date(cal.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
