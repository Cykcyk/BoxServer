package com.boxserver.BoxServer.charades.slogan.dao;


import javax.persistence.*;

@Entity
public class Slogan {

    public static final String D_ID = "id";
    public static final String D_SECOND_SLOGAN = "secondSlogan";
    public static final String D_CATEGORY = "category";
    public static final String D_DIFFICULTY = "difficulty";

    @Id
    @GeneratedValue
    private Long id;

    private String mainSlogan;
    private String secondSlogan;
    private SloganCategory category;
    private SloganDifficulty difficulty;

    public Slogan() {
    }

    public Slogan(Long id, String mainSlogan, String secondSlogan, SloganCategory category,
                  SloganDifficulty difficulty) {

        this.id = id;
        this.mainSlogan = mainSlogan;
        this.secondSlogan = secondSlogan;
        this.category = category;
        this.difficulty = difficulty;
    }

    public Slogan(Long id, String mainSlogan, SloganCategory category, SloganDifficulty difficulty) {
        this.id = id;
        this.mainSlogan = mainSlogan;
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