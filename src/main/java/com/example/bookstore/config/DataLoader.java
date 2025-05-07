package com.example.bookstore.config;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (authorRepository.count() > 0) {
            return;
        }

        // Create authors
        Author author1 = new Author(null, "J.K. Rowling", "jk@example.com", "British author best known for the Harry Potter series", null);
        Author author2 = new Author(null, "George Orwell", "orwell@example.com", "English novelist known for Animal Farm and 1984", null);
        Author author3 = new Author(null, "Jane Austen", "austen@example.com", "English novelist known for Pride and Prejudice", null);
        Author author4 = new Author(null, "Stephen King", "king@example.com", "American author of horror and supernatural fiction", null);
        Author author5 = new Author(null, "Agatha Christie", "christie@example.com", "English writer known for detective novels", null);
        Author author6 = new Author(null, "Mark Twain", "twain@example.com", "American writer and humorist", null);
        Author author7 = new Author(null, "Ernest Hemingway", "hemingway@example.com", "American novelist and short story writer", null);
        Author author8 = new Author(null, "Virginia Woolf", "woolf@example.com", "English writer and modernist", null);
        Author author9 = new Author(null, "Charles Dickens", "dickens@example.com", "English writer and social critic", null);
        Author author10 = new Author(null, "Leo Tolstoy", "tolstoy@example.com", "Russian writer regarded as one of the greatest authors", null);

        authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5, author6, author7, author8, author9, author10));

        // Create books
        Book book1 = new Book(null, "Harry Potter and the Philosopher's Stone", "9780747532743", 1997, 24.99, author1);
        Book book2 = new Book(null, "1984", "9780451524935", 1949, 15.99, author2);
        Book book3 = new Book(null, "Pride and Prejudice", "9780141439518", 1813, 12.99, author3);
        Book book4 = new Book(null, "The Shining", "9780307743657", 1977, 18.99, author4);
        Book book5 = new Book(null, "Murder on the Orient Express", "9780062693662", 1934, 14.99, author5);
        Book book6 = new Book(null, "Adventures of Huckleberry Finn", "9780486280615", 1884, 9.99, author6);
        Book book7 = new Book(null, "The Old Man and the Sea", "9780684801223", 1952, 11.99, author7);
        Book book8 = new Book(null, "To the Lighthouse", "9780156907392", 1927, 13.99, author8);
        Book book9 = new Book(null, "Great Expectations", "9780141439563", 1861, 10.99, author9);
        Book book10 = new Book(null, "War and Peace", "9781400079988", 1869, 22.99, author10);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
    }
} 