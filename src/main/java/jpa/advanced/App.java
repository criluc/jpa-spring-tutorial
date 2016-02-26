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
        Persistence.createEntityManagerFactory("test_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    PersonWithAccount person = entityManager.find(PersonWithAccount.class, 1L);
    System.out.println("person =" + person);

//    Account account = entityManager.find(Account.class, 1L);
//    System.out.println("account =" + account);
    entityManager.close();
    entityManagerFactory.close();

  }

  public static void createOrder() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("test_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Order order = new Order();
    entityManager.persist(order);
    entityManager.getTransaction().commit();
    entityManagerFactory.close();

  }
  public static void readOrder() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("test_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Order order = entityManager.find(Order.class, 1L);
    for (LineItem lineItem : order.getLineItems()) {
      System.out.println(
        String.format("Riga %s. %s: %s euro",
        lineItem.getId(), lineItem.getDescription(),lineItem.getAmount()));
    }
    entityManager.close();
    entityManagerFactory.close();
  }

  public static void unsavedTransientObject() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("test_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Order order = new Order();
    LineItem lineItem = new LineItem();
    lineItem.setOrder(order);
    entityManager.persist(lineItem);
    entityManager.persist(order);
    entityManager.getTransaction().commit();
    entityManagerFactory.close();
  }

  public static void cascadePersist() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("dev_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Order order = new Order();
    LineItem lineItem = new LineItem();
    lineItem.setOrder(order);
    order.getLineItems().add(lineItem);
    entityManager.persist(order);
    entityManager.getTransaction().commit();
    entityManagerFactory.close();
  }

  public static void cascadeDelete() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("dev_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Order order = entityManager.getReference(Order.class, 10L);
    entityManager.remove(order);
    entityManager.getTransaction().commit();
    entityManagerFactory.close();
  }

  public static void orphanRemoval() {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("dev_unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Order order = entityManager.getReference(Order.class, 11L);
    order.getLineItems().clear();
    entityManager.getTransaction().commit();
    entityManagerFactory.close();
  }

  public static void main(String[] args) {
    //readOneToOne();
    //createOrder();
    //readOrder();
    //unsavedTransientObject(
    //cascadePersist();
    //cascadeDelete();
    orphanRemoval();
  }
}
