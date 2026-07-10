package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payment;

public class PaymentDaoDB implements PaymentDao {

	private String database;
	private String host;
	private String port;
	private String userid;
	private String password;

	public PaymentDaoDB(String database, String host, String port, String userid, String password) {
		super();
		this.database = database;
		this.host = host;
		this.port = port;
		this.userid = userid;
		this.password = password;
	}

	@Override
	public Payment getPayment(String userId) {
		//データベース接続
		try (Connection connection = getConnection()) {
			String sql = "SELECT * FROM Payment WHERE userid = ?"; //ユーザーを取得するSQL
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId); //ユーザーIDをSQLパラメータに
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Payment(resultSet.getString("userid"),
							resultSet.getString("username"),
							resultSet.getString("productid"),
							resultSet.getString("productname"),
							resultSet.getInt("amount"),
							resultSet.getString("purchase_date"));//ユーザーを生成

				}
			}

		} catch (Exception e) { //例外発生時の処理
			e.printStackTrace();
		}
		return null;
	}

	//DB接続処理
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// MySQL JDBCドライバを読み込む	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false", host, port,
				database);
		return DriverManager.getConnection(url, userid, password);
	}

}
