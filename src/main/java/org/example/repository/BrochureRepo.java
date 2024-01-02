package org.example.repository;

import org.example.models.Brochure;
import org.example.models.enums.PaperType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrochureRepo implements BaseRepo<Brochure> {
    static String path = "src\\main\\resources\\brochure.json";
    @Override
    public Optional<Brochure> save(Brochure brochure) {
        ArrayList<Brochure> brochures = (ArrayList<Brochure>) readFromFile(path, Brochure.class);
        brochures.add(brochure);
        writeToFile(brochures,path);
        return Optional.of(brochure);
    }



    @Override
    public List<Brochure> getAll() {
        return readFromFile(path, Brochure.class);
    }

    public ArrayList<Brochure> getByTitle(String title) {
        ArrayList<Brochure> brochuresAll = (ArrayList<Brochure>) readFromFile(path, Brochure.class);
        if(brochuresAll.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Brochure> brochures = new ArrayList<>();

        for (Brochure brochure : brochuresAll) {
            if(brochure.getTitle().equals(title)){
                brochures.add(brochure);
            }
        }
        return brochures;
    }

    public ArrayList<Brochure> getByTarget(String target) {
        ArrayList<Brochure> brochuresAll = (ArrayList<Brochure>) readFromFile(path, Brochure.class);
        if(brochuresAll.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Brochure> brochures = new ArrayList<>();

        for (Brochure brochure : brochuresAll) {
            if(brochure.getTargetAudience().equals(target)){
                brochures.add(brochure);
            }
        }
        return brochures;
    }

    public ArrayList<Brochure> getByPaperType(PaperType paperType) {
        ArrayList<Brochure> brochuresAll = (ArrayList<Brochure>) readFromFile(path, Brochure.class);
        if(brochuresAll.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Brochure> brochures = new ArrayList<>();

        for (Brochure brochure : brochuresAll) {
            if(brochure.getPaperType().equals(paperType)){
                brochures.add(brochure);
            }
        }
        return brochures;
    }
}
