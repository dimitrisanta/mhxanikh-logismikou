package mhxalog;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class functions 
{
String proion;
int id;
float price;
int stock;
int imports;
int export;

public void connection()
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

public boolean createProduct(int id,String proion,float price,int stock){
if(stmt.executeUpdate("INSERT INTO proionta"+"VALUES(id,proion,price,stock)")){
	return true;
}
else
{
	return false;
}
}
	
}

