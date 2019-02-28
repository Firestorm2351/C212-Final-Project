public class Item{
	//instance variable
	private String itemName;
	private String itemID;
	private String itemDes;
	private String sellerID;
	private int quantity;
	private double price;
	//constructor
	public Item(String itemName, String itemDes, String sellerID, int quantity, double price, int num){
		this.itemName = itemName;
		this.itemDes = itemDes;
		this.sellerID = sellerID;
		this.quantity = quantity;
		this.price = price;
		this.itemID = sellerID + num;
	}
	//csv constructor
	public Item(String itemName, String itemDes, String sellerID, int quantity, double price, String itemID){//TODO not from original 
		this.itemName = itemName;
		this.itemDes = itemDes;
		this.sellerID = sellerID;
		this.quantity = quantity;
		this.price = price;
		this.itemID = itemID;
	}
	//setter
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public void setDescription(String itemDes){
		this.itemDes = itemDes;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setSellerID(String sellerID){
		this.sellerID = sellerID;
	}
	//getter
	public String getItemName(){
		return this.itemName;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public String getItemID(){
		return this.itemID;
	}
	public String getDescription(){
		return this.itemDes;
	}
	public double getPrice(){
		return this.price;
	}
	public String getSellerID(){
		return this.sellerID;
	}
	
	public String toString(){
		String name = "Item: " + getItemName();
		String quan = "Quantity of Item: " + getQuantity();
		String price = "Price: " + getPrice();
		String iD = "ItemID: " + getItemID();
		String description = "Item Description: " + getDescription();
		return name + "\n" + iD + "\n" + description + "\n" + quan + "\n" + price + "\n"; 
	}
}