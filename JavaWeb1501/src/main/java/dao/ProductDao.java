package dao;

import java.util.List;

import model.Product;

public interface ProductDao {

	
	//Product getProduct(String productId);
	List<Product> getProductList();
}
