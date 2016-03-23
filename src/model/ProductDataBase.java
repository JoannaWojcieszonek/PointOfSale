package model;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductDataBase {

	private static Map<Integer, Product> productList;
	
	static {
		productList = new HashMap<Integer, Product>();
		productList.put(1, new Product("Bread", 2.99));
		productList.put(2, new Product("Milk", 1.30));
		productList.put(3, new Product("Butter", 3.89));
	}
	
	public Product findByBarcode(Integer barcode) throws NoSuchElementException {
		
		
		if(!productList.containsKey(barcode))
			throw new NoSuchElementException("Product not found");
		Product p = productList.get(barcode);
		return p;
	}
}
