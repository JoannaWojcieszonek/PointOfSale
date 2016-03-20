package controller;


import java.util.concurrent.BlockingQueue;
import inputDevices.Event;
import inputDevices.EventType;
import model.*;
import view.LCDDisplay;
import view.Printer;

public class Controller implements Runnable{
	Thread thread;
	
	LCDDisplay lcd;
	Printer printer;
	PointOfSale model;
    BlockingQueue<Event> queue;

	public Controller(LCDDisplay lcd, Printer printer, PointOfSale pointOfSale,BlockingQueue<Event> queue){
		this.lcd = lcd;
		this.printer = printer;
        this.model = pointOfSale;
        this.queue = queue;
        pointOfSale.addObserver(lcd);
        thread = new Thread(this);
        thread.start();
	}
	
	private void handleEvent() {
		// TODO Auto-generated method stub
		try {
			Event event = queue.take();
			if(event.getType() == EventType.ProductScannedEvent)
			{
				model.loadProductById((Integer)event.getValue());
			}
			else if(event.getType() == EventType.ExitButtonClickedEvent)
			{
				printer.printReceipt();
				model.reset();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
        {
            handleEvent();
        }
	}
}
