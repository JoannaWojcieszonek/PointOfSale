package view;
import java.util.Observable;
import java.util.Observer;

import model.*;

public class LCDDisplay implements Observer{

	public void print(String msg) {
		System.out.println(msg);
	}

	public void update(Observable o, Object arg)
	{
		System.out.println("##### LCD DISPLAY #####");
		if( arg instanceof Product) {
			Product p  = (Product) arg;
			System.out.println(p);
			}
		else if ( arg instanceof Receipt) {
			Receipt r = (Receipt) arg;
			System.out.println("Total: " + r.getSum());
		}
			
		System.out.println("#######################");
	}
}
