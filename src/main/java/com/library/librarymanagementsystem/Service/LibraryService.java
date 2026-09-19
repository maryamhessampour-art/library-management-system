package com.library.librarymanagementsystem.Service;

import com.library.librarymanagementsystem.DTO.BookDTO;
import com.library.librarymanagementsystem.DTO.DVDDTO;
import com.library.librarymanagementsystem.DTO.MagazineDTO;
import com.library.librarymanagementsystem.DTO.ReferenceMaterialDTO;

import com.library.librarymanagementsystem.exception.BorrowException;
import com.library.librarymanagementsystem.exception.DuplicateItemException;
import com.library.librarymanagementsystem.exception.EmptyLibraryException;
import com.library.librarymanagementsystem.exception.ItemNotFoundException;
import com.library.librarymanagementsystem.model.*;
import com.library.librarymanagementsystem.repository.LibraryRepository;
import com.library.librarymanagementsystem.storage.FileStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.library.librarymanagementsystem.builder.BookBuilder;
import com.library.librarymanagementsystem.builder.MagazineBuilder;
import com.library.librarymanagementsystem.builder.DVDBuilder;
import com.library.librarymanagementsystem.builder.ReferenceMaterialBuilder;

/**
 * Provides the business logic for the Library Management System.
 */
@Service
public class LibraryService {

    private final LibraryRepository repository = new LibraryRepository();
    private final FileStorage storage = new FileStorage();

    /**
     * Creates the service and loads saved data from file.
     */
    public LibraryService() {

        repository.saveAll(storage.load());

    }

    /**
     * Adds a library item to the repository.
     */
    public void addItem(LibraryItem item){

        checkNull(item);
        checkDuplicate(item);
        repository.save(item);
        storage.save(repository.findAll());
    }

    /**
     * Creates and stores a new book.
     */
    public void addBook(BookDTO dto){

        if(dto == null){
            throw new IllegalArgumentException("Book information cannot be null.");
        }

        Book book = new BookBuilder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .publisher(dto.getPublisher())
                .publicationYear(dto.getPublicationYear())
                .isbn10(dto.getIsbn10())
                .pageCount(dto.getPageCount())
                .genre(dto.getGenre())
                .build();

        addItem(book);

    }


    /**
     * Creates and stores a new magazine.
     */
    public void addMagazine(MagazineDTO dto){

        if(dto == null){
            throw new IllegalArgumentException("Magazine information cannot be null.");
        }

        Magazine magazine = new MagazineBuilder()
                .title(dto.getTitle())
                .issueNumber(dto.getIssueNumber())
                .build();

        addItem(magazine);
    }


    /**
     * Creates and stores a new DVD.
     */
    public void addDVD(DVDDTO dto){

        if(dto == null){
            throw new IllegalArgumentException("DVD information cannot be null.");
        }

        DVD dvd = new DVDBuilder()
                .title(dto.getTitle())
                .director(dto.getDirector())
                .durationInMinutes(dto.getDurationInMinutes())
                .build();

        addItem(dvd);
    }


    /**
     * Creates and stores a new reference material.
     */
    public void addReferenceMaterial(ReferenceMaterialDTO dto){

        if(dto == null){
            throw new IllegalArgumentException("Reference material information cannot be null.");
        }

        ReferenceMaterial referenceMaterial = new ReferenceMaterialBuilder()
                .title(dto.getTitle())
                .collectionName(dto.getCollectionName())
                .conditionStatus(dto.getConditionStatus())
                .requiresLibrarianAssistance(dto.isRequiresLibrarianAssistance())
                .build();

        addItem(referenceMaterial);
    }



    /**
     * Checks whether the given item is null.
     */
    private void checkNull(LibraryItem item){

        if (item == null) {
            throw new IllegalArgumentException("Library item cannot be null.");
        }
    }



    /**
     * Checks for duplicate books using ISBN-10.
     */
    private void checkDuplicate(LibraryItem item){

        for(LibraryItem currentItem : repository.findAll() ){

            if(item instanceof Book && currentItem instanceof Book){

                Book book = (Book) item ;
                Book currentBook = (Book) currentItem ;

                if(book.getIsbn10() != null && book.getIsbn10().equals(currentBook.getIsbn10())){
                    throw new DuplicateItemException("Duplicate ISBN. This book already exists.");
                }
            }
        }
    }



    /**
     * Deletes a library item by its identifier.
     */
    public void deleteItem(Long id){

        findItemById(id);
        repository.deleteById(id);
        storage.save(repository.findAll());
    }


    /**
     * Finds a library item by its identifier.
     */
    public LibraryItem findItemById(Long id){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem.getId().equals(id)){
                return currentItem ;
            }
        }
        throw new ItemNotFoundException("Item not found!");
    }


    /**
     *Borrows a library item.
     */
    public void borrowItem(Long id){

        LibraryItem item = findItemById(id);

        if(item instanceof ReferenceMaterial){
            throw new BorrowException("Reference materials cannot be borrowed.");
        }

        BaseBorrowableItem borrowableItem = (BaseBorrowableItem) item ;

        if(!borrowableItem.isAvailable()){
            throw new BorrowException("Item is already borrowed.") ;
        }

        borrowableItem.borrowItem();
        storage.save(repository.findAll());
    }

    /**
    *Returns a borrowed library item.
     */
    public void returnItem(Long id){

        LibraryItem item = findItemById(id);

        if(item instanceof ReferenceMaterial){
            throw new BorrowException("Reference materials cannot be returned because they cannot be borrowed.");
        }

        BaseBorrowableItem borrowableItem = (BaseBorrowableItem) item ;

        if(borrowableItem.isAvailable()){
            throw new BorrowException("Item is not borrowed.") ;
        }

        borrowableItem.returnItem();
        storage.save(repository.findAll());
    }


    /**
     * Searches library items by title.
     */
    public List<LibraryItem> searchByTitle(String title){

        if(repository.findAll().isEmpty()) {
            throw new EmptyLibraryException("Library is empty!");
        }

        List<LibraryItem> resultList = new ArrayList<>();

        for(LibraryItem searchedItem : repository.findAll()){
            if(searchedItem.getTitle().toLowerCase().contains(title.toLowerCase())){
                resultList.add(searchedItem);
            }
        }
        if(resultList.isEmpty()){
            throw new ItemNotFoundException("No items found with this title!");
        }
        else{
            return resultList;
        }
    }



    /**
     * Returns all library items.
     */
    public List<LibraryItem> getAllItems(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        return repository.findAll();
    }



    /**
     * Returns all books.
     */
    public List<Book> getBooks(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        List<Book> result = new ArrayList<>();

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem instanceof Book){
                Book currentBook = (Book) currentItem ;
                result.add(currentBook);
            }
        }
        if (result.isEmpty()) {
            throw new ItemNotFoundException("No books found!");
        }
        return result;
    }



    /**
     * Returns all magazines.
     */
    public List<Magazine> getMagazines(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        List<Magazine> result = new ArrayList<>();

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem instanceof Magazine){
                Magazine currentMagazine = (Magazine) currentItem ;
                result.add(currentMagazine);
            }
        }
        if(result.isEmpty()){
            throw new ItemNotFoundException("No Magazines found!");
        }
        return result;
    }



    /**
     * Returns all DVDs.
     */
    public List<DVD> getDVDs(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        List<DVD> result = new ArrayList<>();

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem instanceof DVD){
                DVD currentDVD = (DVD) currentItem ;
                result.add(currentDVD);
            }
        }
        if(result.isEmpty()){
            throw new ItemNotFoundException("No DVDs found!");
        }
        return result;
    }



    /**
     * Returns all reference materials.
     */
    public List<ReferenceMaterial> getReferenceMaterials(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        List<ReferenceMaterial> result = new ArrayList<>();

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem instanceof ReferenceMaterial){
                ReferenceMaterial currentReferenceMaterial = (ReferenceMaterial) currentItem ;
                result.add(currentReferenceMaterial);
            }
        }
        if(result.isEmpty()){
            throw new ItemNotFoundException("No reference materials found!");
        }
        return result;
    }



    /**
     * Calculates the overdue penalty.
     */
    public double calculatePenalty(Long id){

        LibraryItem item = findItemById(id) ;

        if(item instanceof ReferenceMaterial){
            throw new BorrowException("Reference materials cannot be borrowed!");
        }
            BaseBorrowableItem borrowableItem = (BaseBorrowableItem) item ;
            return borrowableItem.calculatePenalty() ;
    }



    /**
     * Returns all borrowed items.
     */
    public List<LibraryItem> getBorrowedItems(){

        if(repository.findAll().isEmpty()){
            throw new EmptyLibraryException("Library is empty!");
        }

        List<LibraryItem> result = new ArrayList<>();

        for(LibraryItem currentItem : repository.findAll()){
            if(currentItem instanceof ReferenceMaterial){
                continue;
            }
            BaseBorrowableItem borrowableItem = (BaseBorrowableItem) currentItem ;
                if(!borrowableItem.isAvailable()) {
                    result.add(currentItem);
            }
        }
        if(result.isEmpty()){
            throw new ItemNotFoundException("No borrowed items found!");
        }
        return result;
    }



    /**
     * Returns all overdue items.
     */
    public List<LibraryItem> getOverdueItems() {

        List<LibraryItem> borrowedItems = getBorrowedItems() ;

        List<LibraryItem> result = new ArrayList<>();

        for(LibraryItem currentItem : borrowedItems) {
            BaseBorrowableItem borrowableItem = (BaseBorrowableItem) currentItem;
            double penalty = borrowableItem.calculatePenalty();

            if(penalty > 0){
                result.add(currentItem);
            }
        }
        if(result.isEmpty()){
            throw new ItemNotFoundException("No overdue items found!");
        }
        return result ;
    }



    /**
     * Checks whether an item is available.
     */
    public boolean checkAvailability(Long id){

        LibraryItem item = findItemById(id);

        if(item instanceof ReferenceMaterial){
            throw new BorrowException("Reference materials cannot be checked for availability.");
        }

        BaseBorrowableItem borrowableItem = (BaseBorrowableItem) item;

        return borrowableItem.isAvailable();
    }



    /**
     * Updates the title or genre of a library item.
     */
    public void updateItem(Long id , String title , String genre){

        LibraryItem item = findItemById(id);

        if(title != null && !title.isBlank()) {
            item.setTitle(title);
        }

        if(item instanceof Book && genre != null){
            Book book = (Book) item ;
            book.setGenre(genre);
        }
        storage.save(repository.findAll());
    }


    /**
     * Returns the five most borrowed items.
     */
    public List<BaseBorrowableItem> getTopItems() {

        List<BaseBorrowableItem> result = new ArrayList<>();

        for (LibraryItem currentItem : repository.findAll()) {
            if (currentItem instanceof ReferenceMaterial) {
                continue;
            }
            result.add((BaseBorrowableItem) currentItem);
        }

        result.sort(new Comparator<BaseBorrowableItem>() {
            @Override
            public int compare(BaseBorrowableItem o1, BaseBorrowableItem o2) {
                return Integer.compare(o2.getTotalBorrowCount(), o1.getTotalBorrowCount());
            }
        });
        if (result.size() > 5) {
            return result.subList(0, 5);
        }
        return result;
    }
}


