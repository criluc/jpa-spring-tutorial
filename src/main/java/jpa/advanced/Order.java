/**
 *
 */
package jpa.advanced;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Getter @Setter
@Entity
@Table(name = "orders")
public class Order {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
      orphanRemoval = true)
  private List<LineItem> lineItems = new ArrayList<>();
}
