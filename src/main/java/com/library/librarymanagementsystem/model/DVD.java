package com.library.librarymanagementsystem.model;

import lombok.Getter ;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * Represents a DVD that can be borrowed
 * from the library.
 */
@Getter
public class DVD extends BaseBorrowableItem {

    private final String director;

    private final int durationInMinutes;

    private static final int MAX_BORROW_DAYS = 3;

    private static final double DAILY_PENALTY = 3.0 ;


    /**
     * Creates a new DVD with the specified information.
     */
    public DVD(String title , String director , int durationInMinutes){
        super(title);
        this.director = director ;
        this.durationInMinutes = durationInMinutes ;
    }


    /**
     * Calculates the overdue borrowing penalty.
     */
    @Override
    public double calculatePenalty() {

        if(getBorrowDate() == null){
            throw new RuntimeException("This item has not been borrowed.");
        }

        long daysBorrowed = ChronoUnit.DAYS.between(getBorrowDate() , LocalDate.now());

        if(daysBorrowed <= MAX_BORROW_DAYS){
            return 0 ;
        }

        long overdueDays  = daysBorrowed - MAX_BORROW_DAYS ;
        return overdueDays * DAILY_PENALTY;
    }


    /**
     * Converts the DVD information into
     * a text format for file storage.
     */
    @Override
    public String toString(){
        return "DVD," +
                getTitle() + "," +
                getDirector() + "," +
                getDurationInMinutes();
    }
}
