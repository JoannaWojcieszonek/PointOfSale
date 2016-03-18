

import controller.*;
import model.*;
import view.*;

public class PointOfSaleStart {
	
	public static void main(String args[])
	{
		PointOfSale model = new PointOfSale();
		Printer printer = new Printer(model);
		LCDDisplay lcd = new LCDDisplay(model);
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		Controller controller = new Controller(lcd, printer, model, barcodeScanner);
		
		controller.start();
		
	}

}
