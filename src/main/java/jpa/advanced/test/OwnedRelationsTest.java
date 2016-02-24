/**
 *
 */
package jpa.advanced.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.assertj.core.api.Assertions.*;

import jpa.advanced.Account;
import jpa.advanced.PersonWithAccount;

/**
 * @author cristian
 *
 */
public class OwnedRelationsTest {

  private final static String PERSON_NAME = "Cristian";
  private final static String PERSON_SURNAME = "Lucchesi";

  private EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;
  private PersonWithAccount person;
  private Account account;


  @BeforeClass
  public void setup() {
    entityManagerFactory = Persistence.createEntityManagerFactory("test_unit");
    entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    person = new PersonWithAccount();
    person.setName(PERSON_NAME);
    person.setSurname(PERSON_SURNAME);
    entityManager.persist(person);
    account = new Account();
    account.setUsername("cristian.lucchesi");
    entityManager.persist(account);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  @AfterClass
  public void end() {
    entityManagerFactory.close();
  }

  @BeforeMethod
  public void beforeTest() {
    entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
  }

  @AfterMethod
  public void afterTest() {
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  @Test
  public void personSaved() {
    assertThat(person.getId()).isEqualTo(1L);
    assertThat(person.getName()).isEqualTo(PERSON_NAME);
    assertThat(person.getSurname()).isEqualTo(PERSON_SURNAME);
  }

  @Test(dependsOnMethods="testNotOwnedOneToOneSaved")
  public void testOwnedOneToOneSaved() {
    PersonWithAccount p = entityManager.merge(person);
    p.setAccount(account);
    entityManager.getTransaction().commit();

    entityManager.clear();

    entityManager.getTransaction().begin();

    PersonWithAccount pe = entityManager.find(PersonWithAccount.class, person.getId());
    assertThat(pe.getAccount()).isNotNull();
  }

  @Test
  public void testNotOwnedOneToOneSaved() {
    Account a = entityManager.merge(account);
    PersonWithAccount p = entityManager.merge(person);
    a.setPerson(p);
    entityManager.getTransaction().commit();

    entityManager.clear();

    entityManager.getTransaction().begin();

    PersonWithAccount pe = entityManager.find(PersonWithAccount.class, person.getId());
    assertThat(pe.getAccount()).isNull();
  }
}
