package model;

//精算クラス
public class Payment {


		private String userid;

		private String username;
		
		private String productid;

		private String productname;
		
		private int amount;
		
	
		
		
		/**
		 * 価格
		 */
		private int price;

		/******** コンストラクタ **************************************/
		/**
		 * フィールド初期化コンストラクタ
		 * @param userid
		 * @param username
		 * @param productid
		 * @param productname
		 * @param amount
		 * @param purchasedate
		 */
		
		/*
		public Product(String userid, String username, String productid, String productname, int amount, LocalDateTime purchase date) {
			this.id = id;
			this.name = name;
			this.price = price;
		}

		/******** メソッド ******************************************/
		/*--------------------getter/setter--------------------*/
		/**
		 * @return id
		 */
		public String getId() {
			return userid;
		}

		/**
		 * @return name
		 */
		public String getName() {
			return username;
		}

		/**
		 * @return price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * 価格を文字列で返す（３桁カンマ区切り＋"円"）
		 * @return 価格 + 円
		 */
		public String getPriceString() {
			return String.format("%,d", price) + "円";
		}

	}
