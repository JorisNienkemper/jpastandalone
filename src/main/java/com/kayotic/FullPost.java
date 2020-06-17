package com.kayotic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FullPost {

    @Id
    private int id;
    private String title;

    public FullPost() {
    }
    public FullPost(int id, String title) {
        this.id=id;
        this.title=title;
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
