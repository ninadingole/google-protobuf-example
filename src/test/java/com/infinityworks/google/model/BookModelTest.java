package com.infinityworks.google.model;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BookModelTest {

    @Test
    public void testBook() throws IOException {

        LibraryModel.Book book = LibraryModel.Book.newBuilder()
                .setIsbn("1213-2322-3212-1231")
                .setTitle("The Next Imaginary Book of My Mind")
                .addAuthor(LibraryModel.Book.Author.newBuilder().setName("Ninad").build())
                .setGenre(LibraryModel.Book.Genre.THRILLER)
                .build();

        assertEquals("1213-2322-3212-1231", book.getIsbn());
        assertEquals("The Next Imaginary Book of My Mind", book.getTitle());
        assertEquals(LibraryModel.Book.Genre.THRILLER, book.getGenre());
        assertEquals("Ninad", book.getAuthor(0).getName());

        LibraryModel.Library library = LibraryModel.Library.newBuilder().addBooks(book).build();
        FileOutputStream outputStream = new FileOutputStream("d:/data.dat");
        library.writeTo(outputStream);

        LibraryModel.Library parsedLibrary = LibraryModel.Library.parseFrom(new FileInputStream("d:/data.dat"));
        LibraryModel.Book book1 = parsedLibrary.getBooks(0);

        assertEquals("1213-2322-3212-1231", book1.getIsbn());
        assertEquals("The Next Imaginary Book of My Mind", book1.getTitle());
        assertEquals(LibraryModel.Book.Genre.THRILLER, book.getGenre());
        assertEquals("Ninad", book1.getAuthor(0).getName());

    }

}