package view;

import model.*;

public class Printer {
	 private PointOfSale model;
	 
	 public Printer(PointOfSale model) {
			this.model = model;
		}

	public void printReceipt() {
		Receipt receipt = model.getReceipt();
		System.out.println("############\n" + "Receipt:\n");
		for(Product p: receipt.getProductList())
		{
			System.out.println(p.getName() + "\t" + "$" + p.getPrice());
		}
		System.out.println("Total Sum: $"+ receipt.getSum() +"\n############\n");
	}

}
