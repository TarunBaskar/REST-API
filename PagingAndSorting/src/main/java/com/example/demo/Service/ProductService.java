package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	public String addProduct(Product product) {
		repository.save(product);
		return "Product is Added";
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
     
	//sorting
	public List<Product> getProductSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	//pagination
	public List<Product> getProductWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		Page<Product> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	//sorting and paging
	public List<Product> getProductWithPagingAndSorting(int offset,int pageSize,String field){
		PageRequest paging =PageRequest.of(offset, pageSize,Sort.by(field));
		Page<Product> page = repository.findAll(paging);
		return page.getContent();
	}
}
