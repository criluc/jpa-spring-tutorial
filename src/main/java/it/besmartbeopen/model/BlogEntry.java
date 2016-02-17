package it.besmartbeopen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table
public class BlogEntry {

  @Id @GeneratedValue
  private Integer id;

  @Column(nullable=false)
  private String title;

  private String summary;

  private String body;

  private Date date;
}
