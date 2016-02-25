/**
 *
 */
package jpa.advanced;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author cristian
 *
 */
@Data
@Entity
public class LineItem {

  @Id @GeneratedValue
  private Long id;

  private String description;

  private BigDecimal amount;

  @ManyToOne(optional = false)
  private Order order;
}
