package com.twu.biblioteca.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    BookList bookList;

    @Before
    public void setUp() throws Exception {
        bookList = new BookList();
    }

    @Test
    public void addBookShouldPutOneNewBookIntoBookList() {
        bookList.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));

        assertEquals(1, bookList.size());
    }

    @Test
    public void removeBookShouldHaveOneLessBookAfterRemoving() {
        addBookShouldPutOneNewBookIntoBookList();
        bookList.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        bookList.removeBook("Test-Driven Development");
        assertEquals(1, bookList.size());
    }

    @Test
    public void doesBookExistShouldReturnTrueIfBookIsInList() {
        addBookShouldPutOneNewBookIntoBookList();
        bookList.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));

        assertEquals(true, bookList.doesBookExist("Gears of War: Anvil Gate"));
    }

    @Test
    public void doesBookExistShouldReturnFalseIfBookIsInList() {
        addBookShouldPutOneNewBookIntoBookList();
        bookList.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));

        assertEquals(false, bookList.doesBookExist("Goats of War: Anvil Gate"));
    }
}