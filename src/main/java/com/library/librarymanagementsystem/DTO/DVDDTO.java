package com.library.librarymanagementsystem.DTO;

import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object used to transfer DVD information
 * between the client and the application.
 *
 * <p>This class contains the data required to create
 * or update DVD object.<p>
 */
@Getter
@Setter
public class DVDDTO {

    private String title ;
    private String director;
    private int durationInMinutes;

}
