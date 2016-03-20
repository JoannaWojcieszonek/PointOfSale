package controller;

import inputDevices.Event;
import model.PointOfSale;

public class ProductScannedStrategy implements EventStrategy {
	private PointOfSale model;
	
	public ProductScannedStrategy(PointOfSale model) {
		this.model = model;
	}
	
	@Override
	public void execute(Event event) {
		// TODO Auto-generated method stub
		model.loadProductById((Integer)event.getValue());
	}

}
