package com.example.eindopdrachtbackendmoesproduce.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "adverts")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "published")
    private boolean published;

    public Advert() {
    }

    public Advert(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
