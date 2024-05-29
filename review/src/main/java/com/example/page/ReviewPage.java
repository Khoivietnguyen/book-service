package com.example.page;

import com.example.ReviewRepository;
import com.example.ReviewResource;
import com.example.client.BookClient;
import com.example.dto.BookDTO;
import com.example.model.Review;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Path("/page/reviews")
@Produces(MediaType.TEXT_HTML)
@ApplicationScoped
public class ReviewPage {
    @Inject
    ReviewRepository repository;

    @Inject
    Logger logger;

    @RestClient
    BookClient bookClient;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance review(Review review);

        public static native TemplateInstance reviews(List<Review> reviews);
    }

    @GET
    public TemplateInstance showAllReviews() {
        List<BookDTO> books = ReviewResource.books;
        try {
            books = bookClient.getAllBooks();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Templates.reviews(repository.listAll()).data("books", books);
    }

}
