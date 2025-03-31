package console.java.app.Service;

import java.util.ArrayList;
import java.util.List;

import console.java.app.StoreItem;

public class StoreItemService {
	
	public List<StoreItem> GetStoreItems() {
		
		List<StoreItem> items = new ArrayList<StoreItem>(){
			{
				add(new StoreItem(1,"Vegetables",50.0f));
				add(new StoreItem(2,"Toys",100.0f));
				add(new StoreItem(3,"Fruits",120.0f));
				add(new StoreItem(4,"Dress",200.0f));
				add(new StoreItem(5,"Food",101.0f));
				add(new StoreItem(6,"Stationary Items"));
			}};
		
		return items;
		
	}

	public void DisplayStoreItems(List<StoreItem> storeItems) {
		System.out.println("Products Available Now: ");
		storeItems.forEach(x->{
			String message = x.Id + " . " + x.ItemName + " - " + x.Price;
			System.out.println(message);
		});
	}
}
