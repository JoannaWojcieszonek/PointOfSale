package model;

public class ProductDataBase {

	public Product findByBarcode(Integer barcode) {
		// TODO Auto-generated method stub
		if(barcode == 1) return new Product("Chleb", 2.99);
		if(barcode == 2) return new Product("Bu�ka", 0.30);
		if(barcode == 3) return new Product("Mas�o", 3.89);
		return null;
	}
}
