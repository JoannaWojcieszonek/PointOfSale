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
			System.out.println("Sending event failed");
		}
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Scan bar-code:");
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
