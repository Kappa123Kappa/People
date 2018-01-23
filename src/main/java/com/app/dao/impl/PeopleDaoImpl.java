package com.app.dao.impl;

import com.app.dao.PeopleDao;
import com.app.model.People;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class PeopleDaoImpl implements PeopleDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPeople(People people) {
        sessionFactory.getCurrentSession().saveOrUpdate(people);
    }

    @Override
    public People getPeople(int id) {
        return (People) sessionFactory.getCurrentSession().get(
                People.class, id);
    }


    @SuppressWarnings("unchecked")
    public List<People> getAllPeople() {
        List<People> people =  sessionFactory.getCurrentSession().createQuery("from People ")
                .list();
        return people;
    }

    @Override
    public People updatePeople(People people) {
        sessionFactory.getCurrentSession().update(people);
        return people;
    }

    @Override
    public void deletePeople(int id) {
        People people = (People) sessionFactory.getCurrentSession().load(
                People.class, id);
        this.sessionFactory.getCurrentSession().delete(people);
    }
}
