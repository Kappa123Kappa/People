package com.app.dao;

import com.app.model.People;

import java.util.List;

public interface PeopleDao {

    public void addPeople(People people);

    public People getPeople(int id);

    public List<People> getAllPeople();

    public People updatePeople(People people);

    public void deletePeople(int id);

}
