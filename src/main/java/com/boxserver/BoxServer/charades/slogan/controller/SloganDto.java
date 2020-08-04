package com.boxserver.BoxServer.charades.slogan.controller;

import com.boxserver.BoxServer.charades.slogan.dao.SloganCategory;
import com.boxserver.BoxServer.charades.slogan.dao.SloganDifficulty;

public class SloganDto {

    private Long id;
    private String mainSlogan;
    private String secondSlogan;
    private SloganCategory category;
    private SloganDifficulty difficulty;

    public SloganDto() {
    }

    public SloganDto(Long id, String mainSlogan, String secondSlogan,
                     SloganCategory category, SloganDifficulty difficulty) {
        this.id = id;
        this.mainSlogan = mainSlogan;
        this.secondSlogan = secondSlogan;
        this.category = category;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public String getMainSlogan() {
        return mainSlogan;
    }

    public String getSecondSlogan() {
        return secondSlogan;
    }

    public SloganCategory getCategory() {
        return category;
    }

    public SloganDifficulty getDifficulty() {
        return difficulty;
    }
}