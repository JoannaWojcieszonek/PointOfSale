package test.InputDevices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import inputDevices.BarcodeScanner;
import inputDevices.Event;

@RunWith(MockitoJUnitRunner.class)
public class BarcodeScannerTest {
	private BlockingQueue<Event> queue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		queue = new SynchronousQueue<Event>();
	}

	@Test
	public void test() {
		BarcodeScanner barcodeScanner = mock(BarcodeScanner.class);
		
		when(barcodeScanner.getQueue()).thenReturn(queue);
		
		assertEquals(barcodeScanner.getQueue(), queue);
	}
}
