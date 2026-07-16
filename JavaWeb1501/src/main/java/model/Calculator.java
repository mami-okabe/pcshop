package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 合計金額の精算処理をするクラスです。
 * 商品の金額に消費税を足して合計金額を出し、
 * Cartに入れます。
 */
public class Calculator {

	/**
	 * 消費税を設定します。
	 */
	private static final BigDecimal TAX_RATE = new BigDecimal("0.1");

	//public static void main(String[] args) {

	public int taxPrice(int price) {

		BigDecimal bdPrice = BigDecimal.valueOf(price);
		return bdPrice.multiply(TAX_RATE).setScale(0, RoundingMode.DOWN).intValue();
	}
	public int inTaxPrice(int price) {return price + taxPrice(price);};

	/**
	 * 具体例です。
	 
	List<Product> productList = new ArrayList<Product>();
	//商品追加
	productList.add(new Product("A110", "無線マウス", 100));
	//productList.add(new Product("A120", "薄型キーボード", 3600));
	
	//Calculatorのcalculatorメソッドを呼び出す
	Calculator calculator = new Calculator();
	int total = calculator.calculate(productList);
	//合計金額を出力する
	System.out.println(total);
	}
	*/
	/**
	 * 消費税込みの商品金額を取得します。
	 * @param price 消費税抜きの商品金額
	 * @return 
	 */
	/*
	public int inTaxPrice(int price) {
		return (int) (price * TAX_RATE);
	}
	*/

	//呼び出し方追加（なくてもＯＫ）
	/*
	public int inTaxPrice(Product product) {
		return (int) (product.getPrice() * TAX);
	}
*/
	/**
	 * 消費税込みの合計金額を取得します。
	 * @param listProd 購入する商品のリスト（リストの仮名）
	 * @return
	 */
	public int calculate(List<Product> listProd) {
		int totalPrice = 0;
		for (Product product : listProd) {
			totalPrice += inTaxPrice(product.getPrice());
			/*
			int price = product.getPrice();
			totalPrice += plusTax(price);
			*/
		}
		/*
		public int calculate(List<Product> listProd) {
			int totalPrice = 0;
			for (int i = 0; i < listProd.size(); i++) {
			Product product = listProd.get(i);
			for (Product product : listProt.get) {
				int price = product.getPrice();
				totalPrice += plusTax(price, 1.1);
			}
			*/
		return totalPrice;
	}

	//呼び出し方追加（なくてＯＫ）
//	public int calculate(Product product) {
	//	return plusTax(product);
	//}

}
