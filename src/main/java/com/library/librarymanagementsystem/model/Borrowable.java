package com.library.librarymanagementsystem.model;

/**
 * Defines the operations that every
 * borrowable library item must implement.
 */
public interface Borrowable {

    /**
     * Borrows the library item.
     */
    void borrowItem();

    /**
     * Returns the borrowed item.
     */
    void returnItem();

    /**
     * Calculates the borrowing penalty.
     */
    double calculatePenalty();

    /**
     * Checks whether the item is available.
     */
    boolean isAvailable() ;

}