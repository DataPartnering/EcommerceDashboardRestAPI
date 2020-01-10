package jsimmons.productfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsimmons.productfinal.model.Product;
import jsimmons.productfinal.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	  @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products")
	public List<Product> get(){
		return productService.get();
	}
	
	  @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/products")
	public Product save(@RequestBody Product productObj){
		 productService.save(productObj);
		 return productObj;
	}
	  
	  @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/products/{id}")
	public Product get(@PathVariable long id){
		Product productObj = productService.get(id);
		if(productObj == null) {
			throw new RuntimeException("Product with ID: " + id + " is not found");
		}
		return productObj;
	}
	  
	  @CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/products/{id}")
	public String delete(@PathVariable long id) {
		productService.delete(id);
		return ("Product Has Been Deleted with id: " + id);
	}
	  @CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/products")
	public Product update (@RequestBody Product productObj) {
		productService.save(productObj);
		return productObj;
	}
}
	
