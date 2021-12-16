package it.univpm.demoSpesa.service;

import java.util.Collection;

import it.univpm.demoSpesa.model.Product;

/**
 * 
 * @author lucas
 * Questa interfaccia descrive i metodi per:
 *  stampare i prodotti, aggiungerne o rimuovere un prodotto oppure
 *  stampare il prezzo totale degli articoli.
 *
 */
public interface ProductService {
	public Collection<Product> getProducts();
	public void addArticle(Product product);
	public void removeArticle(Product product);
	public int getTotal();
}
