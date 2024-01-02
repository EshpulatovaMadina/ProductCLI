package org.example.service;

import org.example.models.Packaging;
import org.example.repository.PackagingRepo;

import java.util.ArrayList;

public class PackagingService {
    PackagingRepo packagingRepo = new PackagingRepo();
    public ArrayList<Packaging> getAll() {
        return (ArrayList<Packaging>) packagingRepo.getAll();
    }

    public void add(Packaging packaging) {
        packagingRepo.save(packaging);
    }

    public ArrayList<Packaging> getByName(String name) {
        return packagingRepo.getByName(name);
    }

    public ArrayList<Packaging> getByBrand(String brand) {
        return packagingRepo.getByBrand(brand);
    }

    public ArrayList<Packaging> getByColor(String color) {
        return packagingRepo.getByColor(color);
    }
}
