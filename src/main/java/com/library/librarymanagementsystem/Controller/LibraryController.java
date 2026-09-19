package com.library.librarymanagementsystem.Controller;


import com.library.librarymanagementsystem.Service.LibraryService;
import com.library.librarymanagementsystem.DTO.*;
import com.library.librarymanagementsystem.model.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *REST controller responsible for handling all HTTP requests
 *related to library items.
 */
@RestController
@RequestMapping("/api/items")
public class LibraryController {

    private final LibraryService libraryService;

    /**
     *Creates a controller with the required library service.
     */
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    /**
     *Retrieves all library items.
     */
    @GetMapping
    public List<LibraryItem> getAllItems() {
        return libraryService.getAllItems();
    }


    /**
     *Retrieves a library item using its unique identifier.
     */
    @GetMapping("/{id}")
    public LibraryItem findItemById(@PathVariable Long id) {
        return libraryService.findItemById(id);
    }


    /**
     *Removes a library item from the system.
     */
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        libraryService.deleteItem(id);
    }


    /**
     *Creates a new book from the received data and adds it to the library.
     */
    @PostMapping("/books")
    public void addBook(@RequestBody BookDTO dto) {
        libraryService.addBook(dto);
    }


    /**
     *Creates a new magazine from the received data and adds it to the library.
     */
    @PostMapping("/magazines")
    public void addMagazine(@RequestBody MagazineDTO dto){
        libraryService.addMagazine(dto);
    }


    /**
     *Creates a new dvd from the received data and adds it to the library.
     */
    @PostMapping("/dvds")
    public void addDVD(@RequestBody DVDDTO dto){
        libraryService.addDVD(dto);
    }


    /**
     *Creates a new reference from the received data and adds it to the library.
     */
    @PostMapping("/references")
    public void addReferenceMaterial(@RequestBody ReferenceMaterialDTO dto){
        libraryService.addReferenceMaterial(dto);
    }


    /**
     *Updates the information of an existing library item.
     */
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id , @RequestBody UpdateItemRequest request){

        libraryService.updateItem(id , request.getTitle(), request.getGenre());
    }


    /**
     *Retrieves all books stored in the library.
     */
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return libraryService.getBooks();
    }


    /**
     *Retrieves all magazines stored in the library.
     */
    @GetMapping("/magazines")
    public List<Magazine> getAllMagazines(){
        return libraryService.getMagazines();
    }


    /**
     *Retrieves all DVDs stored in the library.
     */
    @GetMapping("/dvds")
    public List<DVD> getAllDVDs(){
        return libraryService.getDVDs();
    }


    /**
     *Retrieves all reference materials available in the library.
     */
    @GetMapping("/references")
    public List<ReferenceMaterial> getAllReferenceMaterials(){
        return libraryService.getReferenceMaterials();
    }


    /**
     *Searches library items by their title.
     */
    @GetMapping("/search")
    public List<LibraryItem> searchItemsByTitle(@RequestParam("name") String title){
        return libraryService.searchByTitle(title);
    }


    /**
     *Checks whether a library item is currently available.
     */
    @GetMapping("/{id}/availability")
    public boolean isItemAvailable(@PathVariable Long id){
        return libraryService.checkAvailability(id);
    }


    /**
     *Borrows a library item if it is available.
     */
    @PostMapping("/{id}/borrow")
    public void borrowItem(@PathVariable Long id){
        libraryService.borrowItem(id);
    }


    /**
     *Returns a previously borrowed library item.
     */
    @PostMapping("/{id}/return")
    public void returnItem(@PathVariable Long id){
        libraryService.returnItem(id);
    }


    /**
     *Calculates the overdue penalty for a borrowed item.
     */
    @GetMapping("/{id}/penalty")
    public double calculatePenalty(@PathVariable Long id){
        return libraryService.calculatePenalty(id);
    }


    /**
     *Retrieves all library items that are currently borrowed.
     */
    @GetMapping("/borrowed")
    public List<LibraryItem> getAllBorrowedItems(){
        return libraryService.getBorrowedItems();
    }


    /**
     *Retrieves all library items whose borrowing period has expired.
     */
    @GetMapping("/overdue")
    public List<LibraryItem> getAllOverdueItems(){
        return libraryService.getOverdueItems();
    }


    /**
     *Retrieves the five most borrowed library items.
     */
    @GetMapping("/top")
    public List<BaseBorrowableItem> getTopItems(){
        return libraryService.getTopItems();
    }
}

