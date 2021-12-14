 package it.univpm.demoSpesa.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.demoSpesa.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<Integer,Product> prodList= new HashMap<>();
	private final AtomicLong counter=new AtomicLong();
	
	public ProductServiceImpl() {
		
	}

	@Override
	public Collection<Product> getProducts() {
		return prodList.values();

	}

	@Override
	public void addArticle(Product product) {
		if(prodList.containsValue(product.getValue())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"existing pruduct..");
		}
		prodList.put(product.getId(), product);

	}

	@Override
	public void removeArticle() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
