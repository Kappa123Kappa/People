package com.app.service.impl;

import com.app.dao.PeopleDao;
import com.app.model.People;
import com.app.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;


    @Override
    @Transactional
    public void addPeople(People people) {
        peopleDao.addPeople(people);
    }

    @Override
    public People getPeople(int id) {
        return peopleDao.getPeople(id);
    }

    @Override
    @Transactional
    public List<People> getAllPeople() {
        return peopleDao.getAllPeople();
    }

    @Override
    public People updatePeople(People people) {
        return peopleDao.updatePeople(people);
    }

    @Override
    @Transactional
    public void deletePeople(int id) {
        peopleDao.deletePeople(id);
    }
}
