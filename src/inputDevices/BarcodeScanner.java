package inputDevices;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


public class BarcodeScanner implements InputDevice, Runnable {
	
	private BlockingQueue<Event> queue;

	public BarcodeScanner(BlockingQueue<Event> queue)
	{
		this.queue = queue;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public BlockingQueue<Event> getQueue() {
		return queue;
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
		while(true) {
			System.out.println("Wpisz kod kreskowy produktu:");
			Scanner in = new Scanner(System.in);
			Integer barcode = null;
			if(in.hasNextInt())
			{
				barcode = in.nextInt();
				Event event = new Event(barcode, EventType.ProductScannedEvent);
				sendEvent(event);
			}
		}
	}
}
