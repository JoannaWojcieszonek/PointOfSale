package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class ReceiptTest {
	private Receipt receipt;

	@Before
	public void testSetup() {
		receipt = new Receipt();
	}
	
	@Test
	public void receiptShouldContainAddedProduct() {
		Product p = new Product("name", 0.99);
		
		receipt.addProduct(p);
		
		assertTrue(receipt.getProductList().contains(p));
		assertTrue(receipt.getProductList().size() == 1);
	}

	@Test
	public void afterClearReceiptShouldBeEmpty() {
		receipt.addProduct(new Product("name", 0.99));
		receipt.addProduct(new Product("other", 5));
		
		receipt.clear();
		
		assertTrue(receipt.getProductList().isEmpty());
		assertTrue(receipt.getSum() == 0);
	}
	
}
