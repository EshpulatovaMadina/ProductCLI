package org.example.controller;

import org.example.models.Poster;
import org.example.models.enums.PaperType;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.example.util.Util.*;

public class PosterUi {
    public static void create() {

        Poster poster = new Poster();

        System.out.print("Title: ");
        poster.setTitle(scannerStr.nextLine());

        System.out.print("Message: ");
         poster.setMessage(scannerStr.nextLine());

        System.out.print("Graphics: ");
        poster.setGraphics(scannerStr.nextLine());

        System.out.print("Images: ");
        poster.setImages(scannerStr.nextLine());
        boolean validSize = false;
        while (!validSize) {
            System.out.print("Size (format: num x num): ");
            String sizeInput = scannerStr.nextLine();

            if (sizeInput.matches("\\d+x\\d+")) {
               poster.setSize(sizeInput);
                validSize = true;
            } else {
                System.out.println("Wrong format of size !");
            }
        }

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
                if (paperindex >= 0 && paperindex < paperTypes.length-1) {
                    poster.setPaperType( paperTypes[paperindex]);
                    validPaperType = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }

        POSTER_SERVICE.add(poster);
        System.out.println("Poster created");

    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by title
                            2. Search by message
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.print("Enter title");
                String title = scannerStr.nextLine();

                ArrayList<Poster> posters = POSTER_SERVICE.getByTitle(title);

                if(posters.isEmpty()){
                    System.out.println("No poster");
                }else {
                    for (Poster poster : posters) {
                        System.out.println(poster.toString());
                        System.out.println("-------------------------------------------------------------------");
                    }
                }
            }
            case 2 ->{
                System.out.print("Enter message");
                String message = scannerStr.nextLine();

                ArrayList<Poster> posters = POSTER_SERVICE.getByMessage(message);

                if(posters.isEmpty()){
                    System.out.println("No poster");
                }else {
                    for (Poster poster : posters) {
                        System.out.println(poster.toString());
                        System.out.println("-------------------------------------------------------------------");
                    }
                }
            }
            default -> {
                System.out.println("Unexpected value: " + k);
                search();
            }

        }
    }
}
