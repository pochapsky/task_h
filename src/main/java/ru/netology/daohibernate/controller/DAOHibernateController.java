package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Person;
import ru.netology.daohibernate.repository.DAOHibernateRepository;


import java.util.List;

@RestController
public class DAOHibernateController {
    private final DAOHibernateRepository repository;

    public DAOHibernateController(DAOHibernateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return repository.getPersonsByCity(city);
    }
}
