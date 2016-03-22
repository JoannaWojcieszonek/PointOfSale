package test.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import model.PointOfSale;
import model.Product;
import model.ProductDataBase;
import model.Receipt;
@RunWith(MockitoJUnitRunner.class)
public class PointOfSaleTest {

	@Mock
	public ProductDataBase productDataBase;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void receiptShouldBeEmptyAfterReset() {
		PointOfSale model = new PointOfSale();
		model.setProductDataBase(productDataBase);
		
		Product p = new Product("Chleb",2.78);
		when(productDataBase.findByBarcode(1)).thenReturn(p);
		
		model.loadProductById(1);
		verify(productDataBase,times(1)).findByBarcode(1);
		assertTrue(model.getReceipt().getProductList().contains(p));
		model.reset();
		
		assertTrue(model.getReceipt().getProductList().isEmpty());
		
	}
}
