package com.library.librarymanagementsystem.model;

import com.library.librarymanagementsystem.enums.ConditionStatus;
import lombok.Getter;

/**
 * Represents a reference material in the library.
 */
@Getter
public class ReferenceMaterial extends LibraryItem {

    private final String collectionName;
    private final ConditionStatus conditionStatus;
    private final boolean requiresLibrarianAssistance;

    /**
     * Creates a new reference material.
     */
    public ReferenceMaterial(String title, String collectionName, ConditionStatus conditionStatus, boolean requiresLibrarianAssistance) {
        super(title);
        this.collectionName = collectionName;
        this.conditionStatus = conditionStatus;
        this.requiresLibrarianAssistance = requiresLibrarianAssistance;
    }


    /**
     * Converts the reference material information
     * into a text format for file storage.
     */
    @Override
    public String toString(){
        return "REFERENCE," +
                getTitle() + "," +
                getCollectionName() + "," +
                getConditionStatus() + "," +
                isRequiresLibrarianAssistance() ;
    }
}
