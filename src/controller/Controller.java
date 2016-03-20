package controller;


import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import inputDevices.Event;
import inputDevices.EventType;
import model.*;
import view.LCDDisplay;
import view.Printer;

public class Controller implements Runnable{
	LCDDisplay lcd;
	Printer printer;
	PointOfSale model;
    BlockingQueue<Event> queue;
    
    Map<EventType, EventStrategy> strategyMap;

	public Controller(LCDDisplay lcd, Printer printer, PointOfSale pointOfSale,BlockingQueue<Event> queue) {
		this.lcd = lcd;
		this.printer = printer;
        this.model = pointOfSale;
        this.queue = queue;
        pointOfSale.addObserver(lcd);
        pointOfSale.addObserver(printer);
        Thread thread = new Thread(this);
        thread.start();
        strategyMap = new EnumMap<EventType, EventStrategy>(EventType.class);
        strategyMap.put(EventType.ProductScannedEvent, new ProductScannedStrategy(model));
        strategyMap.put(EventType.ExitButtonClickedEvent, new ExitButtonClickedStrategy(model));
	}
	
	private void handleEvent() {
		// TODO Auto-generated method stub
		try {
			Event event = queue.take();
			strategyMap.get(event.getType()).execute(event);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		while(true) {
            handleEvent();
        }
	}
}
