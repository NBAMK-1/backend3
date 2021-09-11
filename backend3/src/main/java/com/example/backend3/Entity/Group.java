package com.example.backend3.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gid;

    private String gName;

    @OneToMany(mappedBy = "theGroup")
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public Group() {
    }


    public Group(String gName) {
        this.gName = gName;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }



    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
