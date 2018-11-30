package me.irdi.models;

import java.lang.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Library {

    @Id
    public ObjectId _id;

    public String title;
    public String genre;
    public String author;
    public int pages;

    // Constructors
    public Library(){}

    public Library(ObjectId _id, String title, String genre, String author, int pages) {
        this._id = _id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.pages = pages;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPages() { return pages; }
    public void setPages( int pages ) { this.pages = pages; }
}