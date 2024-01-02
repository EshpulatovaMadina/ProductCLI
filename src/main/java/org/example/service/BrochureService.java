package org.example.service;

import org.example.models.Brochure;
import org.example.models.enums.PaperType;
import org.example.repository.BrochureRepo;

import java.util.ArrayList;

public class BrochureService {
    BrochureRepo brochureRepo = new BrochureRepo();
    public ArrayList<Brochure> getByTitle(String title) {
        return brochureRepo.getByTitle(title);
    }

    public ArrayList<Brochure> getByTarget(String target) {
        return brochureRepo.getByTarget(target);
    }



    public ArrayList<Brochure> getByPaperType(PaperType paperType) {
        return brochureRepo.getByPaperType(paperType);
    }

    public ArrayList<Brochure> getAll() {
        return (ArrayList<Brochure>) brochureRepo.getAll();
    }

    public void add(Brochure brochure) {
        brochureRepo.save(brochure);
    }
}
