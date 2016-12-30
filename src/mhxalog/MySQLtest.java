package mhxalog;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLtest
{
public static void main(String[] args)
{
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
String connectionUrl = "jdbc:mysql://localhost:3306/mhxalog?autoReconnect=true&useSSL=false";
String connectionUser = "root";
String connectionPassword = "161219951039pao";
conn = (Connection) DriverManager.getConnection(connectionUrl,connectionUser,connectionPassword);
stmt = (Statement) conn.createStatement(); 
rs = stmt.executeQuery("SELECT * FROM proionta");
while (rs.next())
{
int id = rs.getInt("id");
String proion = rs.getString("proion");
float price = rs.getFloat("price");
int stock = rs.getInt("stock");
System.out.println("ID: " + id + ", proion: " + proion
+ ", price: " + price + ", stock " + stock);
}
}
catch (Exception e)
{
e.printStackTrace();
}
finally
{
	try { if (rs != null) rs.close(); } catch (SQLException e) {
		e.printStackTrace(); }
	try { if (stmt != null) stmt.close(); } catch (SQLException e) {
		e.printStackTrace(); }
	try { if (conn != null) conn.close(); } catch (SQLException e) {
		e.printStackTrace(); }
}
}
}
