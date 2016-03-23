package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

import model.PointOfSale;

public class ProductScannedStrategy implements EventStrategy {
	private PointOfSale model;
	
	public ProductScannedStrategy(PointOfSale model) {
		this.model = model;
	}
	
	@Override
	public void execute(Object value) throws ExecutionException {
		if(value == null) {
			throw new ExecutionException("Invalid bar-code", new NullPointerException());
		}
		try {
		model.loadProductById((Integer)value);
		} catch (NoSuchElementException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
	}
}
