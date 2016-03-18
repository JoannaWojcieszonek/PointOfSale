package view;
import java.util.Observable;
import java.util.Observer;

import model.*;

public class LCDDisplay implements Observer{

	private PointOfSale model;

	public LCDDisplay(PointOfSale model) {
		this.model = model;
	}

	public void print(String msg) {
		System.out.println(msg);
	}

	public void update(Observable o, Object arg)
	{
		System.out.println("##### LCD DISPLAY #####");
		model.getProductList();
		if( arg instanceof Product) {
			Product p  = (Product) arg;
			System.out.println(p);
			}
		else if ( arg instanceof Double) {
			System.out.println("Total: " + arg);
		}
			
		System.out.println("#######################");
	}
}
