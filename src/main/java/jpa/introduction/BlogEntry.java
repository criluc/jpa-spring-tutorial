package jpa.introduction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // obbligatorio sugli oggetti da persistere
public class BlogEntry {

  @Id // identifica la chiave primaria
  @GeneratedValue // indica che il valore è autogenerato dall'ORM/DB
  private Integer id;

  @Column(nullable=false) // indica che il valore è obbligatorio
  private String title;

  private String summary;

  private String body;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
}
