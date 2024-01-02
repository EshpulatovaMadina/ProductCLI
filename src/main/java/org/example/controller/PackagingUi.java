package org.example.controller;
import org.example.models.Packaging;

import java.util.ArrayList;

import static org.example.util.Util.*;

public class PackagingUi {
    public static void create() {
        Packaging packaging = new Packaging();

        System.out.print("Product name: ");
        packaging.setProductName(scannerStr.nextLine());

        System.out.print("Brand name: ");
        packaging.setBrandName(scannerStr.nextLine());

        boolean validSize = false;
        while (!validSize) {
            System.out.print("Size (format: num x num): ");
            String sizeInput = scannerStr.nextLine();

            if (sizeInput.matches("\\d+x\\d+")) {
                packaging.setSize(sizeInput);
                validSize = true;
            } else {
                System.out.println("Wrong format of size !");
            }
        }

        System.out.print("Shape: ");
        packaging.setShape(scannerStr.nextLine());

        System.out.print("Colour: ");
        packaging.setColor(scannerStr.nextLine());

        System.out.print("Material: ");
        packaging.setMaterial(scannerStr.nextLine());

        System.out.print("Graphics: ");
        packaging.setGraphics(scannerStr.nextLine());

        System.out.print("Text: ");
        packaging.setText(scannerStr.nextLine());

        PACKAGING_SERVICE.add(packaging);

        System.out.println("successfully created ");
    }

    public static void search() {
        int k = 0;
        System.out.println("""
                            1. Search by product name
                            2. Search by brand name
                            3. Search by color
                            0. Back
                            """);
        k = scannerNum.nextInt();
        switch (k){
            case 1 ->{
                System.out.print(" Enter name : ");
                String name = scannerStr.nextLine();
                ArrayList<Packaging> packagings = PACKAGING_SERVICE.getByName(name);
                if(packagings.isEmpty()){
                    System.out.println("No magazine found");
                    return;
                }
                for (Packaging packaging : packagings) {
                    System.out.println(packaging.toString());
                    System.out.println("---------------------------------------------------------------------------");
                }
            }
            case 2 ->{
                System.out.print(" Enter brand name : ");
                String brand = scannerStr.nextLine();
                ArrayList<Packaging> packagings = PACKAGING_SERVICE.getByBrand(brand);
                if(packagings.isEmpty()){
                    System.out.println("No magazine found");
                    return;
                }
                for (Packaging packaging : packagings) {
                    System.out.println(packaging.toString());
                    System.out.println("---------------------------------------------------------------------------");
                }
            }
            case 3 ->{
                System.out.print(" Enter color : ");
                String color = scannerStr.nextLine();
                ArrayList<Packaging> packagings = PACKAGING_SERVICE.getByColor(color);
                if(packagings.isEmpty()){
                    System.out.println("No magazine found");
                    return;
                }
                for (Packaging packaging : packagings) {
                    System.out.println(packaging.toString());
                    System.out.println("---------------------------------------------------------------------------");
                }
            }
            default -> {
                System.out.println("Unexpected value: " + k);
                search();
            }
        }
    }
}
