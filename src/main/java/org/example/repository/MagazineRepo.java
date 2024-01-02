package org.example.repository;

import org.example.models.Magazine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MagazineRepo implements BaseRepo<Magazine>{
    static String path = "src\\main\\resources\\magazine.json";
    @Override
    public Optional<Magazine> save(Magazine magazine) {
        final List<Magazine> magazines = readFromFile(path, Magazine.class);
        magazines.add(magazine);
        writeToFile(magazines,path);
        return Optional.of(magazine);
    }



    @Override
    public List<Magazine> getAll() {
        return readFromFile(path,Magazine.class);
    }

    public ArrayList<Magazine> getByTitle(String title) {
        ArrayList<Magazine> magazines = (ArrayList<Magazine>) readFromFile(path, Magazine.class);
        ArrayList<Magazine> myMagazines = new ArrayList<>();
        for (Magazine magazine : magazines) {
            if (magazine.getTitle().contains(title)) {
                myMagazines.add(magazine);
            }
        }
        return myMagazines;
    }

    public ArrayList<Magazine> getByPublisher(String publisher) {

        ArrayList<Magazine> magazines = new ArrayList<>();
        for (Magazine magazine : readFromFile(path, Magazine.class)) {
            if(magazine.getPublisher().contains(publisher)){
                magazines.add(magazine);
            }
        }
        return magazines;
    }

    public ArrayList<Magazine> getByDate(LocalDate date){
        ArrayList<Magazine> magazines = new ArrayList<>();
        for (Magazine magazine : readFromFile(path, Magazine.class)) {
            if(magazine.getIssueDate().equals(date)){
                magazines.add(magazine);
            }
        }
        return magazines;
    }
}
