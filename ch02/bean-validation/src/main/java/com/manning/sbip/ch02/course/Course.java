package com.manning.sbip.ch02.course;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Course {

    private long id;
    private String name;
    private String category;

    @Min(value = 1, message = "course 는 최소 1 rating 을 가지고 있어야 합니다.")
    @Max(value = 5, message = "course 는 최대 5 rating 을 가지고 있어야 합니다.")
    private int rating;
    private String description;

    public Course() {
    }

    public Course(long id, String name, String category, int rating, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
