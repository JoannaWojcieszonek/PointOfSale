package model;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private List<Product> productList;
	private double sum;
	
	public Receipt() {
		productList = new ArrayList<Product>();
		sum = 0;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
		sum += product.getPrice();
	}

	public void clear() {
		productList.clear();
		sum = 0;
	}
}
