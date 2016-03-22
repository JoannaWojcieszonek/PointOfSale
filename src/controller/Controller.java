package controller;


import java.util.EnumMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;

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
    private Thread thread;
    Map<EventType, EventStrategy> strategyMap;

	public Controller(LCDDisplay lcd, Printer printer, PointOfSale pointOfSale,BlockingQueue<Event> queue) {
		this.lcd = lcd;
		this.printer = printer;
        this.model = pointOfSale;
        this.queue = queue;
        pointOfSale.addObserver(lcd);
        pointOfSale.addObserver(printer);

		strategyMap = new EnumMap<EventType, EventStrategy>(EventType.class);
        strategyMap.put(EventType.ProductScannedEvent, new ProductScannedStrategy(model));
        strategyMap.put(EventType.ExitButtonClickedEvent, new ExitButtonClickedStrategy(model));
	}
	
	public void handleEvent() {
		try {
			Event event = queue.take();

			strategyMap.get(event.getType()).execute(event);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			lcd.print(e.getMessage());		
		}
	}
	
	public void stop() {
		thread.interrupt();
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
            	handleEvent();
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}
}
