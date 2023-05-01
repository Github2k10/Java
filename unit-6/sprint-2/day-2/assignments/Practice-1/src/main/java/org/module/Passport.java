package org.module;

import javax.persistence.*;

//@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
    private String p_no;

    @OneToOne(mappedBy = "passport")
    private User user;

    public Passport(){}

    public Passport(String p_no, User user) {
        this.p_no = p_no;
        this.user = user;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getP_no() {
        return p_no;
    }

    public void setP_no(String p_no) {
        this.p_no = p_no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "pid=" + pid +
                ", p_no='" + p_no + '\'' +
                ", user=" + user +
                '}';
    }
}
