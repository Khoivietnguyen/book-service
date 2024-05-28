package com.example.dto;

public class BookDTO {
    public Integer id;
    public String title;
    public String author;
    public Integer nbOfPages;
    public Integer publicationYear;

    public BookDTO() {

    }

    public BookDTO(int id, String title, String author, int nbOfPages, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.nbOfPages = nbOfPages;
        this.publicationYear = publicationYear;
    }
}
