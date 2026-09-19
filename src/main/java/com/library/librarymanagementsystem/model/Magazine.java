package com.library.librarymanagementsystem.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.Getter ;

/**
 * Represents a magazine that can be borrowed
 * from the library.
 */
@Getter
public class Magazine extends BaseBorrowableItem {

    private final int issueNumber ;

    private LocalDate issueDate = null;

    private static final int MAX_BORROW_DAYS = 7 ;

    private static final double DAILY_PENALTY = 1.0 ;

    /**
     * Creates a new magazine with the specified information.
     */
    public Magazine(String title , int issueNumber){
        super(title) ;
        this.issueNumber = issueNumber ;
        this.issueDate = issueDate;
    }


    /**
     * Calculates the overdue borrowing penalty.
     */
    @Override
    public double calculatePenalty(){

        if(getBorrowDate() == null){
            throw new RuntimeException("This item has not been borrowed.");
        }

        Long daysBorrowed = ChronoUnit.DAYS.between(getBorrowDate() , LocalDate.now());

        if(daysBorrowed <= MAX_BORROW_DAYS){
            return 0 ;
        }

        long overdueDays  = daysBorrowed - MAX_BORROW_DAYS ;
        return overdueDays * DAILY_PENALTY;
    }


    /**
     * Converts the magazine information into
     * a text format for file storage.
     */
    @Override
    public String toString(){
        return "MAGAZINE," +
                getTitle() + "," +
                getIssueNumber() ;
    }

}
