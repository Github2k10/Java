package org.module;

import javax.persistence.*;

//@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String u_name;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    public User(){}

    public User(String u_name) {
        this.u_name = u_name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
