package controller;

import inputDevices.Event;
import model.PointOfSale;

public class ExitButtonClickedStrategy implements EventStrategy {
	private PointOfSale model;
	
	public ExitButtonClickedStrategy(PointOfSale model) {
		this.model = model;
	}
	
	@Override
	public void execute(Object value) {
		model.reset();
	}

}
