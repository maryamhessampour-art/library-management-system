package com.library.librarymanagementsystem.model;

import java.time.LocalDate;
import lombok.Getter ;
import lombok.Setter;


/**
 * Represents a general library item.
 */
public abstract class LibraryItem {

    @Getter
    private final Long id ;

    private static Long nextId = 1L ;

    @Getter
    @Setter
    private String title ;

    @Getter
    private final LocalDate addedDate;


    /**
     * Converts the item into a text format
     * for file storage.
     */
    @Override
    public abstract String toString();

    /**
     * Creates a library item with the specified title.
     */
    public LibraryItem(String title) {
        this.id = nextId;
        nextId++;
        this.title = title;
        this.addedDate = LocalDate.now();
    }
}
