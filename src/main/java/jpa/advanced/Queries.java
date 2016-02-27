package jpa.advanced;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Queries {

  @PersistenceContext
  EntityManager entityManager;
  
  public List<PersonWithAccount> havingHouse(House house) {
    return entityManager.createQuery(
        "SELECT p FROM Person JOIN p.houses"
        + " WHERE p.house = :house", PersonWithAccount.class)
    .setParameter("house", house)
    .getResultList();
  }
}
