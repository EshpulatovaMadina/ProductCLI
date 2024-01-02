package org.example.controller;

import org.example.models.Business_card;
import org.example.models.enums.PaperType;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.example.util.Util.*;

public class Business_cardUi {
    public static void create() {
        Business_card businessCard = new Business_card();

        System.out.print("Name: ");
        businessCard.setName(scannerStr.nextLine());

        System.out.print("Job: ");
        businessCard.setJobTitle(scannerStr.nextLine());

        System.out.print("Company name: ");
        businessCard.setCompany_name(scannerStr.nextLine());

        System.out.print("Logotype: ");
        businessCard.setLogo(scannerStr.nextLine());

        System.out.print("Contact info: ");
        businessCard.setContactInfo(scannerStr.nextLine());

        boolean validSize = false;
        while (!validSize) {
            System.out.print("Size  example(35x35): ");
            String s = scannerStr.nextLine();
            if (s.matches("\\d+x\\d+")) {
                businessCard.setSize(s);
                validSize = true;
            } else {
                System.out.println("Wrong format of size!");

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
                    businessCard.setPaperType(paperTypes[paperindex]);
                    validPaperType = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }


        System.out.println("successfully created: ");
        BUSINESS_CARD_SERVICE.add(businessCard);
    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by name
                            2. Search by company name
                            3. Search by job title
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.println("Enter name : ");
                String name = scannerStr.nextLine();
                ArrayList<Business_card> businessCards = BUSINESS_CARD_SERVICE.getByName(name);

                if(businessCards.isEmpty()){
                    System.out.println("No Business card ");
                }else {
                    for (Business_card businessCard : businessCards) {
                        System.out.println(businessCard.toString());
                        System.out.println("------------------------------------------------------------------------");
                    }
                }
            }
            case 2 ->{
                System.out.println("Enter company name : ");
                String compName = scannerStr.nextLine();
                ArrayList<Business_card> businessCards = BUSINESS_CARD_SERVICE.getByCompName(compName);

                if(businessCards.isEmpty()){
                    System.out.println("No Business card ");
                }else {
                    for (Business_card businessCard : businessCards) {
                        System.out.println(businessCard.toString());
                        System.out.println("------------------------------------------------------------------------");
                    }
                }
            }
            case 3 ->{
                System.out.println("Enter job title : ");
                String jobTitle = scannerStr.nextLine();
                ArrayList<Business_card> businessCards = BUSINESS_CARD_SERVICE.getByJobTitle(jobTitle);

                if(businessCards.isEmpty()){
                    System.out.println("No Business card ");
                }else {
                    for (Business_card businessCard : businessCards) {
                        System.out.println(businessCard.toString());
                        System.out.println("------------------------------------------------------------------------");
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

