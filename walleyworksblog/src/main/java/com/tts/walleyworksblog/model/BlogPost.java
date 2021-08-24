package com.tts.walleyworksblog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity                //extends the Java Class -- the BlogPost Class is a simple dataclass for Spring.
                                  // @Entity ensures that we have a table in our database
public class BlogPost {

    @Id                 // this generates the id for the id field -- the @GeneratedValue makes certain to generate a value for every instance of this class, otherwise programmer would be responsible
    @GeneratedValue(strategy = GenerationType.AUTO)    //  since @Id and @GeneratedValue are over the 'id' then they consider that the 'id' they are working with
                                             // if they were over the 'title' then they would be active on 'title' -- their placement is very important
    private Long id;
    private String title;
    private String author;
    private String blogEntry;

    // constructor
    public BlogPost(String title, String author, String blogEntry) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
    }

    // default constructor
    public BlogPost() {

    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    // toString()
    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", blogEntry='" + blogEntry + '\'' +
                '}';
    }

}
