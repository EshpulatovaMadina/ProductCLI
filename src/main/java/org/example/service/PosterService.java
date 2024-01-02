package org.example.service;

import org.example.models.Poster;
import org.example.repository.PosterRepo;

import java.util.ArrayList;

public class PosterService {
    PosterRepo posterRepo = new PosterRepo();

    public ArrayList<Poster> getAll() {
        return (ArrayList<Poster>) posterRepo.getAll();
    }

    public void add(Poster poster) {
        posterRepo.save(poster);
    }

    public ArrayList<Poster> getByTitle(String title) {
        return posterRepo.getByTitle(title);
    }

    public ArrayList<Poster> getByMessage(String message) {
        return posterRepo.getByMessage(message);
    }
}