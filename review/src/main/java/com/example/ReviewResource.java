package com.example;

import com.example.client.BookClient;
import com.example.dto.BookDTO;
import com.example.model.Review;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
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

    public static List<BookDTO> books = List.of(new BookDTO(1, "Understanding Quarkus", "Antonio", 200,2020),
            new BookDTO(4, "Thinking in Java", "Bruce Eckel", 324,1998));

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
    //@Consumes(MediaType.APPLICATION_JSON)
    //public Response addReview(Review review, @Context UriInfo uriInfo) {
    public Response addReview(@FormParam("review")String review, @FormParam("score")Integer score, @FormParam("bookId") Integer bookId) {
        //logger.info(review);
        System.out.println("review:" + review +", score:" + score +", book id:" + bookId);
        Review rec = new Review();
        rec.review = review;
        rec.score = score;
        rec.bookId = bookId;
        System.out.println("review:" + rec);
        repository.addReview(rec);
//        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(review.id));
//        return Response.created(builder.build()).build();
        return Response.ok().build();
    }

    @GET
    @Path("/book/{id}")
    public BookDTO getDetail(@PathParam("id") Integer bookId) {
        System.out.println("Getting detail for book: " + bookId);
        List<BookDTO> books = ReviewResource.books;
        try {
            books = bookClient.getAllBooks();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println("Book list:" + books);
        BookDTO book = books.stream()
                .filter(abook -> abook.id.equals(bookId))
                .findAny()
                .orElse(null);
//        System.out.println("Book found:" + book);
        return book;

    }
}
