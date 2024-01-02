package org.example.controller;

import org.example.models.Label;

import java.util.ArrayList;

import static org.example.util.Util.*;

public class LabelUi {
    public static void create() {
        Label label = new Label();

        System.out.print("productName: ");
        label.setProductName(scannerStr.nextLine());

        System.out.print("brandName: ");
        label.setBrandName(scannerStr.nextLine());

        System.out.print("description: ");
        label.setDescription(scannerStr.nextLine());


        boolean validSize = false;
        while (!validSize) {
            System.out.print("Size (format: num x num): ");
            String sizeInput = scannerStr.nextLine();

            if (sizeInput.matches("\\d+x\\d+")) {
                label.setSize(sizeInput);
                validSize = true;
            } else {
                System.out.println("Wrong format of size !");
            }
        }

        System.out.print("shape: ");
        label.setShape(scannerStr.nextLine());

        System.out.print("color: ");
        label.setColor(scannerStr.nextLine());

        System.out.print("material: ");
        label.setMaterial(scannerStr.nextLine());

        System.out.println("Object created:");


        LABEL_SERVICE.add(label);
    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by product name
                            2. Search by description
                            3. Search by brand name
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.print("Enter  product name ");
                String productN = scannerStr.nextLine();

                ArrayList<Label> labels = LABEL_SERVICE.getByProductN(productN);
                if(labels.isEmpty()){
                    System.out.println("No label");
                }else {
                    for (Label label : labels) {
                        System.out.println(label.toString());
                        System.out.println("----------------------------------------------------------------------");
                    }
                }
            }
            case 2->{
                System.out.print("Enter  description");
                String description = scannerStr.nextLine();

                ArrayList<Label> labels = LABEL_SERVICE.getByDescription(description);
                if(labels.isEmpty()){
                    System.out.println("No label");
                }else {
                    for (Label label : labels) {
                        System.out.println(label.toString());
                        System.out.println("----------------------------------------------------------------------");
                    }
                }
            }
            case 3->{
                System.out.print("Enter  brand name ");
                String brandName = scannerStr.nextLine();

                ArrayList<Label> labels = LABEL_SERVICE.getBybrandName(brandName);
                if(labels.isEmpty()){
                    System.out.println("No label");
                }else {
                    for (Label label : labels) {
                        System.out.println(label.toString());
                        System.out.println("----------------------------------------------------------------------");
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
