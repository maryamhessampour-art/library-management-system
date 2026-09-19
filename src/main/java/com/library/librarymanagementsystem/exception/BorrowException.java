package com.library.librarymanagementsystem.exception;

/**
 * Exception thrown when a borrowing or returning
 * operation cannot be completed.
 */
public class BorrowException extends RuntimeException {

    public BorrowException (String message){
        super(message);
    }
}
