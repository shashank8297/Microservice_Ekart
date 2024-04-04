package com.infinite.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.infinite.junit.controller.BookController;
import com.infinite.junit.model.Book;
import com.infinite.junit.repository.BooksRepository;


@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private BooksRepository bookRepository;
	
	@InjectMocks
	private BookController bookController;
	
	Book DATA_1 = new Book(1L, "Atomic Habits", "How to build better habits", 5);
	Book DATA_2 = new Book(2L, "Thinking Fast and Slow", "How to create good mental models about thinking", 5);
	Book DATA_3 = new Book(3L, "Game of Throns", "Noble families in the fictional continent of Westeros fight to control the Iron Throne.", 5);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	@Test
	public void getAllRecorder_success() throws Exception {
		List<Book> records = new ArrayList<>(Arrays.asList(DATA_1, DATA_2, DATA_3));
		
		 Mockito.when(bookRepository.findAll()).thenReturn(records);
		 
		 mockMvc.perform(MockMvcRequestBuilders
				 .get("/book/allbooks")
				 .contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
		 		.andExpect(MockMvcResultMatchers.jsonPath("$[2].name", is("Game of Throns")));
		 		//.andExpect(MockMvcResultMatchers.jsonPath("$[2].name", is("Game of Throns")));
	}
	
	@Test
	public void getBookById_success() throws Exception {
		Mockito.when(bookRepository.findById(DATA_1.getBookId())).thenReturn(Optional.of(DATA_1));
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/book/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.name", is("Atomic Habits")));
		
	}
	
//	@Test
//	public void addingNewBook_success() throws Exception {
//		
//		Book data = Book.
//		
//	}
}
