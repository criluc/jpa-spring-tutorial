package criteriaquery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import jpa.advanced.Account;
import jpa.advanced.Account_;
import jpa.advanced.PersonWithAccount;
import jpa.advanced.PersonWithAccount_;

public class Queries {

  private static EntityManagerFactory entityManagerFactory;

  //Singleton
  private EntityManagerFactory getEntityManagerFactory() {
    if (entityManagerFactory == null) {
      entityManagerFactory = Persistence.createEntityManagerFactory("dev_unit"); 
    }
    return entityManagerFactory;
  }

  private EntityManager getEntityManager() {
    return getEntityManagerFactory().createEntityManager();
  }
 
  public List<PersonWithAccount> allPersons() {
    CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<PersonWithAccount> criteriaQuery = 
        builder.createQuery(PersonWithAccount.class);
    Root<PersonWithAccount> pe = criteriaQuery.from(PersonWithAccount.class);
    return getEntityManager().createQuery(criteriaQuery.select(pe)).getResultList();
  }
  
  public List<PersonWithAccount> byName(String name) {
    CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<PersonWithAccount> criteriaQuery = 
        builder.createQuery(PersonWithAccount.class);
    Root<PersonWithAccount> pe = criteriaQuery.from(PersonWithAccount.class);
    criteriaQuery.select(pe).where(builder.equal(pe.get(PersonWithAccount_.name), name));
    return getEntityManager().createQuery(criteriaQuery.where()).getResultList();
  }

  public List<PersonWithAccount> join(String username) {
    CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<PersonWithAccount> criteriaQuery = 
        builder.createQuery(PersonWithAccount.class);
    Root<PersonWithAccount> pe = criteriaQuery.from(PersonWithAccount.class);
    Join<PersonWithAccount, Account> join = pe.join(PersonWithAccount_.account);
    
    criteriaQuery.select(pe).where(builder.equal(join.get(Account_.username), username));
    return getEntityManager().createQuery(criteriaQuery.where()).getResultList();
  }
  public static void main(String[] args) {
    Queries q = new Queries();
    System.out.println("allPersons() = " + q.allPersons());
    System.out.println("byName(\"Cristian\") = " + q.byName("Cristian"));
    System.out.println("join(\"cristian.lucchesi\") = " + q.join("cristian.lucchesi"));
    q.getEntityManagerFactory().close();
  }
  
}
