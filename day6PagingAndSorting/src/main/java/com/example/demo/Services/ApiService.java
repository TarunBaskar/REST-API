package com.example.demo.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;


@Service
public class ApiService {
	@Autowired
	ChildRepo repository;
	
	public String addChildData(Child child) {
		repository.save(child);
		return "Child Data is Added";
	}
	
	public List<Child> getChildData(){
		return repository.findAll();
	}
	
	public  String updateChildData(Child child) {
		repository.save(child);
		return "ChildData is Updated";
	}
	public String deleteById(int id) {
		repository.deleteById(id);
		return "Child no "+id+" is Deleted";
	}
     
	//sorting
	public List<Child> getChildSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	//pagination
	public List<Child> getChildWithPagination( int offset,int pageSize){
		Page<Child> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	//sorting and paging
	public List<Child> getChildWithPagingAndSorting(int offset,int pageSize,String field){
		PageRequest paging =PageRequest.of(offset, pageSize,Sort.by(field));
		Page<Child> page = repository.findAll(paging);
		return page.getContent();
	}
}
