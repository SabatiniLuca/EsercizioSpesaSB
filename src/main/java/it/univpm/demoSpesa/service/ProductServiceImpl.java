 package it.univpm.demoSpesa.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.demoSpesa.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<Integer,Product> prodList= new HashMap<>();
	
	
	public ProductServiceImpl() {
		
	}

	@Override
	public Collection<Product> getProducts() {
		return prodList.values();

	}

	@Override
	public void addArticle(Product product) {
		if(prodList.containsValue(product)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"existing pruduct..");
		}
		prodList.put(product.getId(), product);

	}

	@Override
	public void removeArticle(Product product) {
		if(prodList.containsValue(product)) {
			prodList.remove(product.getId(), product.getValue());
		}

	}

	@Override
	public int getTotal() {
		int somma=0;
		for (int i=0;i<prodList.size();i++) {
			somma+=prodList.get(i).getPrice();
		}
		return somma;
	}

}
