package com.thimu.grapevine.ui;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A room library modelling a book entity
 *
 * @author Obed Ngigi
 * @version 03.07.2020
 */
@Entity(tableName = "BOOK_TABLE")
public class Book {

    // Attributes of the entity
    @PrimaryKey(autoGenerate = true)
    private int identification;
    private String ISBN;
    private String publisher;
    @NonNull
    private String title;
    private String author;
    private String genre;
    private String description;
    private String language;
    private int pages;

    /**
     * Create a book entity
     * @param ISBN the ISBN of the book
     * @param publisher the publisher of the book
     * @param title the title of the book
     * @param author the author(s) of the book
     * @param genre the genre of the book
     * @param description the description of the book
     * @param language the language of the book
     * @param pages the number of pages of the book
     */
    public Book(String ISBN, String publisher, String title, String author, String genre, String description, String language, int pages) {
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.language = language;
        this.pages = pages;
    }

    /**
     * Set the ID of the book
     * @param identification the ID of the book
     */
    public void setIdentification(int identification) {
        this.identification = identification;
    }

    /**
     * Return the ID of the book
     * @return the ID of the book
     */
    public int getIdentification() {
        return identification;
    }

    /**
     * Return the ISBN of the book
     * @return the ISBN of the book
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Return the publisher of the book
     * @return the publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Return the title of the book
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the author(s) of the book
     * @return the author(s) of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Return the genre of the book
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Return the description of the book
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the language of the book
     * @return the language of the book
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Return the number of pages of the book
     * @return the number of pages of the book
     */
    public int getPages() {
        return pages;
    }
}
