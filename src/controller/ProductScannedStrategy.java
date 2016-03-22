package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

import inputDevices.Event;
import model.PointOfSale;

public class ProductScannedStrategy implements EventStrategy {
	private PointOfSale model;
	
	public ProductScannedStrategy(PointOfSale model) {
		this.model = model;
	}
	
	@Override
	public void execute(Event event) throws ExecutionException {
		if(event.getValue() == null) {
			throw new ExecutionException("Invalid bar-code", new NullPointerException());
		}
		try {
		model.loadProductById((Integer)event.getValue());
		} catch (NoSuchElementException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
	}
}
