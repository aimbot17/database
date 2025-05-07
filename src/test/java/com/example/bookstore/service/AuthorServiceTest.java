package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.repository.AuthorRepository;
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

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAuthors() {
        // Setup
        Author author1 = new Author();
        author1.setId(1L);
        author1.setName("Author 1");
        
        Author author2 = new Author();
        author2.setId(2L);
        author2.setName("Author 2");
        
        List<Author> expectedAuthors = Arrays.asList(author1, author2);
        
        when(authorRepository.findAll()).thenReturn(expectedAuthors);

        // Execute
        List<Author> actualAuthors = authorService.getAllAuthors();

        // Verify
        assertThat(actualAuthors).isEqualTo(expectedAuthors);
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    public void testGetAuthorById() {
        // Setup
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");
        
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        // Execute
        Optional<Author> foundAuthor = authorService.getAuthorById(1L);

        // Verify
        assertThat(foundAuthor).isPresent();
        assertThat(foundAuthor.get()).isEqualTo(author);
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveAuthor() {
        // Setup
        Author author = new Author();
        author.setName("New Author");
        
        when(authorRepository.save(any(Author.class))).thenReturn(author);

        // Execute
        Author savedAuthor = authorService.saveAuthor(author);

        // Verify
        assertThat(savedAuthor).isEqualTo(author);
        verify(authorRepository, times(1)).save(author);
    }
} 