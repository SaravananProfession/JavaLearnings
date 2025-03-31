package console.java.app;

import java.util.Scanner;

public class IndexFile{
	public static void main (String[] args) throws Exception {
		new Store();  //populate StoreId,StoreName,StoreAmount,FetchStoreItems, DisplayItems
		
		Boolean isCustomerExist = true;
		Scanner sc = new Scanner(System.in);
		
		while(isCustomerExist==true) {
			new Customer(); //populate CustomerName, CustomerPhoneNumber, CustomerAmount, CustomerSelectedItems, PrintReceipt
			System.out.println("Is Any Customer Exists: ");
			String isExist = sc.next();
			isCustomerExist = isExist.equals("Yes")? true : false;
		}
		
		System.out.println("Thanks for Shopping!!");
	}
}
