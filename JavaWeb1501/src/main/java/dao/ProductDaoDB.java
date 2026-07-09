package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDaoDB implements ProductDao {

	private String database;
	private String host;
	private String port;
	private String productid;
	private String password;

	public ProductDaoDB(String database, String host, String port, String productid, String password) {
		super();
		this.database = database;
		this.host = host;
		this.port = port;
		this.productid = productid;
		this.password = password;
	}

	
	/*
	@Override
	public Product getProduct(String productId) {
		//データベース接続
		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM Product "; //製品を取得するSQL
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, productId); //ユーザーIDをSQLパラメータに
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Product(resultSet.getString("id"),
							resultSet.getString("name"),
							resultSet.getInt("price"));//ユーザーを生成
				}
		}

		} catch (Exception e) { //例外発生時の処理
			e.printStackTrace();
		}
		return null;
	}
*/
	
	@Override
	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<>();
		//データベース接続
		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM Product "; //製品を取得するSQL
			PreparedStatement statement = connection.prepareStatement(sql);
		 //ユーザーIDをSQLパラメータに
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					productList.add(new Product (resultSet.getString("id"),
							resultSet.getString("name"),
							resultSet.getInt("price")));//ユーザーを生成
				}
		}

		} catch (Exception e) { //例外発生時の処理
			e.printStackTrace();
		}
		return productList;
	}
	
	
	
	//DB接続処理
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// MySQL JDBCドライバを読み込む	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false", host, port,
				database);
		return DriverManager.getConnection(url, productid, password);
	}

	

	}

