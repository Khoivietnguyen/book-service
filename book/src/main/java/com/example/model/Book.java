package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
@Table(name = "t_books")
public class Book extends PanacheEntity {


  @Column(length = 100, nullable = false)
  public String title;

  @Column(length = 100, nullable = false)
  public String author;


  @Column(name = "nb_of_pages")
  public Integer nbOfPages;


  @Column(name = "year_pub")
  public Integer publicationYear;


  @Override
  public String toString() {
    return "Book{" +
      ", nbOfPages=" + nbOfPages +
      ", title='" + title + '\'' +
      ", id=" + id +
      '}';
  }
}
