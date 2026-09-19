package com.library.librarymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Handles application exceptions and returns
 * appropriate HTTP responses to the client.
 *
 * <p>This class centralizes exception handling
 * for all REST controllers.</p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

   /**
   * Handles EmptyLibraryException.
   */
    @ExceptionHandler(EmptyLibraryException.class)
    public ResponseEntity<String> handleEmptyLibrary(EmptyLibraryException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }


    /**
     * Handles ItemNotFoundException.
     */
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFound(ItemNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    /**
     * Handles DuplicateItemException.
     */
    @ExceptionHandler(DuplicateItemException.class)
    public ResponseEntity<String> handleDuplicateItem(DuplicateItemException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    /**
     * Handles BorrowException.
     */
    @ExceptionHandler(BorrowException.class)
    public ResponseEntity<String> handleBorrow(BorrowException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    /**
     * Handles IllegalArgumentException.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
