package com.example.client;

import com.example.dto.BookDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/books")
@RegisterRestClient
public interface BookClient {
    @GET
    public List<BookDTO> getAllBooks();
}
