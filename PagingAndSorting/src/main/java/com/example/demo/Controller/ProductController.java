package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/product")
	public List<Product> products(){
		return service.getProducts();
	}
	
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		service.addProduct(product);
		return "Product Added "+product.getId();
	}
	
	//Sorting
	@GetMapping("/product/{field}")
	public List<Product> produictWithSort(@PathVariable String field){
		return service.getProductSorted(field);
	}
	 //pagination
	@GetMapping("/product/{offset}/{pageSize}")
	public List<Product> productWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		return service.getProductWithPagination(offset,pageSize);
	}
	
	//sorting and paging
	@GetMapping("/product/{offset}/{pageSize}/{field}")
	public List<Product> getProductsWithPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return service.getProductWithPagingAndSorting(offset,pageSize,field);
	}
}
