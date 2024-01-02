package org.example.controller;


import org.example.models.*;

import java.util.ArrayList;

import static org.example.util.Util.*;

public class UserUi {

    public static void userUi() {
        int i = 0;
        while (true) {
            System.out.println("""
                    1. Show all products
                    2. Search for products
                    0. Exit
                    """);
            i = scannerNum.nextInt();
            switch (i) {
                case 1 -> showAll();
                case 2 -> search();
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Unexpected value");
                    userUi();
                }
            }
        }
    }

    private static void showAll() {
        int i = 0;
        while (true) {
            System.out.println("""
                    1.Books
                    2.Magazine
                    3.Brochure
                    4.Business Card
                    5.Poster
                    6.Label
                    7.Packaging
                    0.Back
                    """);
            i = scannerNum.nextInt();
            switch (i) {
                case 1 -> {
                    ArrayList<Book> books = BOOK_SERVICE.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("There is no book in the database.");
                    } else {
                        int k = 1;
                        for (Book book : books) {
                            System.out.println(book.toString());
                            System.out.println("-------------------------------------------");
                        }
                        return;
                    }

                }
                case 2 ->{
                    ArrayList<Magazine> magazines = MAGAZINE_SERVICE.getAll();
                    if(magazines.isEmpty()){
                        System.out.println("No magazine found");
                        return;
                    }
                    for (Magazine magazine : magazines) {
                        System.out.println(magazine.toString());
                        System.out.println("--------------------------------------------");
                    }
                }
                case 3 ->{
                    ArrayList<Brochure> brochures = BROCHURE_SERVICE.getAll();
                    if(brochures.isEmpty()){
                        System.out.println(" There is no brochure ");
                    }else {
                        for (Brochure brochure : brochures) {
                            System.out.println(brochure.toString());
                            System.out.println("--------------------------------------------");
                        }
                        return;
                    }
                }
                case 4 ->{
                    ArrayList<Business_card> businessCards = BUSINESS_CARD_SERVICE.getAll();
                    if(businessCards.isEmpty()){
                        System.out.println(" There is no business card ");
                    }else {
                        for (Business_card businessCard : businessCards) {
                            System.out.println(businessCard.toString());
                            System.out.println("------------------------------------------");
                        }
                        return;

                    }
                }
                case 5 ->{
                    ArrayList<Poster> posters = POSTER_SERVICE.getAll();
                    if(posters.isEmpty()){
                        System.out.println(" There is no poster ");
                    }else {
                        for (Poster poster : posters) {
                            System.out.println(poster.toString());
                            System.out.println("------------------------------------------");
                        }
                        return;

                    }
                }
                case 6 ->{
                    ArrayList<Label> labels = LABEL_SERVICE.getAll();
                    if(labels.isEmpty()){
                        System.out.println(" There is no label ");
                    }else {
                        for (Label label : labels) {
                            System.out.println(label.toString());
                            System.out.println("-------------------------------------------");
                        }
                        return;

                    }
                }
                case 7 ->{
                    ArrayList<Packaging> packagings = PACKAGING_SERVICE.getAll();
                    if(packagings.isEmpty()){
                        System.out.println(" There is no packaging ");
                    }else {
                        for (Packaging packaging : packagings) {
                            System.out.println(packaging.toString());
                            System.out.println("---------------------------------------------");
                        }
                        return;

                    }
                }
                case 0 -> {
                    return;
                }
                default ->{
                    System.out.println("Unexpected value: " + i);
                    showAll();
                }
            }
        }

    }

    public static void search() {
        int i = 0;
        while (true) {
            System.out.println("""
                    1.Books
                    2.Magazine
                    3.Brochure
                    4.Business Card
                    5.Poster
                    6.Label
                    7.Packaging
                    0.Back
                    """);
            i = scannerNum.nextInt();
            switch (i){
                case 1 -> BookUi.search();
                case 2 -> MagazineUi.search();
                case 3 -> BrochureUi.search();
                case 4 -> Business_cardUi.search();
                case 5 -> PosterUi.search();
                case 6 -> LabelUi.search();
                case 7 -> PackagingUi.search();
                case 0 ->{
                    return;
                }
                default -> System.out.println("Unexpected value: " + i);
            }
        }
    }
}
