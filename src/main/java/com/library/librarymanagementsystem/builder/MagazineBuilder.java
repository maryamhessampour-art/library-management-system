package com.library.librarymanagementsystem.builder;

import com.library.librarymanagementsystem.model.Magazine;

/**
 * Builder class used to create Magazine objects step by step.
 * This class follows the Builder design pattern to simplify
 * the creation of Magazine instances.
 */
public class MagazineBuilder {


    private String title ;
    private int issueNumber ;


    /**
     * Sets the title of the magazine.
     * @param title magazine title
     * @return current MagazineBuilder instance
     */
    public MagazineBuilder title(String title){
        this.title = title ;
        return this ;
    }


    /**
     * Sets the issue number of the magazine.
     * @param issueNumber magazine issue number
     * @return current MagazineBuilder instance
     */
    public MagazineBuilder issueNumber(int issueNumber){
        this.issueNumber = issueNumber ;
        return this ;
    }


    /**
     * Creates and returns a new Magazine object.
     * @return newly created Magazine instance
     */
    public Magazine build(){
        return new Magazine(title , issueNumber);
    }
}
