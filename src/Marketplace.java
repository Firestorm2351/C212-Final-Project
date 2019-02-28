import java.util.*;

public class Marketplace{
	private Inventory inventory = new Inventory();
	private Account account = new Account();
	private SaleHistory sh = new SaleHistory();
	private CSVReader csv = new CSVReader();
	private Notification notify = new Notification();
	private Admin ad = new Admin();
 
	public Marketplace(){}
	//Start the market
	public void startMarket(){
		Scanner choice = new Scanner(System.in);
		int option;
		
		do{
			System.out.println("Welcome to the Market");
			System.out.println("What would you like to do?(choose the number corresponding with choice)");
			System.out.println("1: Log-in/Register as a buyer");
			System.out.println("2: Log-in/Register as a seller");
			System.out.println("3: Log-in as Admin");
			System.out.println("4: Quit");
			option = choice.nextInt();
			sortMarket();
			
		}while(option > 4 && option < 1);
		if (option == 1){
			if (loginBuyer()){
				startBuyer();
			}
			else {
				startMarket();
			}
		}
		else if (option == 2){
			if (loginSeller()){
				startSeller();
			}
			else {
				startMarket();
			}
		}
		else if (option == 3){
			if (loginAdmin()){
				startAdmin();
			}
			else {
				startMarket();
			}
		}
		//choice.close();
	}
	//option for log-ining
	public int logIn(){
		Scanner scan = new Scanner(System.in);
		int option;
		do{
			System.out.println("1: Register");
			System.out.println("2: Log-in");
			System.out.println("3: Market Menu");
			option = scan.nextInt();
		}while(option < 1 && option > 3);
		//scan.close();
		return option;
	}
	//log-in or register buyer
	public boolean loginBuyer(){
		int option = logIn();
		String logBuyerID;
		String logPassword;
		if(option == 1){
			account.registerBuyer();
			csv.updateBuyer(account.getBuyerAll());
			return true;
		}
		else if(option == 2){
			Scanner buy = new Scanner(System.in);
			do {
				System.out.println("BuyerID:");
				logBuyerID = buy.nextLine();
				System.out.println("Password:");
				logPassword = buy.nextLine();
			}while (account.logInBuyer(logBuyerID, logPassword));
			Util.ID = logBuyerID;
			Util.pass = logPassword;
			return true;
		}
		else {
			return false;
		}
	}
	//log-in or register seller
	public boolean loginSeller(){
		int option = logIn();
		String logSellerID;
		String logPassword;
		if(option == 1){
			account.registerSeller();
			csv.updateSeller(account.getSellerAll());
			return true;
		}
		else if(option == 2){
			Scanner sell = new Scanner(System.in);
			do {
				System.out.println("SellerID:");
				logSellerID = sell.nextLine();
				System.out.println("Password:");
				logPassword = sell.nextLine();
			}while (account.logInSeller(logSellerID, logPassword));
			if (notify.isStockEmpty(logSellerID)){
				System.out.println("You are out of Stock");
			}
			Util.ID = logSellerID;
			Util.pass = logPassword;
			return true;
		}
		else {
			return false;
		}
	}
	//log-in admin
	public boolean loginAdmin(){
		Scanner scan = new Scanner(System.in);
		String logAdminID;
		String logPassword;
		int option;
		do{
			System.out.println("1: Log-in");
			System.out.println("2: Market Menu");
			option = scan.nextInt();
		}while(option < 1 && option > 2);
		if (option == 1){
			Scanner ad = new Scanner(System.in);
			do {
				System.out.println("SellerID:");
				logAdminID = ad.nextLine();
				System.out.println("Password:");
				logPassword = ad.nextLine();
			}while (account.logInAdmin(logAdminID, logPassword));
			Util.ID = logAdminID;
			Util.pass = logPassword;
			return true;
		}
		else {
			return false;
		}
	}
	//start the buyer menu
	public void startBuyer(){
		Scanner choiceBuyer = new Scanner(System.in);
		int option;
		boolean buyerNum = true;
		
		do {
			System.out.println("What would you like to do?");
			System.out.println("1: All item within the inventory");
			System.out.println("2: Search for an Item");
			System.out.println("3: Buy an item");
			System.out.println("4: Update Infomation");
			System.out.println("5: Log-out");
			option = choiceBuyer.nextInt();
			
		}while(option < 1 && option > 5);
		
		if (option == 1){
			inventory.getAllItem();
			startBuyer();
		}
		else if (option == 2){
			searchOption();
			startBuyer();
		}
		else if (option == 3){
			buy();
			startBuyer();
		}
		else if (option == 4){
			account.updateBuyer();
			csv.updateBuyer(account.getBuyerAll());
			startBuyer();
		}
		else if (option == 5){
			Util.ID = "";
			Util.pass = "";
			Util.email = "";
			startMarket();
		}
	}
	//start the seller
	public void startSeller(){
		Scanner choiceSeller = new Scanner(System.in);
		int option;
		boolean sellerNum = true;
		
		do {
			System.out.println("What would you like to do?");
			System.out.println("1: View Inventory");
			System.out.println("2: Manage Inventory");
			System.out.println("3: Change an item's price");
			System.out.println("4: Update an item's quantity");
			System.out.println("5: change an item's description");
			System.out.println("6: Update use information");
			System.out.println("7: Log-out");
			option = choiceSeller.nextInt();
			
		}while(option > 7 && option < 1);
		Scanner add = new Scanner(System.in);
		if (option == 1){
			inventory.getSellerInventory(Util.ID);
			startSeller();
		}
		else if (option == 2){
			manageInv();
			startSeller();
		}
		else if (option == 3){
			System.out.println("Item ID:");
			String itemID = add.nextLine();
			System.out.println("New Price:");
			double price = add.nextDouble();
			inventory.setPrice(itemID, price, Util.ID);
			csv.updateItems(inventory.getArrayList());
			startSeller();
		}
		else if (option == 4){
			System.out.println("Item ID:");
			String itemID = add.nextLine();
			System.out.println("New Price:");
			int quantity = add.nextInt();
			inventory.setItemAmount(itemID, quantity, Util.ID);
			csv.updateItems(inventory.getArrayList());
			startSeller();
		}
		else if (option == 5){
			System.out.println("Item ID:");
			String itemID = add.nextLine();
			inventory.setItemDescription(itemID, Util.ID);
			csv.updateItems(inventory.getArrayList());
			startSeller();
		}
		else if (option == 6){
			account.updateSeller();
			csv.updateSeller(account.getSellerAll());
			startSeller();
		}
		else if (option == 7){
			Util.ID = "";
			Util.pass = "";
			Util.email = "";
			startMarket();
		}
	}
	//start the admin 
	public void startAdmin(){
		Scanner choiceSeller = new Scanner(System.in);
		int option;
		boolean sellerNum = true;
		
		do {
			System.out.println("What would you like to do?");
			System.out.println("1: View All Buyers");
			System.out.println("2: View All Sellers");
			System.out.println("3: View All Items");
			System.out.println("4: Get Seller Sale History");
			System.out.println("5: Get Buyer Purchase History");
			System.out.println("6: Log-out");
			option = choiceSeller.nextInt();
			
		}while(option > 6 && option < 1);
		Scanner add = new Scanner(System.in);
		if (option == 1){
			ad.getBuyerInfo(account);
			startAdmin();
		}
		else if (option == 2){
			ad.getSellerInfo(account);
			startAdmin();
		}
		else if (option == 3){
			ad.getItemInfo(inventory);
			startAdmin();
		}
		else if (option == 4){
			System.out.println("Which Seller's sale history would you like to look at?");
			String sellID = add.nextLine();
			ad.specificSellHistory(sellID, sh);
			startAdmin();
		}
		else if (option == 5){
			System.out.println("Which Buyer's purchase history would you like to look at?");
			String buyID = add.nextLine();
			ad.specificBuyHistory(buyID, sh);
			startAdmin();
		}
		else if (option == 7){
			Util.ID = "";
			Util.pass = "";
			Util.email = "";
			startMarket();
		}
	}
	//allow buyer to search for an item
	public void searchOption(){
		Scanner optionChoice = new Scanner(System.in);
		System.out.println("Enter an item name or an item ID");
		if (optionChoice.hasNextLine()){
			String itemName = optionChoice.nextLine();
			System.out.println(inventory.searchForItem(itemName));
		}
	}
	//allow buyer to buy an item
	public void buy(){
		Scanner buyChoice = new Scanner(System.in);
		System.out.println("Enter an item name or an item ID");
		String itemName = buyChoice.nextLine();
		System.out.println("amount");
		int quan = buyChoice.nextInt();
		
		if (inventory.findItem(itemName) == null){
			System.out.println("Item does not exist");
		}
		else {
			if (inventory.avaliable(itemName)){
				inventory.setItemAmount(itemName, -quan, inventory.getSellerID(itemName));
				sh.addSale(Util.ID, inventory.findItem(itemName).getItemID(), inventory.findItem(itemName).getSellerID());
				csv.updateSale(sh.get());
			}
			else{
				notify.addNotify(inventory.getSellerID(itemName));
				System.out.println("This Item is currently out of stock. Please check back later.");
			}
		}
	}
	//allows seller to add or remove from inventory
	public void manageInv(){
		Scanner manage = new Scanner(System.in);
		int option;
		do{
			System.out.println("Would you like to add or remove an item?");
			System.out.println("1: Add item");
			System.out.println("2: Remove item");
			option = manage.nextInt();
		}while (option != 1 && option != 2);
		Scanner addManage = new Scanner(System.in);
		if (option == 1){
			inventory.addItem(Util.ID);
			csv.updateItems(inventory.getArrayList());
		}
		else if (option == 2){
			inventory.removeItem(Util.ID);
			csv.updateItems(inventory.getArrayList());
		}
		
	}
	//start csv files
	public void sortMarket(){
		csv.addItems(inventory, "Items.csv");
		csv.addAccountBuyer(account, "Buyer.csv");
		csv.addAccountSeller(account, "Seller.csv");
		csv.addAccountAdmin(account, "admin");
		csv.addSale(sh, "sale.csv");
	}
 
	public static void main(String[] args){
		Marketplace test = new Marketplace();
		test.startMarket();
	}
}
  