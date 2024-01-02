package org.example.controller;


import org.example.models.Book;
import org.example.models.enums.CoverType;
import org.example.models.enums.PaperType;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.example.util.Util.*;


public class BookUi {
    public static void create() {
        Book book = new Book();

        System.out.print("title: ");
        String title = scannerStr.nextLine();

        System.out.print("author: ");
        String author = scannerStr.nextLine();

        System.out.print("publisher: ");
        String publisher = scannerStr.nextLine();

        System.out.print("edition: ");
        String edition = scannerStr.nextLine();

        System.out.print("format: ");
        String format = scannerStr.nextLine();

        System.out.print("isbn: ");
        String isbn = scannerStr.nextLine();

//        System.out.print("numberOfPages: ");
//        Long numberOfPages = scannerNum.nextLong();
//        scanner.nextLine(); // Bu qator qolgan \n belgisini o'qib tashlash uchun

        Long numberOfPages = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("numberOfPages: ");
            String input = scannerStr.nextLine();

            try {
                numberOfPages = Long.parseLong(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please, try again.");
            }
        }

        CoverType coverType = null;
        boolean validCoverTypeIndex = false;
        while (!validCoverTypeIndex) {
            System.out.println("Cover types: ");
            CoverType[] coverTypes = CoverType.values();
            for (int i = 1; i < coverTypes.length+1; i++) {
                String coverTypeName = coverTypes[i-1].name().toLowerCase().replace("_", " ");
                System.out.println(i + ". " + coverTypeName);

            }
            System.out.print("Index of cover tpye: ");
            String coverTypeIndexInput = scannerStr.nextLine();

            if (Pattern.matches("\\d+", coverTypeIndexInput)) {
                int coverTypeIndex = Integer.parseInt(coverTypeIndexInput);
                coverTypeIndex -= 1;
                if (coverTypeIndex >= 0 && coverTypeIndex < coverTypes.length) {
                    coverType = coverTypes[coverTypeIndex];
                    validCoverTypeIndex = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }

        PaperType paperType = null;
        System.out.println("Paper type: ");
        PaperType[] paperTypes = PaperType.values();
        for (int i = 1; i < paperTypes.length; i++) {
            String papertype = paperTypes[i-1].name().toLowerCase().replace("_", " ");
            System.out.println(i + " . "+papertype);
        }
        boolean validPaperType = false;
        while (!validPaperType) {
            System.out.print("Index of paper type: ");
            String paperTypeIndex = scannerStr.nextLine();
            if (Pattern.matches("\\d+", paperTypeIndex)) {
                int paperindex = Integer.parseInt(paperTypeIndex);
                paperindex -= 1;
                if (paperindex >= 1 && paperindex < paperTypes.length-1) {
                    paperType = paperTypes[paperindex];
                    validPaperType = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }


        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setEdition(edition);
        book.setFormat(format);
        book.setIsbn(isbn);
        book.setNumberOfPages(numberOfPages);
        book.setCoverType(coverType);
        book.setPaperType(paperType);

        BOOK_SERVICE.add(book);

        System.out.println("Object created:");

    }

    public static void search() {

        int k = 0;
        System.out.println("""
                            1. Search by title
                            2. Search by author
                            3. Search by publisher
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.print("Enter the title: ");
                String title = scannerStr.nextLine();
                ArrayList<Book> books = BOOK_SERVICE.getByName(title);
                if(books.isEmpty()){
                    System.out.println("No book found with title: " + title);
                }else {
                    int l = 1;
                    for (Book book : books) {
                        System.out.println(l++ + ": "+book.toString());
                        System.out.println("------------------------------------------------------------");
                    }
                    boolean valid = false;
                    while (!valid) {
                        System.out.print("Select the index of the book. (0. Back) : ");
                        int d = scannerNum.nextInt();
                        if (d > books.size()  || d < books.size() ) {
                            System.out.println("Wrong input");
                        }else {
                            Book book = books.get(d - 1);
                            System.out.println(book.toString());
                            valid = true;
                        }
                    }
                }
            }
            case 2 ->{
                System.out.print("Enter author  name: ");
                String author = scannerStr.nextLine();
                ArrayList<Book> books = BOOK_SERVICE.getByAuthor(author);
                if(books.isEmpty()){
                    System.out.println("No book found with author: " + author);
                }else {
                    int l = 1;
                    for (Book book : books) {
                        System.out.println(book.toString());
                        System.out.println("------------------------------------------------------------");
                    }
                    boolean valid = false;
                    while (!valid) {
                        System.out.print("Select the index of the book. (0. Back) : ");
                        int d = scannerNum.nextInt();
                        if (d > books.size()  || d < books.size() ) {
                            System.out.println("Wrong input");
                        }else {
                            Book book = books.get(d - 1);
                            System.out.println(book.toString());
                            valid = true;
                        }
                    }
                }
            }
            case 3 ->{
                System.out.print("Enter publisher: ");
                String publisher = scannerStr.nextLine();
                ArrayList<Book> books = BOOK_SERVICE.getByPublisher(publisher);
                if(books.isEmpty()){
                    System.out.println("No book found with publisher: " + publisher);
                }else {
                    int l = 1;
                    for (Book book : books) {
                        System.out.println(book.toString());
                        System.out.println("------------------------------------------------------------");
                    }
                    boolean valid = false;
                    while (!valid) {
                        System.out.print("Select the index of the book. (0. Back) : ");
                        int d = scannerNum.nextInt();
                        if (d > books.size()  || d < books.size() ) {
                            System.out.println("Wrong input");
                        }else {
                            Book book = books.get(d - 1);
                            System.out.println(book.toString());
                            valid = true;
                        }
                    }
                }
            }
            case 0 ->{
                return;
            }
            default -> {
                System.out.println("Unexpected value: " + k);
                search();
            }
        }
    }
}
