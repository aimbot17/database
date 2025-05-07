package com.example.bookstore.repository;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAllBooksWithAuthors() {
        // Create test data
        Author author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");
        author.setBiography("Test biography");
        entityManager.persist(author);

        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPublicationYear(2023);
        book.setPrice(19.99);
        book.setAuthor(author);
        entityManager.persist(book);
        
        entityManager.flush();

        // Test the custom query method
        List<Book> books = bookRepository.findAllBooksWithAuthors();
        
        assertThat(books).isNotEmpty();
        assertThat(books.get(0).getAuthor()).isNotNull();
        assertThat(books.get(0).getAuthor().getName()).isEqualTo("Test Author");
    }
} 