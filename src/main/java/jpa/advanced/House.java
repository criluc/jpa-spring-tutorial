/**
 *
 */
package jpa.advanced;

import lombok.Getter;
import lombok.Setter;

import org.testng.collections.Lists;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Getter
@Setter
@Entity
@Table(name = "houses")
public class House {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Targa
  private String address;

  @ManyToMany
  @JoinTable(name = "persons_houses",
      joinColumns = @JoinColumn(name = "house_id"),
      inverseJoinColumns = @JoinColumn(name="person_id") )
  private List<PersonWithAccount> owners = Lists.newArrayList();
}
