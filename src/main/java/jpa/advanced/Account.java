/**
 *
 */
package jpa.advanced;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cristian
 *
 */
@Getter 
@Setter
@ToString(exclude = "person")
@Entity
@Table(name = "accounts")
public class Account {

  @Id @GeneratedValue
  private Long id;

  private String username;

  @OneToOne(mappedBy = "account")
  private PersonWithAccount person;
}
