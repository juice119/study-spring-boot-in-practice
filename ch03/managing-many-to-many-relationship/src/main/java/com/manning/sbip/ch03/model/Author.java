package com.manning.sbip.ch03.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "AUTHOR")
@Table(name = "AUTHORS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bio;
    @ManyToMany
    @JoinTable(name = "authors_courses", joinColumns = {
        @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Course> courses = new HashSet<>();

    public Author() {
    }

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getBio() {
        return bio;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Author{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", bio='" + bio + '\'' +
            '}';
    }
}
