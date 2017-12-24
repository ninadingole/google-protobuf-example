package com.infinityworks.google.model;

import junit.framework.Assert;

import java.io.IOException;
import java.io.Serializable;

public class App implements Serializable {

    public static void main(String args[]) throws IOException {
        LibraryModel.Book book = LibraryModel.Book.newBuilder()
                .setIsbn("1213-2322-3212-1231")
                .setTitle("The Next Imaginary Book of My Mind")
                .addAuthor(LibraryModel.Book.Author.newBuilder().setName("Ninad").build())
                .setGenre(LibraryModel.Book.Genre.THRILLER)
                .build();

        Assert.assertEquals("1213-2322-3212-1231", book.getIsbn());
        Assert.assertEquals("The Next Imaginary Book of My Mind", book.getTitle());


    }
}
