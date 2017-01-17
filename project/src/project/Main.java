package project;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {
		functions b = new functions();
		int res = functions.createProduct("4","rom","60","9");
		System.out.println(b);
	}

}
