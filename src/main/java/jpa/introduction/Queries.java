package jpa.introduction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
