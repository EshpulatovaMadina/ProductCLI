package org.example.repository;

import org.example.models.Packaging;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PackagingRepo implements BaseRepo<Packaging>{
    String path = "src\\main\\resources\\packaging.json";

    @Override
    public Optional<Packaging> save(Packaging packaging) {
        ArrayList<Packaging> packagings = (ArrayList<Packaging>) readFromFile(path, Packaging.class);
        packagings.add(packaging);
        writeToFile(packagings,path);
        return Optional.of(packaging);
    }



    @Override
    public List<Packaging> getAll() {
        return readFromFile(path, Packaging.class);
    }

    public ArrayList<Packaging> getByName(String name) {

        ArrayList<Packaging> packagings = (ArrayList<Packaging>) readFromFile(path, Packaging.class);
        if(packagings.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Packaging> myPackagings = new ArrayList<>();

        for (Packaging packaging : packagings) {
            if(packaging.getProductName().contains(name)){
                myPackagings.add(packaging);
            }
        }
        return myPackagings;
    }

    public ArrayList<Packaging> getByBrand(String brand) {
        ArrayList<Packaging> packagings = (ArrayList<Packaging>) readFromFile(path, Packaging.class);
        if(packagings.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Packaging> myPackagings = new ArrayList<>();

        for (Packaging packaging : packagings) {
            if(packaging.getBrandName().contains(brand)){
                myPackagings.add(packaging);
            }
        }
        return myPackagings;
    }

    public ArrayList<Packaging> getByColor(String color) {
        ArrayList<Packaging> packagings = (ArrayList<Packaging>) readFromFile(path, Packaging.class);
        if(packagings.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Packaging> myPackagings = new ArrayList<>();

        for (Packaging packaging : packagings) {
            if(packaging.getColor().contains(color)){
                myPackagings.add(packaging);
            }
        }
        return myPackagings;
    }
}
