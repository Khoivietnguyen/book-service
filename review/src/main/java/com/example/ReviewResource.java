package com.example;

import com.example.client.BookClient;
import com.example.dto.BookDTO;
import com.example.model.Review;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/reviews")
public class ReviewResource {

    @Inject
    ReviewRepository repository;

    @Inject
    Logger logger;

    @RestClient
    BookClient bookClient;

    @GET
    public List<Review> getAllReviews() {
//        logger.info("Returns all the review");
//        logger.info(bookClient.getAllBooks());
//        List<BookDTO> books = bookClient.getAllBooks();
//        for (BookDTO book: books) {
//            logger.info(book.author);
//        }
        return repository.getAllReviews();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReview(Review review) {
        logger.info(review);
        repository.addReview(review);
        return Response.ok().build();
    }
}
