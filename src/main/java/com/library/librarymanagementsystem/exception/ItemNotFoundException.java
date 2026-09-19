package com.library.librarymanagementsystem.exception;

/**
 * Exception thrown when the requested
 * library item cannot be found.
 */
public class ItemNotFoundException extends  RuntimeException {

    /**
     * Creates a new ItemNotFoundException
     */
    public ItemNotFoundException(String message){
        super(message);
    }

}
