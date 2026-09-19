package com.library.librarymanagementsystem.DTO;

import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object used to receive updated information
 * for an existing library item.
 *
 * <p>This class contains the fields that can be modified
 * during an update operation.</p>
 */
@Getter
@Setter
public class UpdateItemRequest {

    private String title ;
    private String genre ;
}
