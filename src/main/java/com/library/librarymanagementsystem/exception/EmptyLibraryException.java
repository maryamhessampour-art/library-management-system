package com.library.librarymanagementsystem.exception;

/**
 * Exception thrown when an operation is performed
 * on an empty library.
 */
public class EmptyLibraryException extends RuntimeException {

    public EmptyLibraryException(String message){
        super(message);
    }

}
