package org.example.service;

import org.example.models.Business_card;
import org.example.repository.Business_cardRepo;

import java.util.ArrayList;

public class Business_cardService {
    Business_cardRepo businessCardRepo = new Business_cardRepo();

    public ArrayList<Business_card> getAll() {
        return (ArrayList<Business_card>) businessCardRepo.getAll();
    }

    public void add(Business_card businessCard) {
        businessCardRepo.save(businessCard);
    }

    public ArrayList<Business_card> getByName(String name) {
        return businessCardRepo.getByName(name);
    }

    public ArrayList<Business_card> getByCompName(String compName) {
        return businessCardRepo.getByCompName(compName);
    }

    public ArrayList<Business_card> getByJobTitle(String jobTitle) {

        return businessCardRepo.getByJobTitle(jobTitle);
    }
}
