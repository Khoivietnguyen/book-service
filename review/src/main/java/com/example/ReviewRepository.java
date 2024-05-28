package com.example;

import com.example.model.Review;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Review> {
    public List<Review> getAllReviews() {

        return listAll();
    }

    public void addReview(Review review) {
        Review.persist(review);
//        return review;
    }

}
