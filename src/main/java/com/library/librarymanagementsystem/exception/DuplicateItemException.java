package com.library.librarymanagementsystem.exception;

/**
 * Exception thrown when an item with the same
 * unique information already exists.
 */
public class DuplicateItemException extends RuntimeException {

    public DuplicateItemException(String message){
        super(message);
    }

}
