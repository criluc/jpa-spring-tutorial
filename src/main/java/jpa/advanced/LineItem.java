/**
 *
 */
package jpa.advanced;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Data
@Entity
@Table(name = "order_line_items")
public class LineItem {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private BigDecimal amount;

  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id")
  private Order order;
}
