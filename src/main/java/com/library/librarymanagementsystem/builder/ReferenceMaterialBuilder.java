package com.library.librarymanagementsystem.builder;

import com.library.librarymanagementsystem.enums.ConditionStatus;
import com.library.librarymanagementsystem.model.ReferenceMaterial;


/**
 * Builder class used to create ReferenceMaterial objects step by step.
 * This class follows the Builder design pattern to simplify
 * the creation of ReferenceMaterial instances.
 */
public class ReferenceMaterialBuilder {

    private String title ;
    private String collectionName;
    private ConditionStatus conditionStatus;
    private boolean requiresLibrarianAssistance;


    /**
     * Sets the title of the reference material.
     * @param title reference material title
     * @return current ReferenceMaterialBuilder instance
     */
    public ReferenceMaterialBuilder title(String title){
        this.title = title ;
        return this ;
    }


    /**
     * Sets the collection name of the reference material.
     * @param collectionName collection name
     * @return current ReferenceMaterialBuilder instance
     */
    public ReferenceMaterialBuilder collectionName(String collectionName){
        this.collectionName = collectionName ;
        return this ;
    }


    /**
     * Sets the condition status of the reference material.
     * @param conditionStatus current condition status
     * @return current ReferenceMaterialBuilder instance
     */
    public ReferenceMaterialBuilder conditionStatus(ConditionStatus conditionStatus){
        this.conditionStatus = conditionStatus ;
        return this ;
    }


    /**
     * Specifies whether librarian assistance is required.
     * @param requiresLibrarianAssistance true if librarian assistance is required
     * @return current ReferenceMaterialBuilder instance
     */
    public ReferenceMaterialBuilder requiresLibrarianAssistance(boolean requiresLibrarianAssistance){
        this.requiresLibrarianAssistance = requiresLibrarianAssistance ;
        return this ;
    }


    /**
     * Creates and returns a new ReferenceMaterial object.
     * @return newly created ReferenceMaterial instance
     */
    public ReferenceMaterial build(){
        return new ReferenceMaterial(title ,
                collectionName ,
                conditionStatus ,
                requiresLibrarianAssistance);
    }
}
