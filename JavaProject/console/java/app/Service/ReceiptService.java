package console.java.app.Service;

import java.util.List;

import console.java.app.Customer;
import console.java.app.StoreItem;

public class ReceiptService {

	public void PrintCustomerConsoleReceipt(Customer customer) {

			StoreItemService storeItemService = new StoreItemService();
			List<StoreItem> storeItems =  storeItemService.GetStoreItems(); 
		
			System.out.println("Receipt of "+customer.CustomerName);
			
			System.out.println();
			
			System.out.println("Items Purchased:");
			
			for(int productId :customer.CustomerSelectedItems ) {
				
				StoreItem product = storeItems.stream().filter(x->x.Id == productId).findFirst().orElse(null);
				String message = product.Id + " . " + product.ItemName + " - " + product.Price;
				System.out.println(message);
				
			}
			
			System.out.println();
			
			System.out.println("Total Bill Amount:" + customer.CustomerBillAmount );
			
			System.out.println();
			
			System.out.println("Customer Pending Amount:" + (customer.CustomerInitialAmount-customer.CustomerBillAmount) );
	}

}
