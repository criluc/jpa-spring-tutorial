package jpa.introduction;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BaseEntity {

  @Column(nullable=false)
  private String firstname;

  @Column(nullable=false)
  private String lastname;

  private String phone;

  private String email;
}
