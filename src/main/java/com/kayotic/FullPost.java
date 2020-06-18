package com.kayotic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FullPost {

    @Id
    private int id;
    private String title;
    @OneToOne
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
