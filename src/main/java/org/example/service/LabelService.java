package org.example.service;

import org.example.models.Label;
import org.example.repository.LabelRepo;

import java.util.ArrayList;

public class LabelService {
    LabelRepo labelRepo = new LabelRepo();

    public ArrayList<Label> getAll() {
        return (ArrayList<Label>) labelRepo.getAll();
    }

    public void add(Label label) {
        labelRepo.save(label);
    }

    public ArrayList<Label> getByProductN(String productN) {
        return labelRepo.getByProduct(productN);
    }

    public ArrayList<Label> getByDescription(String description) {
        return labelRepo.getByDescription(description);
    }

    public ArrayList<Label> getBybrandName(String brandName) {
        return labelRepo.getBybrandName(brandName);
    }
}
