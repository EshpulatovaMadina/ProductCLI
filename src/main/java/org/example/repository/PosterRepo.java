package org.example.repository;

import org.example.models.Poster;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PosterRepo implements BaseRepo<Poster> {
    String path = "src\\main\\resources\\poster.json";
    @Override
    public Optional<Poster> save(Poster poster) {
        ArrayList<Poster> posters = (ArrayList<Poster>) readFromFile(path, Poster.class);
        posters.add(poster);
        writeToFile(posters,path);
        return Optional.of(poster);
    }


    @Override
    public List<Poster> getAll() {
        return readFromFile(path, Poster.class);
    }

    public ArrayList<Poster> getByTitle(String title) {

        ArrayList<Poster> posters = (ArrayList<Poster>) readFromFile(path, Poster.class);
        if(posters.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<Poster> myPosters = new ArrayList<>();

        for (Poster poster : posters) {
            if(poster.getTitle().contains(title)){
                myPosters.add(poster);
            }
        }
        return myPosters;
    }

    public ArrayList<Poster> getByMessage(String message) {
        ArrayList<Poster> posters = (ArrayList<Poster>) readFromFile(path, Poster.class);
        if(posters.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<Poster> myPosters = new ArrayList<>();

        for (Poster poster : posters) {
            if(poster.getMessage().contains(message)){
                myPosters.add(poster);
            }
        }
        return myPosters;
    }
}
