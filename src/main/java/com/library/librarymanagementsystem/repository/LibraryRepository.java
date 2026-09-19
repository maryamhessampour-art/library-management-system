package com.library.librarymanagementsystem.repository;

import com.library.librarymanagementsystem.model.LibraryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides basic data storage operations
 * for library items.
 */
public class LibraryRepository {

    private final List<LibraryItem> libraryItems = new ArrayList<>();

    /**
     * Saves a library item.
     */
    public void save(LibraryItem item){
        libraryItems.add(item) ;
    }



    /**
     * Finds a library item by its identifier.
     */
    public LibraryItem findById(Long id){

        for(LibraryItem currentItem : libraryItems){

            if(currentItem.getId().equals(id)){
                return currentItem;
            }
        }

        return null;
    }


    /**
     * Returns all stored library items.
     */
    public List<LibraryItem> findAll(){

        return new ArrayList<>(libraryItems);

    }


    /**
     * Deletes a library item by its identifier.
     */
    public void deleteById(Long id){

        for(LibraryItem currentItem : libraryItems){

            if(currentItem.getId().equals(id)){
                libraryItems.remove(currentItem);
                return;
            }
        }
    }


    /**
     * Replaces all stored items with the given list.
     */
    public void saveAll(List<LibraryItem> items) {

        libraryItems.clear();
        libraryItems.addAll(items);

    }
}
