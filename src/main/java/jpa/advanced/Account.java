/**
 *
 */
package jpa.advanced;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {

  @Id @GeneratedValue
  private Long id;

  private String username;

  @OneToOne(mappedBy = "account")
  private PersonWithAccount person;
}
