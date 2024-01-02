package org.example.service;

import org.example.models.Magazine;
import org.example.repository.MagazineRepo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MagazineService {
    MagazineRepo magazineRepo = new MagazineRepo();
    public ArrayList<Magazine> getByTitle(String title) {

        return magazineRepo.getByTitle(title);
    }

    public ArrayList<Magazine> getByPublisher(String publisher) {
        return magazineRepo.getByPublisher(publisher);
    }

    public ArrayList<Magazine> getByDate(LocalDate date) {
        return magazineRepo.getByDate(date);
    }

    public void add(Magazine magazine) {
        magazineRepo.save(magazine);
    }

    public ArrayList<Magazine> getAll() {
        return (ArrayList<Magazine>) magazineRepo.getAll();
    }
}
