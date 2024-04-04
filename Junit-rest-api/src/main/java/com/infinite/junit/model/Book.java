package com.infinite.junit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "book_record")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String summary;
	
	private int rating;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Book(Long bookId, @NonNull String name, @NonNull String summary, int rating) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.summary = summary;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", summary=" + summary + ", rating=" + rating + "]";
	}
	
	public Book() {
		
	}
	
	
	
}
