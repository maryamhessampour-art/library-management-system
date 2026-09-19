package com.library.librarymanagementsystem.DTO;

import com.library.librarymanagementsystem.enums.ConditionStatus;
import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object used to transfer ReferenceMaterial information
 * between the client and the application.
 *
 * <p>This class contains the data required to create
 * or update a ReferenceMaterial object.<p>
 */
@Getter
@Setter
public class ReferenceMaterialDTO {

    private String title ;
    private String collectionName;
    private ConditionStatus conditionStatus;
    private boolean requiresLibrarianAssistance;

}
