package org.example.controller;


import org.example.models.Brochure;
import org.example.models.enums.PaperType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static org.example.util.Util.*;

public class BrochureUi {
    public static void create() {
        Brochure brochure = new Brochure();


        System.out.print("title: ");
        brochure.setTitle( scannerStr.nextLine());

        System.out.print("description: ");
        brochure.setDescription(scannerStr.nextLine());

        System.out.print("targetAudience: ");
        brochure.setTargetAudience(scannerStr.nextLine());


        boolean validSize = false;
        while (!validSize) {
            System.out.print("Size (format: num x num): ");
            String size = scannerStr.nextLine();

            if (size.matches("\\d+x\\d+")) {
                brochure.setSize(size);
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
                   brochure.setPaperType(paperTypes[paperindex]);
                    validPaperType = true;
                } else {
                    System.out.println("Wrong index!");
                }
            } else {
                System.out.println("Wrong index!");
            }
        }

        System.out.print("graphics: ");
        brochure.setGraphics(scannerStr.nextLine());

        System.out.print("images: ");
        brochure.setImages(scannerStr.nextLine());

        BROCHURE_SERVICE.add(brochure);

        System.out.println("Object created:");
    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by Title
                            2. Search by Target Audience
                            3. Search by paper type
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.print(" Enter title : ");
                String title = scannerStr.nextLine();
                ArrayList<Brochure> brochures = BROCHURE_SERVICE.getByTitle(title);
                if(brochures.isEmpty()){
                    System.out.println("No brochure found");
                    return;
                }
                for (Brochure brochure : brochures) {
                    System.out.println(brochure.toString());
                }
            }
            case 2 ->{
                System.out.print(" Enter target audience : ");
                String target = scannerStr.nextLine();
                ArrayList<Brochure> brochures = BROCHURE_SERVICE.getByTarget(target);
                if(brochures.isEmpty()){
                    System.out.println("No brochure found");
                    return;
                }
                for (Brochure brochure : brochures) {
                    System.out.println(brochure.toString());
                }
            }
            case 3 ->{
                int j = 1;
                for (PaperType value : PaperType.values()) {
                    System.out.println(j++ + " : "+value);
                }
                System.out.println(" Select number of the paper type : ");
                PaperType paperType;
                while (true){
                    int typeIndex = scannerNum.nextInt();
                    if(typeIndex > PaperType.values().length || typeIndex < 1){
                        System.out.println("Wrong");
                    }else {
                        paperType = (PaperType) Arrays.stream(PaperType.values()).toArray()[typeIndex - 1];
                        break;
                    }
                }

                ArrayList<Brochure> brochures = BROCHURE_SERVICE.getByPaperType(paperType);
                if(brochures.isEmpty()){
                    System.out.println("No brochure found");
                    return;
                }
                for (Brochure brochure : brochures) {
                    System.out.println(brochure.toString());
                }
            }
            default -> {
                System.out.println("Unexpected value: " + k);
                search();
            }
        }
    }
}
