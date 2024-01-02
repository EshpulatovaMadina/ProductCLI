package org.example.repository;

import org.example.models.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LabelRepo implements BaseRepo<Label>{
    String path = "src\\main\\resources\\label.json";
    @Override
    public Optional<Label> save(Label label) {
        ArrayList<Label> labels = (ArrayList<Label>) readFromFile(path, Label.class);
        labels.add(label);
        writeToFile(labels,path);
        return Optional.of(label);
    }



    @Override
    public List<Label> getAll() {
        return readFromFile(path, Label.class);
    }

    public ArrayList<Label> getByProduct(String productN) {

        ArrayList<Label> labels = (ArrayList<Label>) readFromFile(path, Label.class);
        if(labels.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Label> myLabel = new ArrayList<>();
        for (Label label : labels) {
            if(label.getProductName().contains(productN)){
                myLabel.add(label);
            }
        }
        return myLabel;
    }

    public ArrayList<Label> getByDescription(String description) {

        ArrayList<Label> labels = (ArrayList<Label>) readFromFile(path, Label.class);
        if(labels.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Label> myLabel = new ArrayList<>();
        for (Label label : labels) {
            if(label.getDescription().contains(description)){
                myLabel.add(label);
            }
        }
        return myLabel;
    }

    public ArrayList<Label> getBybrandName(String brandName) {
        ArrayList<Label> labels = (ArrayList<Label>) readFromFile(path, Label.class);
        if(labels.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Label> myLabel = new ArrayList<>();
        for (Label label : labels) {
            if(label.getBrandName().contains(brandName)){
                myLabel.add(label);
            }
        }
        return myLabel;
    }
}
