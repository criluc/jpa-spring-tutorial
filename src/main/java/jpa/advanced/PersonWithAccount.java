/**
 *
 */
package jpa.advanced;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author cristian
 *
 */
@Data
@Entity @Table(name = "persons")
public class PersonWithAccount {
  @Id @GeneratedValue
  private Long id;

  private String name;

  private String surname;

  @OneToOne
  @JoinColumn(name = "account_id")
  @NotNull
  private Account account;
}
