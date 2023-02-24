package com.example.demo.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Models.Child;
import com.example.demo.Services.ApiService;



@RestController
public class ApiController{
	@Autowired
	ApiService service;
	
	@GetMapping("/child")
	public List<Child> childData(){
		return service.getChildData();
	}
	
	@PostMapping("/child")
	public String addChildData(@RequestBody Child child) {
		service.addChildData(child);
		return "Product Added "+child.getBabyId();
	}
	
	@PutMapping("/child")
	public String update(@RequestBody Child child) {
		return service.updateChildData(child);
	}
	
	@DeleteMapping("/child")
	public String delete(@RequestParam int id) {
		return service.deleteById(id);
	}
	//Sorting
	@GetMapping("/child/{field}")
	public List<Child> childWithSort(@PathVariable String field){
		return service.getChildSorted(field);
	}
	 //pagination
	@GetMapping("/child/{offset}/{pageSize}")
	public List<Child> childWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		return service.getChildWithPagination(offset,pageSize);
	}
	
	
	//sorting and paging
	@GetMapping("/child/{offset}/{pageSize}/{field}")
	public List<Child> getChildWithPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return service.getChildWithPagingAndSorting(offset,pageSize,field);
	}
}
