package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRepo;

@Service
public class ApiService {
	@Autowired
	BookRepo repository;
	
	public String addBook(Book book) {
		repository.save(book);
		return "Book is Added";
	}
	public List<Book> getBook(){
		return(List<Book>)repository.findAll();
	}
	public Optional<Book> getBookByID(int id){
		return repository.findById(id);
	}
	
	public  String updateBook(Book book) {
		repository.save(book);
		return "Book is Updated";
	}
	public String deleteById(int id) {
		repository.deleteById(id);
		return "Book no "+id+" is Deleted";
	}
}
