package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libSystem;

    @Before
    public void setup() {
        libSystem = new LibraryManagementSystem();
        libSystem.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));
        libSystem.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        libSystem.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        libSystem.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
    }

    @Test
    public void addBookShouldPutNewBookIntoAvailableBookList() {
        assertEquals(4, libSystem.getNumberOfAvailableBooks());
    }

    @Test
    public void generateBooksDisplayShouldShowAllTitlesAuthorsAndPublishYear() {
        assertEquals("Title | Author | Year Published\n" +
                     "Test-Driven Development | Kent Beck | 2003\n" +
                     "Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n",
                     libSystem.generateBooksDisplay());
    }

    @Test
    public void checkoutBookShouldDisplayThankYouMessageOnSuccessfulCheckout() {
        assertEquals("\nThank you! Enjoy the book.\n",
                libSystem.checkoutBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void checkoutBookShouldDisplayBookNotFoundMsgOnUnsuccessfulCheckout() {
        assertEquals("\nThat book is not available.\n",
                libSystem.checkoutBook("Non-existent book"));
    }

    @Test
    public void returnBookShouldDisplayThankYouMsgOnSuccessfulReturn() {
        libSystem.checkoutBook("Gears of War: Anvil Gate");

        assertEquals("\nThank you for returning the book.\n",
                libSystem.returnBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void returnBookShouldDisplayBookUnavailableMsgOnInvalidBookName() {
        libSystem.checkoutBook("Gears of War: Anvil Gate");

        assertEquals("\nThat is not a valid book to return.\n",
                libSystem.returnBook("Goats of War: Manvil Grate"));
    }

    @Test
    public void addUserShouldIncrementUserListSizeByOneOnSuccessfulAdd() {
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "000-0001",
                "64 digit hash"));

        assertEquals(1, libSystem.getNumberOfUsers());
    }

    @Test
    public void generateUserInfoDisplayShouldReturnCurrentUserInformation() {
        User currentUser = new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "0411262811", "000-0001",
                "64 digit hash");
        libSystem.addUser(currentUser);
        libSystem.setCurrentUser(currentUser);

        assertEquals("Name: Bojack Horseman\n" +
                     "E-mail: micro@Gmail.com\n" +
                     "Phone: 0411262811", libSystem.generateUserInfoDisplay());
    }

    @Test
    public void addMovieShouldPutNewMovieIntoAvailableMoviesList() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(1, libSystem.getNumberOfAvailableMovies());
    }

    @Test
    public void generateMoviesDisplayShouldReturnHeaderAndListOfMovies() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals("Name | Year | Director | Rating\n" +
                     "The Bee Movie | 1998 | Edgar Wright | 1\n",
                     libSystem.generateMoviesDisplay());
    }

}