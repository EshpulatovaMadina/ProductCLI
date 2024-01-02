package org.example.controller;

import org.example.models.Magazine;
import org.example.models.enums.CoverType;
import org.example.models.enums.PaperType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.example.util.Util.*;

public class MagazineUi {
    public static void create() {
        Magazine magazine = new Magazine();

        System.out.print("Title: ");
        magazine.setTitle(scannerStr.nextLine());

        System.out.print("Publisher: ");
        magazine.setPublisher(scannerStr.nextLine());

        boolean validIssueDate = false;
        while (!validIssueDate) {
            System.out.print("Issue date  (MM.dd.yyyy): ");
            String issueDateInput = scannerStr.nextLine();

            try {
                LocalDate issueDate = LocalDate.parse(issueDateInput, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
                magazine.setIssueDate(issueDate);
                validIssueDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Wrong format of date!");
            }
        }

        System.out.print("Format: ");
        magazine.setFormat(scannerStr.nextLine());

        boolean validNumberOfPages = false;
        while (!validNumberOfPages) {
            System.out.print("Number of pages: ");
            String numberOfPagesInput = scannerStr.nextLine();

            if (Pattern.matches("\\d+", numberOfPagesInput)) {
                magazine.setNumberOfPages(Long.parseLong(numberOfPagesInput));
                validNumberOfPages = true;
            } else {
                System.out.println("Enter only numeric !");
            }
        }

        boolean validCoverTypeIndex = false;
        while (!validCoverTypeIndex) {
            System.out.println("Cover types: ");
            CoverType[] coverTypes = CoverType.values();
            for (int i = 0; i < coverTypes.length; i++) {
                String coverTypeName = coverTypes[i].name().toLowerCase().replace("_", " ");
                System.out.println((i + 1) + ". " + coverTypeName);

            }
            System.out.print("Index of cover tpye: ");
            String coverTypeIndexInput = scannerStr.nextLine();

            if (Pattern.matches("\\d+", coverTypeIndexInput)) {
                int coverTypeIndex = Integer.parseInt(coverTypeIndexInput);
                if (coverTypeIndex >= 1 && coverTypeIndex < coverTypes.length) {
                    magazine.setCoverType(coverTypes[coverTypeIndex]);
                    validCoverTypeIndex = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
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
                    magazine.setPaperType(paperTypes[paperindex]);
                    validPaperType = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }


        System.out.println("successfully created: " + magazine.toString());
        MAGAZINE_SERVICE.add(magazine);
    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by Title
                            2. Search by Publisher
                            3. Search by issue date
                            0. Back
                            """);
        k = scannerNum.nextInt();

        switch (k){
            case 1 ->{
                System.out.print(" Enter title : ");
                String title = scannerStr.nextLine();
                ArrayList<Magazine> magazines = MAGAZINE_SERVICE.getByTitle(title);
                if(magazines.isEmpty()){
                    System.out.println("No magazine found");
                    return;
                }
                for (Magazine magazine : magazines) {
                    System.out.println(magazine.toString());
                }
            }
            case 2 ->{
                System.out.print("Enter publisher : ");
                String publisher = scannerStr.nextLine();
                ArrayList<Magazine> magazines =  MAGAZINE_SERVICE.getByPublisher(publisher);
                if(magazines.isEmpty()){
                    System.out.println("No magazine found");
                    return;
                }
                for (Magazine magazine : magazines) {
                    System.out.println(magazine.toString());
                }
            }
            case 3 ->{

                boolean validIssueDate = false;
                while (!validIssueDate) {
                    System.out.print("Enter date  (MM.dd.yyyy): ");
                    String issueDateInput = scannerStr.nextLine();

                    try {
                        LocalDate issueDate = LocalDate.parse(issueDateInput, DateTimeFormatter.ofPattern("MM.dd.yyyy"));

                        ArrayList<Magazine> magazines =  MAGAZINE_SERVICE.getByDate(issueDate);
                        if(magazines.isEmpty()){
                            System.out.println("No magazine found");
                            return;
                        }
                        for (Magazine magazine : magazines) {
                            System.out.println(magazine.toString());
                        }
                        validIssueDate = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Wrong format of date!");
                    }
                }

            }
            case 0 ->{
                return;
            }
            default -> System.out.println("Unexpected value: " + k);
        }
    }
}
