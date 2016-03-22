package test.controller;


import controller.Controller;
import controller.ExitButtonClickedStrategy;
import inputDevices.Event;
import inputDevices.EventType;
import model.PointOfSale;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ExitButtonClickedStrategyTest {

	@Mock
	PointOfSale model;
	
	ExitButtonClickedStrategy exitButtonClickedStrategy;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exitButtonClickedStrategy = new ExitButtonClickedStrategy(model);
	}

	@Test
	public void testExecute() {

		exitButtonClickedStrategy.execute(1);
		
		verify(model,times(1)).reset();
		
	}

}
