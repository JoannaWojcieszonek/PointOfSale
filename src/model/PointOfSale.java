package model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observable;

/**
 * 
 * PointOfSale works as model in our MVC pattern. It contains the receipt's data
 * and communicate with database to obtain products' data.
 *
 */
public class PointOfSale extends Observable
{
    private Receipt receipt = new Receipt();
    private ProductDataBase productDataBase = new ProductDataBase();


	public void setProductDataBase(ProductDataBase productDataBase) {
		this.productDataBase = productDataBase;
	}

	public void loadProductById(Integer id) throws NoSuchElementException {
        Product p = productDataBase.findByBarcode(id);
        receipt.addProduct(p);

        setChanged();
        notifyObservers(p);
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public List<Product> getProductList() {
        return receipt.getProductList();
    }

    public void reset()
    {
    	setChanged();
    	notifyObservers(receipt);
    	
        receipt = new Receipt();
    }
}
