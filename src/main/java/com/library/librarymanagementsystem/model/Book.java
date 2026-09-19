package com.library.librarymanagementsystem.model;

import lombok.Getter ;
import lombok.Setter ;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a book that can be borrowed
 * from the library.
 */
@Getter
public class Book extends BaseBorrowableItem {

    private final String author ;

    private final String publisher ;

    private final int publicationYear ;

    private final String isbn10 ;

    private final int pageCount ;

    private static final int MAX_BORROW_DAYS = 14;

    private static final double DAILY_PENALTY = 2.0;

    @Setter
    private String genre ;

    public Book(String title , String author , String publisher, int publicationYear , String isbn10 , int pageCount , String genre ){
        super(title);
        this.author = author ;
        this.publisher = publisher;
        this.publicationYear = publicationYear ;

        if (!isValidIsbn10(isbn10)) {
            throw new IllegalArgumentException("Invalid ISBN-10.");
        }


        this.isbn10 = isbn10 ;
        this.pageCount = pageCount;
        this.genre = genre ;
    }

    /**
     * Validates the ISBN-10 format.
     */
    private boolean isValidIsbn10(String isbn10) {

        if (isbn10 == null) {
            return false;
        }

        if (isbn10.length() != 10) {
            return false;
        }

        for (int i = 0; i < isbn10.length(); i++) {

            if (!Character.isDigit(isbn10.charAt(i))) {
                return false;
            }

        }

        return true;
    }


    /**
     * Calculates the overdue borrowing penalty.
     */
    @Override
    public double calculatePenalty() {

        if (getBorrowDate() == null) {
            throw new RuntimeException("This item has not been borrowed.");
        }

        long daysBorrowed = ChronoUnit.DAYS.between(getBorrowDate(), LocalDate.now());

        if(daysBorrowed <= MAX_BORROW_DAYS) {
            return 0;
        }

        long overdueDays  = daysBorrowed - MAX_BORROW_DAYS ;
        return overdueDays * DAILY_PENALTY;
    }


    /**
     * Converts the book information into
     * a text format for file storage.
     */
    @Override
    public String toString(){
        return "BOOK ," +
                getId() + "," +
                getTitle() + "," +
                getAuthor() + "," +
                getPublisher() + "," +
                getPublicationYear() + "," +
                getIsbn10() + "," +
                getPageCount() + "," +
                getGenre() ;
    }
}
