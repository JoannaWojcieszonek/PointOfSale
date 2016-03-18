package controller;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import model.*;
import view.LCDDisplay;
import view.Printer;

public class Controller{
	LCDDisplay lcd;
	Printer printer;
	PointOfSale model;
    BarcodeScanner barcodeScanner;

	public Controller(LCDDisplay lcd, Printer printer, PointOfSale pointOfSale,BarcodeScanner barcodeScanner){
		this.lcd = lcd;
		this.printer = printer;
        this.model = pointOfSale;
        this.barcodeScanner = barcodeScanner;
        pointOfSale.addObserver(lcd);
	}


    public void start()
	{
        while(true)
        {
            try {
                barcodeScanner.scan();
                Object scanned = barcodeScanner.getQueue().take();
                
				if(scanned.equals("exit"))
				{
					printer.printReceipt();
					model.reset();
				}
				else
				{
					model.loadProductById((Integer)scanned);
				}

            } catch (NullPointerException e) {
                lcd.print("Invalid Bar Code");
            } catch  (NoSuchElementException e) {
                lcd.print("Not such product");
            } catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
}
