package com.library.librarymanagementsystem.builder;

import com.library.librarymanagementsystem.model.Book;

/**
 Builder class used to create Book objects step by step.
 This class follows the Builder design pattern to simplify
 the creation of Book instances.
 */

public class BookBuilder {

    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String isbn10;
    private int pageCount;
    private String genre;

    /**
     *Sets the title of the book.
     *@param title book title
     *@return current BookBuilder instance
     */
    public BookBuilder title(String title){
        this.title = title;
        return this;
    }


    /**
    *Sets the author of the book.
    *@param author book author
    *@return current BookBuilder instance
     */
    public BookBuilder author(String author){
        this.author = author ;
        return this;
    }


    /**
     *Sets the publisher of the book.
     *@param publisher book publisher
     *@return current BookBuilder instance
     */
    public BookBuilder publisher(String publisher){
        this.publisher = publisher ;
        return this ;
    }


    /**
    *Sets the publication year of the book.
    *@param publicationYear year of publication
    *@return current BookBuilder instance
     */
    public BookBuilder publicationYear(int publicationYear){
        this.publicationYear = publicationYear ;
        return this ;
    }



    /**
    *Sets the ISBN-10 of the book.
    *@param isbn10 book ISBN-10
    *@return current BookBuilder instance
     */
    public BookBuilder isbn10(String isbn10){
        this.isbn10 = isbn10 ;
        return this ;
    }


    /**
    *Sets the number of pages.
    *@param pageCount total number of pages
    *@return current BookBuilder instance
     */
    public BookBuilder pageCount(int pageCount){
        this.pageCount = pageCount ;
        return this ;
    }


    /**
    *Sets the genre of the book.
    *@param genre book genre
    *@return current BookBuilder instance
     */
    public BookBuilder genre(String genre){
        this.genre = genre ;
        return this ;
    }


    /**
    *Creates and returns a new Book object.
    *@return newly created Book instance
     */
    public Book build(){
        return new Book(title ,
                author ,
                publisher ,
                publicationYear,
                isbn10 ,
                pageCount,
                genre);
    }
}
