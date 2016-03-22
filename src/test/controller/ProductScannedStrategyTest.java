package test.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import controller.ProductScannedStrategy;
import inputDevices.Event;
import inputDevices.EventType;
import model.PointOfSale;

@RunWith(MockitoJUnitRunner.class)
public class ProductScannedStrategyTest {
	@Mock
	PointOfSale model;
	@Mock
	Event event;
	
	ProductScannedStrategy productScannedStrategy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 productScannedStrategy = new ProductScannedStrategy(model);
	}

	@Test(expected = ExecutionException.class)
	public void executeTest() throws ExecutionException {
		
		doThrow(new NoSuchElementException()).when(model).loadProductById(1);
		productScannedStrategy.execute(new Event(1,EventType.ProductScannedEvent));
		
	}
	@Test
	public void executeTest2()
	{
		when(event.getValue()).thenReturn(null);
		
		String message= null;
		try {
			productScannedStrategy.execute(event);
		} catch (ExecutionException e) {
			message =e.getMessage();
		}
		assertEquals(message,"Invalid bar-code");
	}
	

}
