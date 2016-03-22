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
import view.LCDDisplay;
import view.Printer;

import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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
		fail("Not yet implemented");
		exitButtonClickedStrategy.execute(new Event(1,EventType.ExitButtonClickedEvent));
		
		verify(model,times(1)).reset();
		
	}

}
