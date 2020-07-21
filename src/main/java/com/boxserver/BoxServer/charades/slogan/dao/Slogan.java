package com.boxserver.BoxServer.charades.slogan.dao;


import javax.persistence.*;

@Entity
public class Slogan {

    @Id
    @GeneratedValue
    private Long sloganId;

    private String slogan;

    public Slogan() {
    }

    public Slogan(Long sloganId, String slogan) {

        this.sloganId = sloganId;
        this.slogan = slogan;
    }

    public Long getSloganId() {
        return sloganId;
    }

    public String getSlogan() {
        return slogan;
    }
}
