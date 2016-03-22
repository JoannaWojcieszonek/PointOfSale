package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.PointOfSale;
import model.Product;

public class PointOfSaleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void receiptShouldBeEmptyAfterReceipt() {
		PointOfSale model = new PointOfSale();

		fail("Not yet implemented");
	}

	@Test
	public void loadProductById() {
		PointOfSale model = new PointOfSale();
		model.loadProductById(1);
		Product p = new Product("Chleb", 2.99);

		assertEquals(model.getReceipt().getProductList().get(0), p);
	}
}
