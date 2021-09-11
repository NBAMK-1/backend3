package com.example.backend3.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    private String number;

    private String password;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name ="user")
    private Group theGroup;

    public Group getTheGroup() {
        return theGroup;
    }

    public void setTheGroup(Group theGroup) {
        this.theGroup = theGroup;
    }

    public User() {
    }
//
//    public User(long uid, String name, String number, String password) {
//        this.uid = uid;
//        this.name = name;
//        this.number = number;
//        this.password = password;
//    }

    public User(String name, String number, String password) {
        super();
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
