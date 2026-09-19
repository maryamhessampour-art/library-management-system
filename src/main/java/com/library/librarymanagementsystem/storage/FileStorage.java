package com.library.librarymanagementsystem.storage;

import com.library.librarymanagementsystem.enums.ConditionStatus;
import com.library.librarymanagementsystem.model.*;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE_NAME = "library.txt";

    public void save(List<LibraryItem> items) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (LibraryItem item : items) {

                writer.write(item.toString());
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<LibraryItem> load() {

        List<LibraryItem> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                switch (data[0]) {

                    case "BOOK":
                        Book book = new Book(
                                data[1],
                                data[2],
                                data[3],
                                Integer.parseInt(data[4]),
                                data[5],
                                Integer.parseInt(data[6]),
                                data[7]
                        );
                        items.add(book);
                        break;

                    case "MAGAZINE":
                        Magazine magazine = new Magazine(
                                data[1],
                                Integer.parseInt(data[2])
                        );
                        items.add(magazine);
                        break;

                    case "DVD":
                        DVD dvd = new DVD(
                                data[1],
                                data[2],
                                Integer.parseInt(data[3])
                        );
                        items.add(dvd);
                        break;

                    case "REFERENCE":
                        ReferenceMaterial referenceMaterial = new ReferenceMaterial(
                                data[1],
                                data[2],
                                ConditionStatus.valueOf(data[3]),
                                Boolean.parseBoolean(data[4])
                        );
                        items.add(referenceMaterial);
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}