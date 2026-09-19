package com.library.librarymanagementsystem.model;

import java.time.LocalDate ;
import lombok.Getter ;

/**
 * Represents a library item that can be borrowed.
 */
@Getter
public abstract class BaseBorrowableItem extends LibraryItem implements Borrowable {

    private boolean isBorrowed ;
    private LocalDate borrowDate ;
    private int totalBorrowCount ;

    /**
     * Creates a borrowable library item with the specified title.
     */
    public BaseBorrowableItem(String title){

        super(title);
        this.isBorrowed = false ;
        this.borrowDate = null ;
        this.totalBorrowCount = 0 ;
    }

    /**
     * Calculates the borrowing penalty for the item.
     */
    @Override
    public abstract double calculatePenalty() ;

    /**
     * Marks the item as borrowed and records
     * the borrowing date.
     */
    @Override
    public void borrowItem(){
        if(!isBorrowed){
            isBorrowed = true ;
            borrowDate = LocalDate.now() ;
            totalBorrowCount++ ;
        }
    }

    /**
     * Marks the item as returned and clears
     * the borrowing date.
     */
    @Override
    public void returnItem(){
        if(isBorrowed){
            isBorrowed = false ;
            borrowDate = null ;
        }
    }

    /**
     * Checks whether the item is available for borrowing.
     */
    @Override
    public boolean isAvailable(){
            return !isBorrowed;
    }
}
