package org.example.repository;

import org.example.models.Business_card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Business_cardRepo implements BaseRepo<Business_card> {
    String path = "src\\main\\resources\\business_card.json";
    @Override
    public Optional<Business_card> save(Business_card businessCard) {
        ArrayList<Business_card> businessCards = (ArrayList<Business_card>) readFromFile(path, Business_card.class);
        businessCards.add(businessCard);
        writeToFile(businessCards,path);
        return Optional.of(businessCard);
    }



    @Override
    public List<Business_card> getAll() {
        return readFromFile(path,Business_card.class);
    }

    public ArrayList<Business_card> getByName(String name) {
        ArrayList<Business_card> businessCards = (ArrayList<Business_card>) readFromFile(path, Business_card.class);
        if(businessCards.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Business_card> myCards = new ArrayList<>();

        for (Business_card businessCard : businessCards) {
            if(businessCard.getName().contains(name)){
                myCards.add(businessCard);
            }
        }
        return myCards;
    }

    public ArrayList<Business_card> getByCompName(String compName) {
        ArrayList<Business_card> businessCards = (ArrayList<Business_card>) readFromFile(path, Business_card.class);
        if(businessCards.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Business_card> myCards = new ArrayList<>();

        for (Business_card businessCard : businessCards) {
            if(businessCard.getCompany_name().contains(compName)){
                myCards.add(businessCard);
            }
        }
        return myCards;
    }

    public ArrayList<Business_card> getByJobTitle(String jobTitle) {
        ArrayList<Business_card> businessCards = (ArrayList<Business_card>) readFromFile(path, Business_card.class);
        if(businessCards.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Business_card> myCards = new ArrayList<>();

        for (Business_card businessCard : businessCards) {
            if(businessCard.getJobTitle().contains(jobTitle)){
                myCards.add(businessCard);
            }
        }
        return myCards;
    }
}
