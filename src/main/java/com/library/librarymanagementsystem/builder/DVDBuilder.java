package com.library.librarymanagementsystem.builder;

import com.library.librarymanagementsystem.model.DVD;


/**
 Builder class used to create DVD objects step by step.
 This class follows the Builder design pattern and simplifies
 the creation of DVD instances.
*/
public class DVDBuilder {

    private String title ;
    private String director;
    private int durationInMinutes;


    /**
    *Sets the title of the DVD.
    *@param title DVD title
    *@return current DVDBuilder instance
    */
    public DVDBuilder title(String title){
        this.title = title ;
        return this ;
    }


    /**
    *Sets the director of the DVD.
    *@param director DVD director
    *@return current DVDBuilder instance
    */
    public DVDBuilder director(String director){
        this.director = director ;
        return this ;
    }



    /**
    *Sets the duration of the DVD.
    *@param durationInMinutes duration in minutes
    *@return current DVDBuilder instance
    */
    public DVDBuilder durationInMinutes (int durationInMinutes){
        this.durationInMinutes = durationInMinutes ;
        return this ;
    }


    /**
    *Creates and returns a new DVD object.
    *@return newly created DVD instance
    */
    public DVD build(){
        return new DVD(title ,
                director ,
                durationInMinutes);
    }
}
