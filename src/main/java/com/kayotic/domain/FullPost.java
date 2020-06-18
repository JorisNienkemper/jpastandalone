package com.kayotic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FullPost {

    @Id
    private int id;
    private String title;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public FullPost() {
    }
    public FullPost(int id, String title) {
        this.id=id;
        this.title=title;
    }

    public FullPost(int id, String title,Category category) {
        this.id=id;
        this.title=title;
        this.category = category;
    }

    @Override
    public String toString() {
        return "FullPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title=title;
    }
}
