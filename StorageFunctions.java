package mhxalog;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class StorageFunctions {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public StorageFunctions(){
		this.conn = null;
		this.stmt = null;
		this.rs = null;
	}
	
	public void connection(){

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/mhxalog?autoReconnect=true&useSSL=false";
			String connectionUser = "root";
			String connectionPassword = "161219951039pao";
			conn = (Connection) DriverManager.getConnection(connectionUrl,connectionUser,connectionPassword);
			stmt = (Statement) conn.createStatement(); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
//		finally
//		{
//			try { if (rs != null) rs.close(); } catch (SQLException e) {
//				e.printStackTrace(); }
//			try { if (stmt != null) stmt.close(); } catch (SQLException e) {
//				e.printStackTrace(); }
//			try { if (conn != null) conn.close(); } catch (SQLException e) {
//				e.printStackTrace(); }
//		}
	}

	public boolean createProduct(String proion,float price,int stock){
		try {
			if(stmt.executeUpdate("INSERT INTO proionta VALUES(0,\""+proion+"\","+price+","+stock+")")>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public Product getStock(String productName){
		Product p = null;
		try {
			rs = stmt.executeQuery("Select * from proionta where proion = \""+productName+"\"");
			if(rs.next()){
				p = new Product(rs.getInt("id"), rs.getString("proion"), rs.getFloat("price"), rs.getInt("stock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public Product getName(String productName){
		Product q = null;
		try {
			rs = stmt.executeQuery("Select * from proionta where proion = \""+productName+"\"");
			if(rs.next()){
				q = new Product(rs.getInt("id"), rs.getString("proion"), rs.getFloat("price"), rs.getInt("stock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
		
	}
	public boolean processingProduct(String proion,int stock){
		try {
			if(stmt.executeUpdate("UPDATE proionta SET stock="+stock+" where proion = \""+proion+"\"")>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
		
	}
}
}
