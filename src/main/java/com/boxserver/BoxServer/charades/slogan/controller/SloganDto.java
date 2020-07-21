package com.boxserver.BoxServer.charades.slogan.controller;

public class SloganDto {

    private Long id;
    private String slogan;

    public SloganDto(Long id, String slogan) {
        this.id = id;
        this.slogan = slogan;
    }

    public Long getId() {
        return id;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}