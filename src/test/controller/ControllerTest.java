package test.controller;


import controller.Controller;
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


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	private Controller controller;
	
	@Mock
	private BlockingQueue<Event> queue;
	@Mock
	LCDDisplay lcdDisplay;
	@Mock
	Printer printer;
	@Mock
	PointOfSale pointOfSale;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void constructorTest()
	{
		controller = new Controller(lcdDisplay,printer,pointOfSale,queue);

		verify(pointOfSale).addObserver(lcdDisplay);
		verify(pointOfSale).addObserver(printer);
	}

	@Test
	public void runTest() throws InterruptedException {
		controller = new Controller(lcdDisplay,printer,pointOfSale,queue);

		when(queue.take()).thenReturn(new Event(1,EventType.ExitButtonClickedEvent));
		
		controller.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		controller.stop();

		verify(queue,atLeastOnce()).take();
	}
	
	@Test
	public void handleEventTest() throws InterruptedException {
		controller = new Controller(lcdDisplay,printer,pointOfSale,queue);

		when(queue.take()).thenReturn(new Event(1,EventType.ExitButtonClickedEvent));
		controller.handleEvent();

		verify(queue,times(1)).take();
	}

}
