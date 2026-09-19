package com.library.librarymanagementsystem.DTO;

import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object used to transfer book information
 * between the client and the application.
 *
 * <p>This class contains the data required to create
 * or update a Book object.<p>
 */
@Getter
@Setter
public class BookDTO {

    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String isbn10;
    private int pageCount;
    private String genre;

}
