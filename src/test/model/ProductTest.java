package test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;

public class ProductTest {

	@Test
	public void toStringTest() {
		Product product = new Product("name", 0.99);
		
		assertEquals(product.toString(), "Product{" + "name='" + product.getName() + '\'' + 
				", price=" + product.getPrice() +
				'}');
	}
}