package console.java.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import console.java.app.Service.ReceiptService;
import console.java.app.Service.StoreItemService;

public class Customer {
	
	public String CustomerName;
	public String CustomerPhoneNumber;
	public float CustomerInitialAmount;
	public List<Integer> CustomerSelectedItems;
	public float CustomerBillAmount;
	
	Scanner sc = new Scanner(System.in);
	
	Customer(){
		ReceiptService receiptService = new ReceiptService();
		
		PopulateCustomer();
		GetCustomerSelectedItems();
		receiptService.PrintCustomerConsoleReceipt(this);
		
	}
	
	private void PopulateCustomer() {
		CustomerName = GetCustomerName();
		CustomerPhoneNumber = GetPhoneNumber();
		CustomerInitialAmount = GetCustomerInitialAmount();
	}
	
	private void GetCustomerSelectedItems() {
		List<Integer> customerSelectedItems = new ArrayList<Integer>();
		
		System.out.println("Enter the No of Products Selected");
		int selectProductCount = sc.nextInt();
		
		for(int i=0;i<selectProductCount;i++) {
			System.out.println("Enter the ProductId: ");
			int productId = sc.nextInt();
			customerSelectedItems.add(productId);
		}
		
		this.CustomerSelectedItems = customerSelectedItems;
		CustomerBillAmount = CalculateCustomerBillAmount(customerSelectedItems);
	}

	
	private float CalculateCustomerBillAmount(List<Integer> customerSelectedItems){
		
		StoreItemService storeItemService = new StoreItemService();
		List<StoreItem> items =  storeItemService.GetStoreItems();
		
		
		float CustomerBillAmount = 0;
		
		for (int y : customerSelectedItems) {
			
			int selectedProductId = y;
			
			StoreItem product = items.stream().filter((x)-> x.Id == (selectedProductId)).findAny().
								orElse(new StoreItem(0,"",0.0f));
			
			CustomerBillAmount = CustomerBillAmount + product.Price;
		}
		
		return CustomerBillAmount;
	}
	
	private String GetCustomerName() {
		System.out.println("Enter the Customer Name");
		String customerName = sc.next();
		return customerName;
	}
	
	private String GetPhoneNumber() {
		System.out.println("Enter the Customer Phone Number");
		String customerPhoneNumber = sc.next();
		return customerPhoneNumber;
	}
	
	private int GetCustomerInitialAmount() {
		System.out.println("Enter the Customer Initial Amount");
		int storeInitialAmount = sc.nextInt();
		return storeInitialAmount;
	}
	
}
