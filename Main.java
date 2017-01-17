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
		String st = sf.avg();
		if(st!=null)
			System.out.println(st);
		else
			System.out.println("Table Not Found!");
		
		String max = sf.max();
		if(max!=null)
			System.out.println(max);
		else
			System.out.println("Table Not Found!");
		
		String min = sf.min();
		if(min!=null)
			System.out.println(min);
		else
			System.out.println("Table Not Found!");
		
		String maxStock = sf.maxStock();
		if(maxStock!=null)
			System.out.println(maxStock);
		else
			System.out.println("Table Not Found!");
		
		String minStock = sf.minStock();
		if(minStock!=null)
			System.out.println(minStock);
		else
			System.out.println("Table Not Found!");
		
		String numOfProducts = sf.numOfProducts();
		if(numOfProducts!=null)
			System.out.println(numOfProducts);
		else
			System.out.println("Table Not Found!");
		Users a= sf.getStatus("giannhs", "kasimhs");
		if(a!=null)
			System.out.println(a.getStatus());
		else
			System.out.println("Product Not Found!");
		
	}
}