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
	public String avg(){
		String st = null;
		try {
			rs = stmt.executeQuery("SELECT AVG(price) from proionta");
			if(rs.next()){
			st=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
		}
	
	public String max(){
		String max = null;
		try {
			rs = stmt.executeQuery("SELECT MAX(price) from proionta");
			if(rs.next()){
			max=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
		}
	
	public String min(){
		String min = null;
		try {
			rs = stmt.executeQuery("SELECT MIN(price) from proionta");
			if(rs.next()){
			min=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return min;
		}
	
	public String maxStock(){
		String maxStock = null;
		try {
			rs = stmt.executeQuery("SELECT MAX(stock) from proionta");
			if(rs.next()){
			maxStock=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxStock;
		}
	
	public String minStock(){
		String minStock = null;
		try {
			rs = stmt.executeQuery("SELECT MIN(stock) from proionta");
			if(rs.next()){
			minStock=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minStock;
		}
	
	public String numOfProducts(){
		String numP = null;
		try {
			rs = stmt.executeQuery("SELECT COUNT(proion) from proionta");
			if(rs.next()){
			numP=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numP;
		}
	
}
