package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductDataBase {

	private static Map<Integer, Product> productList;
	
	static {
		productList = new HashMap<Integer, Product>();
		productList.put(1, new Product("Chleb", 2.99));
		productList.put(2, new Product("Bu³ka", 0.30));
		productList.put(3, new Product("Mas³o", 3.89));
	}
	
	public Product findByBarcode(Integer barcode) throws NoSuchElementException {
		
		
		if(!productList.containsKey(barcode))
			throw new NoSuchElementException("Product not found");
		Product p = productList.get(barcode);
		return p;
	}
}
