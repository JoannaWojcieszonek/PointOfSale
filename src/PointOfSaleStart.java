

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import controller.*;
import inputDevices.*;
import model.*;
import view.*;

public class PointOfSaleStart {
	
	public static void main(String args[])
	{
		BlockingQueue<Event> queue = new SynchronousQueue<Event>(true);
		
		PointOfSale model = new PointOfSale();
		
		Printer printer = new Printer(model);
		LCDDisplay lcd = new LCDDisplay(model);
		
		BarcodeScanner barcodeScanner = new BarcodeScanner(queue);
		ExitButton exitButton = new ExitButton(queue);
		
		Controller controller = new Controller(lcd, printer, model, queue);
		
		exitButton.run();
		barcodeScanner.run();
		
		
		
	}

}
