import java.util.*;

public class Inventory{
	private ArrayList<Item> listOfItem = new ArrayList<Item>();
  
	public Inventory(){}
	//allows the seller to add an item
  	public void addItem(String sellerID){
  		String descrip = "";
 		int inputCount = 0;
 		String itemName;
 		int itemQuan;
 		double itemPrice;
 		int num;
		Scanner scan = new Scanner(System.in);
 			System.out.println("What is the item name?(enter a String)");
			itemName = scan.nextLine();
			do{
				System.out.println("Quantity of the item.(enter an integer)");
				itemQuan = scan.nextInt();
			}while (itemQuan < 0);
			System.out.println("Item's Price(enter a double)");
			itemPrice = scan.nextDouble();
			System.out.println("ItemID will be the sellerID and a number. Please enter a number:");
			num = scan.nextInt();
			Scanner why = new Scanner(System.in);
 	 		System.out.println("Description for the item:");
 			descrip = why.nextLine();
 	 		
 		
		this.listOfItem.add(new Item(itemName, descrip, sellerID, itemQuan, itemPrice, num));
  	}
  	//add item from a csv to keep state persistance
  	public void addItemCSV(String itemName,String itemID, String sellerID, int quantity, double price, String itemDes){
  		this.listOfItem.add(new Item(itemName, itemDes, sellerID, quantity, price, itemID));
  	}
  	//for testing in main
  	public void addItemTest(String itemName, String descrip, String sellerID, int itemQuan, double itemPrice, int num){
  		this.listOfItem.add(new Item(itemName, descrip, sellerID, itemQuan, itemPrice, num));
  	} 
  	//find an item and return the item to be sold
	public Item findItem(String itemIDN){
		Item found = null;
		for (int i = 0; i < this.listOfItem.size(); i++){
			if (itemIDN.equals(this.listOfItem.get(i).getItemName())){
				found = this.listOfItem.get(i);
			}
			else if (itemIDN.equals(this.listOfItem.get(i).getItemID())){
				found = this.listOfItem.get(i);
			}
		}
		return found;
	}
	//allows the buyer to search for item by name or ID
	public String searchForItem(String itemIDN){
		for (int i = 0; i < this.listOfItem.size(); i++){
			if(itemIDN.equals(this.listOfItem.get(i).getItemName())){
				return this.listOfItem.get(i).toString();
			}
			else if (itemIDN.equals(this.listOfItem.get(i).getItemID())){
				return this.listOfItem.get(i).toString();
			}
		}
	  return "There is no such item in the inventory";
	}
	//Display all item within the inventory
	public void getAllItem(){
		if (this.listOfItem.isEmpty()){
			System.out.println("There are currently no item within the inventory");
		}
		else{
			for(int i = 0; i < this.listOfItem.size(); i++){
				System.out.println(this.listOfItem.get(i).toString());
			}
		}
	}
	//check if the quantity is not 0 so that the buyer can buy an item
	public boolean avaliable(String itemIDN){
		boolean avali = false;
		for (int i = 0; i < listOfItem.size(); i++){
			if (itemIDN.equals(this.listOfItem.get(i).getItemName()) && this.listOfItem.get(i).getQuantity() > 0){
				avali = true;
				break;
			}
			else if (itemIDN.equals(this.listOfItem.get(i).getItemID()) && this.listOfItem.get(i).getQuantity() > 0){
				avali = true;
				break;
			}
			else {
				avali = false;
			}
		}
		return avali;
	}
	//allow the seller to remove an item
  	public void removeItem(String sellerID){
		Scanner addManage = new Scanner(System.in);
  		System.out.println("What is the itemID of the item?");
  		String itemID = addManage.nextLine();
		for (int i = 0; i < this.listOfItem.size(); i++){
			if (sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
				this.listOfItem.remove(i);
			}
		}
	}
  	//for testing in main
  	public void removeItemTester(String sellerID, String itemID){
  		for (int i = 0; i < this.listOfItem.size(); i++){
			if (sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
				this.listOfItem.remove(i);
			}
  		}
  	}
  	//allow the seller to see their inventory
  	public void getSellerInventory(String sellerID){
  		if (this.listOfItem.isEmpty()){
			System.out.println("There are currently no item in your inventory");
		}
  		else{
  			for (int i = 0; i < this.listOfItem.size(); i++){
  				if (sellerID.equals(this.listOfItem.get(i).getSellerID())){
  					System.out.println(this.listOfItem.get(i).toString());
  				}
  			}
  		}
  	}
  	//update item description
  	public void setItemDescription(String itemID, String sellerID){
 		Scanner scan = new Scanner(System.in);
 		System.out.println("Description for the item:");
 		String descrip = scan.nextLine();
 		for(int i = 0; i < this.listOfItem.size(); i++){
 			if(sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
 				Item item = this.listOfItem.get(i);
 				item.setDescription(descrip);
 				this.listOfItem.set(i, item);
 			}
 		}
 	}
  	//for testing in main
  	public void setItemDescriptionTester(String itemID, String sellerID, String descrip){
  		for(int i = 0; i < this.listOfItem.size(); i++){
 			if(sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
 				Item item = this.listOfItem.get(i);
 				item.setDescription(descrip);
 				this.listOfItem.set(i, item);
 			}
  		}
  	}
  	//update item price
  	public void setPrice(String itemID, double price, String sellerID){
  		System.out.println("first");
  		System.out.println(this.listOfItem.size());
 		for(int i = 0; i < this.listOfItem.size(); i++){
 			System.out.println(this.listOfItem.get(i).getSellerID());
 			if(sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
 				Item item = this.listOfItem.get(i);
 				System.out.println("second");
 				item.setPrice(price);
 				this.listOfItem.set(i, item);
 			}
 			else {
 				System.out.println("third");
 			}
		}
 	}
  	//update item amount
  	public void setItemAmount(String itemID, int quantity, String sellerID){ 
 		for(int i = 0; i < this.listOfItem.size(); i++){
 			if(sellerID.equals(this.listOfItem.get(i).getSellerID()) && itemID.equals(this.listOfItem.get(i).getItemID())){
 				this.listOfItem.get(i).setQuantity(this.listOfItem.get(i).getQuantity() + quantity);
 			}
 		}
 	}
  	
  	public String getSellerID(String IDN){
  		for (int i = 0; i < this.listOfItem.size(); i++){
  			if (IDN.equals(this.listOfItem.get(i).getItemID())){
  				return this.listOfItem.get(i).getSellerID();
  			}
  			else if (IDN.equals(this.listOfItem.get(i).getItemName())){
  				return this.listOfItem.get(i).getSellerID();
  			}
  		}
  		return null;
  	}
  	
  	public ArrayList<Item> getArrayList(){
  		return this.listOfItem;
  	}
  	//testing 
  	public static void main(String[] args){	
  		// create a list to test with
  		Inventory tester = new Inventory();
  		tester.addItemTest("Laptop", "black", "ppham", 2, 700, 5);
  		tester.addItemTest("Bike", "red", "caltic", 50, 100, 7);
  		tester.addItemTest("grass", "green", "dsfg", 6, 98, 2);
  		tester.addItemTest("banana", "yellow", "sesan", 900, 2, 1);
  		
  		// findItem testing
  		System.out.println("" + tester.findItem("grass"));
  		System.out.println(tester.findItem("caltic7"));
  		System.out.println(tester.findItem("banana"));
  		System.out.println(tester.findItem("ppham5"));
  		System.out.println(tester.findItem("iphone"));
  		
  		// searchForItem testing
  		System.out.println(tester.searchForItem("grass"));
  		System.out.println(tester.searchForItem("caltic7"));
  		System.out.println(tester.searchForItem("banana"));
  		System.out.println(tester.searchForItem("ppham5"));
  		
  		// getAllItem testing
  		System.out.println("here are all the items" + "\n");
  		tester.getAllItem();
  		
  		// avaliable testing
  		System.out.println(tester.avaliable("caltic7"));
  		System.out.println(tester.avaliable("df"));
  		
  		// removeItem testing
  		tester.removeItemTester("caltic", "caltic7");
  		System.out.println(tester.findItem("caltic7"));
  		
  		// getSellerInventory testing
  		tester.getSellerInventory("sesan");
  		tester.getSellerInventory("ppham");
  		
  		// setItemDescription testing
  		tester.setItemDescriptionTester("ppham5", "ppham", "asdfasdfsdfjd");
  		tester.setItemDescriptionTester("sesan1", "sesan", "description");
  		
  		// setItemPrice testing
  		tester.setPrice("ppham5", 90000, "ppham");
  		tester.setPrice("dsfg2", .12, "dsfg");
  		tester.getAllItem();
  		
  		// setItemAmount testing
  		tester.setItemAmount("ppham5", 2, "ppham");
  		tester.setItemAmount("dsfg2", 9020, "dsfg");
  		
  	}
}