package model;

/**
 * 商品クラス
 * @author M.Takahashi
 */
public class Product {
	/******** フィールド ******************************************/
	/**
	 * 商品ID
	 */
	private String id;

	/**
	 * 商品名
	 */
	private String name;

	/**
	 * 価格
	 */
	private int price;
	private int taxPrice;
	
	//★追加
	private final double tax = 1.1;

	/******** コンストラクタ **************************************/

	/**
	 * フィールド初期化コンストラクタ
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;

		//★追加
		this.taxPrice = (int) (price * tax);
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price
	 */
	/*
	public int getPrice() {
		return price;
	}
	*/

	//★追加
	public int getPrice() {
		return price;
	}
	
	//★追加
		public int getTaxPrice() {
			return taxPrice;
		}

	/**
	 * 価格を文字列で返す（３桁カンマ区切り＋"円"）
	 * @return 価格 + 円
	 * 
	 */

	public String getPriceString() {
		return String.format("%,d", price) + "円";
	}

	public String getTaxPriceString() {
		return String.format("%,d", taxPrice) + "円";
	}

}
