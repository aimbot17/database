package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // Setup
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book 1");
        
        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book 2");
        
        List<Book> expectedBooks = Arrays.asList(book1, book2);
        
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Execute
        List<Book> actualBooks = bookService.getAllBooks();

        // Verify
        assertThat(actualBooks).isEqualTo(expectedBooks);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllBooksWithAuthors() {
        // Setup
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");
        
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor(author);
        
        List<Book> expectedBooks = Arrays.asList(book);
        
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(expectedBooks);

        // Execute
        List<Book> actualBooks = bookService.getAllBooksWithAuthors();

        // Verify
        assertThat(actualBooks).isEqualTo(expectedBooks);
        assertThat(actualBooks.get(0).getAuthor()).isNotNull();
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    public void testSaveBook() {
        // Setup
        Book book = new Book();
        book.setTitle("New Book");
        
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Execute
        Book savedBook = bookService.saveBook(book);

        // Verify
        assertThat(savedBook).isEqualTo(book);
        verify(bookRepository, times(1)).save(book);
    }
} 