package com.library.librarymanagementsystem.DTO;

import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object used to transfer Magazine information
 * between the client and the application.
 *
 * <p>This class contains the data required to create
 * or update a Magazine object.<p>
 */
@Getter
@Setter
public class MagazineDTO {

    private String title ;
    private int issueNumber ;

}
