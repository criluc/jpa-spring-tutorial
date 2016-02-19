package it.besmartbeopen.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.besmartbeopen.model.Person;

public class Queries {

  @PersistenceContext
  EntityManager entityManager;

  public List<Person> byName(String firstname) {
    return entityManager
        .createQuery("SELECT p FROM Person p WHERE p.firstname = :firstname",
            Person.class)
        .setParameter("firstname", firstname).getResultList();
  }
}
