package inputDevices;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


public class BarcodeScanner implements InputDevice{
	
	private BlockingQueue<Event> queue;

	public BarcodeScanner(BlockingQueue<Event> queue)
	{
		this.queue = queue;
	}
	
	public BlockingQueue<Event> getQueue() {
		return queue;
	}

	public void scanProduct() {
		while(true) {
			System.out.println("Wpisz kod kreskowy produktu:");
			Scanner in = new Scanner(System.in);
			Integer barcode = null;
			barcode = in.nextInt();
			Event event = new Event(barcode, EventType.ProductScannedEvent);
			sendEvent(event);
		}
	}
	
	@Override
	public void sendEvent(Event event) {
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		scanProduct();
	}
}
