package console.java.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import console.java.app.Service.StoreItemService;

public class Store {
	public int StoreId;
	public String StoreName;
	public float InitialCurrentAmount;
	
	Scanner sc = new Scanner(System.in);
	
	Store() throws Exception{
		StoreItemService storeItemService = new StoreItemService();
		
		PopulateValues();
		
		List<StoreItem> storeItems =  storeItemService.GetStoreItems(); 
		storeItemService.DisplayStoreItems(storeItems);
	}

	public void PopulateValues() throws Exception{
		StoreId = GetStoreId();
		StoreName = GetStoreName();
		InitialCurrentAmount = GetStoreInitialAmount();
	}
	
	
	private int GetStoreId() throws Exception {

		try {
			System.out.println("Enter the StoreId");
			int userId= sc.nextInt();
			
			if(userId <= 0) {
				throw new Exception("StoreId couldn't be less than or equal to zero.");
			}
			
			return userId;
		}
		catch(InputMismatchException ime) {
			System.out.print("Please input only numbers. ");
			throw ime;
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			throw exp;
		}
		finally {
			//System.out.println("Store Id Submitted");
		}
	}

	private String GetStoreName() {
		System.out.println("Enter the Store Name");
		String storeName = sc.next();
		return storeName;
	}
	
	private int GetStoreInitialAmount() throws Exception {
		try {
			System.out.println("Enter the Store Initial Amount");
			int storeInitialAmount = sc.nextInt();
			if(storeInitialAmount == 0) {
				throw new Exception("No Initial Amount");
			}
			return storeInitialAmount;
		}
		catch(Exception ex) {
			if(ex.getMessage() == "No Initial Amount")
				return 1000;
			else
				throw ex;
		}
	}

	
}
