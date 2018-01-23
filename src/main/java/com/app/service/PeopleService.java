package com.app.service;


import com.app.model.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeopleService {
    public void addPeople(People people);

    public People getPeople(int id);

    public List<People> getAllPeople();

    public People updatePeople(People people);

    public void deletePeople(int id);
}
