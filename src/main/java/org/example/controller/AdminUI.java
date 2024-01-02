package org.example.controller;



import org.example.models.*;
import org.example.util.Util;

import java.util.ArrayList;

import static org.example.util.Util.*;


public class AdminUI {

//    public static void adminUi() {
//        int a = 0;
//        while (true) {
//            System.out.println("""
//                    Printed products warehouse
//                    Author zero8d
//                    1. Show all products
//                    2. Create a product
//                    3. Search for products
//                    4. Exit
//                    """);
//            a = scannerNum.nextInt();
//            switch (a) {
//                case 1 -> showAll();
//                case 2 -> addProduct();
//                case 3 -> userUi.search();
//                case 4 -> {
//                    return;
//                }
//                default -> System.out.println("Unexpected value: " + a);
//            }
//        }
//    }
//
//    private void addProduct() {
//        int i = 0;
//        while (true) {
//            System.out.println("""
//                    1.Books
//                    2.Magazine
//                    3.Brochure
//                    4.Business Card
//                    5.Poster
//                    6.Label
//                    7.Packaging
//                    0.Back
//                    """);
//            i = scannerNum.nextInt();
//            switch (i) {
//                case 1 -> bookUi.create();
//                case 2 -> magazineUi.create();
//                case 3 -> brochureUi.create();
//                case 4 -> businessCardUi.create();
//                case 5 -> posterUi.create();
//                case 6 -> labelUi.create();
//                case 7 -> packagingUi.create();
//                case 0 ->{
//                    return;
//                }
//                default -> System.out.println("Unexpected value: " + i);
//            }
//        }
//
//    }
//
//    private void showAll() {
//        int i = 0;
//        while (true) {
//            System.out.println("""
//                    1.Books
//                    2.Magazine
//                    3.Brochure
//                    4.Business Card
//                    5.Poster
//                    6.Label
//                    7.Packaging
//                    0.Back
//                    """);
//            i = scannerNum.nextInt();
//            switch (i) {
//                case 1 -> {
//                    ArrayList<BookEntity> books = bookService.getAllBookEntitys();
//                    if (books.isEmpty()) {
//                        System.out.println("There is no book in the database.");
//                    } else {
//                        int k = 1;
//                        for (BookEntity book : books) {
//                            System.out.println(book.toString());
//                            System.out.println("-------------------------------------------");
//                        }
//                        return;
//                    }
//
//                }
//                case 2 ->{
//                    ArrayList<MagazineEntity> magazines = magazineService.getAll();
//                    if(magazines.isEmpty()){
//                        System.out.println("No magazine found");
//                        return;
//                    }
//                    for (MagazineEntity magazine : magazines) {
//                        System.out.println(magazine.toString());
//                        System.out.println("--------------------------------------------");
//                    }
//                }
//                case 3 ->{
//                    ArrayList<BrochureEntity> brochures = brochureService.getAll();
//                    if(brochures.isEmpty()){
//                        System.out.println(" There is no brochure ");
//                    }else {
//                        for (BrochureEntity brochure : brochures) {
//                            System.out.println(brochure.toString());
//                            System.out.println("--------------------------------------------");
//                        }
//                        return;
//                    }
//                }
//                case 4 ->{
//                    ArrayList<BusinessCardEntity> businessCards = businessCardService.getAll();
//                    if(businessCards.isEmpty()){
//                        System.out.println(" There is no business card ");
//                    }else {
//                        for (BusinessCardEntity businessCard : businessCards) {
//                            System.out.println(businessCard.toString());
//                            System.out.println("------------------------------------------");
//                        }
//                        return;
//
//                    }
//                }
//                case 5 ->{
//                    ArrayList<PosterEntity> posters = posterService.getAll();
//                    if(posters.isEmpty()){
//                        System.out.println(" There is no poster ");
//                    }else {
//                        for (PosterEntity poster : posters) {
//                            System.out.println(poster.toString());
//                            System.out.println("------------------------------------------");
//                        }
//                        return;
//
//                    }
//                }
//                case 6 ->{
//                    ArrayList<LabelEntity> labels = labelService.getAll();
//                    if(labels.isEmpty()){
//                        System.out.println(" There is no label ");
//                    }else {
//                        for (LabelEntity label : labels) {
//                            System.out.println(label.toString());
//                            System.out.println("-------------------------------------------");
//                        }
//                        return;
//
//                    }
//                }
//                case 7 ->{
//                    ArrayList<PackagingEntity> packagings = packagingService.getAll();
//                    if(packagings.isEmpty()){
//                        System.out.println(" There is no packaging ");
//                    }else {
//                        for (PackagingEntity packaging : packagings) {
//                            System.out.println(packaging.toString());
//                            System.out.println("---------------------------------------------");
//                        }
//                        return;
//
//                    }
//                }
//                case 0 -> {
//                    return;
//                }
//                default ->{
//                    System.out.println("Unexpected value: " + i);
//                    showAll();
//                }
//            }
//        }
//
//    }

    public static void adminUi() {
        int a = 0;
        while (true) {
            System.out.println("""
                    Printed products warehouse
                    Author zero8d
                    1. Show all products
                    2. Create a product
                    3. Search for products
                    4. Exit
                    """);
            a = Util.scannerNum.nextInt();
            switch (a) {
                case 1 -> showAll();
                case 2 -> addProduct();
                case 3 -> search();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Unexpected value: " + a);
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
            i = Util.scannerNum.nextInt();
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

    private static void addProduct() {
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
            i = Util.scannerNum.nextInt();
            switch (i) {
                case 1 -> BookUi.create();
                case 2 -> MagazineUi.create();
                case 3 -> BrochureUi.create();
                case 4 -> Business_cardUi.create();
                case 5 -> PosterUi.create();
                case 6 -> LabelUi.create();
                case 7 -> PackagingUi.create();
                case 0 ->{
                    return;
                }
                default -> System.out.println("Unexpected value: " + i);
            }
        }

    }

    private static void search() {
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
            i = Util.scannerNum.nextInt();
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
