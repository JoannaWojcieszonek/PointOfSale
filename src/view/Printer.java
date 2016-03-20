package view;

import java.util.Observable;
import java.util.Observer;

import model.*;

public class Printer implements Observer {
	 
	public void printReceipt(Receipt receipt) {
		System.out.println("############\n" + "Receipt:\n");
		for(Product p: receipt.getProductList())
		{
			System.out.println(p.getName() + "\t" + "$" + p.getPrice());
		}
		System.out.println("Total Sum: $"+ receipt.getSum() +"\n############\n");
	}

	@Override
	public void update(Observable o, Object arg) {
		if ( arg instanceof Receipt) {
			printReceipt((Receipt) arg);
		}
	}

}
