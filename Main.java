package mhxalog;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		boolean res = sf.createProduct("rom",60,9);
		Product p = sf.getStock("asd2");
		if(p!=null)
			System.out.println(p.getStock());
		else
			System.out.println("Product Not Found!");
		Product q =sf.getName("asd2");
		if(q!=null)
			System.out.println(q.getName()+ " " + q.getPrice() + " "  + q.getStock());
		else
			System.out.println("Product Not Found!");
		
		boolean sear =sf.processingProduct("hard disk",40);
		
	}
}