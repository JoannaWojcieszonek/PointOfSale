

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import controller.*;
import inputDevices.*;
import model.*;
import view.*;

/**
 * 
 * Starting point of the example program which provides required functionalities:
 * - scanning bar-codes, finding products and displaying them,
 * - printing receipts,
 * - managing errors.
 *
 */
public class PointOfSaleStart {
	
	public static void main(String args[]) {
		BlockingQueue<Event> queue = new SynchronousQueue<Event>(true);
		
		PointOfSale model = new PointOfSale();
		
		Printer printer = new Printer();
		LCDDisplay lcd = new LCDDisplay();
		
		@SuppressWarnings("unused")
		BarcodeScanner barcodeScanner = new BarcodeScanner(queue);
		@SuppressWarnings("unused")
		ExitButton exitButton = new ExitButton(queue);
		
		Controller controller = new Controller(lcd, printer, model, queue);
		controller.start();
	}
}
