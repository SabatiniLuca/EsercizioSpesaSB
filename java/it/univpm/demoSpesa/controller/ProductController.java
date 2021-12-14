package it.univpm.demoSpesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpesa.model.Product;
import it.univpm.demoSpesa.service.ProductService;
import it.univpm.demoSpesa.service.ProductServiceImpl;

@RestController
public class ProductController {
@Autowired
ProductService productService;
	
	@RequestMapping(value="/prodotti")
	public ResponseEntity<Object> getPruducts(){
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/prodotti", method= RequestMethod.PUT)
	public ResponseEntity<Object> addArticle(@RequestBody Product product){
		productService.addArticle(product);
		return new ResponseEntity<>("Product added succesfully", HttpStatus.OK);
	}
	
	@RequestMapping(value="/prodotti", method=RequestMethod.DELETE)
	public ResponseEntity<Object> removeArticle(@RequestBody Product product){
		removeArticle(product);
		return new ResponseEntity<>("Product removed succesfully", HttpStatus.OK);
	}
	
	@RequestMapping(value="/prodotti",method=RequestMethod.GET)
	public ResponseEntity<Object> getTotal(){
		return new ResponseEntity<>(getTotal(),HttpStatus.OK);
	}
}
