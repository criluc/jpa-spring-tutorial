/**
 *
 */
package jpa.advanced;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author cristian
 *
 */
public class App {

  public static void tryOwningSide() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("dev_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    PersonWithAccount person = entityManager.find(PersonWithAccount.class, 1L);
    System.out.println("person =" + person);

    Account account = entityManager.find(Account.class, 1L);
    System.out.println("account =" + account);

    account.setPerson(person);
    //person.setAccount(account);
    entityManager.getTransaction().commit();
    entityManager.merge(person);
    entityManagerFactory.close();
    
  }
  
  public static void readOneToOne() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("dev_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    PersonWithAccount person = entityManager.find(PersonWithAccount.class, 1L);
    System.out.println("person =" + person);

//    Account account = entityManager.find(Account.class, 1L);
//    System.out.println("account =" + account);
    entityManager.close();
    entityManagerFactory.close();
    
  }
  public static void main(String[] args) {
    readOneToOne();
  }
}
