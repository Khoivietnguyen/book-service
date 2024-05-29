package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_reviews")
public class Review extends PanacheEntity {
    @Column(length = 300, nullable = false)
    public String review;

    @Column(name = "score")
    public Integer score;


    @Column(name = "book_id")
    public Integer bookId;

}
