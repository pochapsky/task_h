package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.entity.Person;

import java.util.List;

@Repository
@Transactional
public class DAOHibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createNativeQuery("select * from person where city = :city", Person.class).
                setParameter("city", city).getResultList();
    }
}

