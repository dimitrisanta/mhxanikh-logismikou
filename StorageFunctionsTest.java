package junit;

import static org.junit.Assert.*;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class StorageFunctionsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("starting....");
	}
	
	@AfterClass
	public static void testCleanup() throws Exception {
		System.out.println("finish");
	}
	
	@Test
	public void testConnection() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
	}

	@Test
	public void testCreateProduct() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();

		boolean res = sf.createProduct("screen",100,30);
		assertEquals(true,res);
	}
	
	@Test
	public void testCreateProductFalse() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();

		boolean res = sf.createProduct("screen",100,30);
		assertEquals(false,res);
	}
	
		
	@Test
	public void testGetStock() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();

		Product p = sf.getStock("asd2");	
		}

	@Test
	public void testGetName() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		Product q =sf.getName("asd2");
		if(q!=null)
			System.out.println(q.getName()+ " " + q.getPrice() + " "  + q.getStock());
		else
			System.out.println("Product Not Found!");

	}

	@Test
	public void testProcessingProduct() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		boolean sear =sf.processingProduct("hard disk",40);		
	}

	@Test
	public void testAvg() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		float st = sf.avg();
		if(st!=0)
			System.out.println(st);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testMax() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		String max = sf.max();
		if(max!=null)
			System.out.println(max);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testMin() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		String min = sf.min();
		if(min!=null)
			System.out.println(min);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testMaxStock() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		String maxStock = sf.maxStock();
		if(maxStock!=null)
			System.out.println(maxStock);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testMinStock() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		String minStock = sf.minStock();
		if(minStock!=null)
			System.out.println(minStock);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testNumOfProducts() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		String numOfProducts = sf.numOfProducts();
		if(numOfProducts!=null)
			System.out.println(numOfProducts);
		else
			System.out.println("Table Not Found!");
	}

	@Test
	public void testGetStatus() {
		StorageFunctions sf = new StorageFunctions();
		sf.connection();
		Users a= sf.getStatus("giannhs", "kasimhs");
		if(a!=null)
			System.out.println(a.getStatus());
		else
			System.out.println("Product Not Found!");
	}

}

