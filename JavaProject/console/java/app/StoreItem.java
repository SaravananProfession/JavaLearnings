package console.java.app;

public class StoreItem {
	
	public StoreItem(int id, String itemName, float price){
		Id = id;
		ItemName = itemName;
		Price = price;
	}
	
	public StoreItem(int id, String itemName){
		Id = id;
		ItemName = itemName;
	}
	
	public int Id;
	public String ItemName;
	public float Price = 100;
	
	
}
