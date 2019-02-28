import java.util.*;

public class Account{
	private ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	private ArrayList<Seller> sellerList = new ArrayList<Seller>();
	private ArrayList<Admin> adminList = new ArrayList<Admin>();
  
	public Account(){}
	//register a buyer
	public void registerBuyer(){
		String newBuyerID;
		Scanner buy = new Scanner(System.in);
		do{
			System.out.println("BuyerID:");
			newBuyerID = buy.nextLine();
		}while (existBuyer(newBuyerID));
		
		System.out.println("Password:");
		String newPassword = buy.nextLine();
		
		System.out.println("Email Address:");
		String newEmail = buy.nextLine();
		
		Util.ID = newBuyerID;
		Util.pass = newPassword;
		Util.email = newEmail;
		buyerList.add(new Buyer(newBuyerID, newPassword, newEmail));
	}
	//for testing in main
	public void registerBuyerTester(String newBuyerID, String newPassword, String newEmail){
		buyerList.add(new Buyer(newBuyerID, newPassword, newEmail));
	}
	//add buyer from csv
	public void addBuyer(String buyerID, String password, String email){
		buyerList.add(new Buyer(buyerID, password, email));
	}
	//information for an admin
	public void getAB(){
		if (this.buyerList.isEmpty()){
			System.out.println("empty");
		}
		else{
			for (int i = 0; i < this.buyerList.size(); i++){
				System.out.println(this.buyerList.get(i).toString());
			}
		}
	}
	//see if a username is already taken
 	public boolean existBuyer(String bID){
 		for (int i = 0; i < buyerList.size(); i++){
			if (bID == buyerList.get(i).getBuyerID()){
 				return true;
			}
 		}
 		return false;
 	}
 	//log in the buyer
	public boolean logInBuyer(String buyerID, String password){
		for (int i = 0; i < buyerList.size(); i++){
			if (buyerID.equals(buyerList.get(i).getBuyerID())){
				if (password.equals(buyerList.get(i).getPassword())){
					return false;
				}
			}
		}
		System.out.println("Your buyerID or password is incorrect");
		return true;
	}
	//update buyer info
	public void updateBuyer(){
		Scanner information = new Scanner(System.in);
		int option;
		do {
			System.out.println("What would you like to update?");
			System.out.println("1: password");
			System.out.println("2: email");
			option = information.nextInt();
		}while(option != 1 && option != 2);
		Scanner newInfo = new Scanner(System.in);
		if (option == 1){
			System.out.println("What is the new password?");
			String newPassword = newInfo.nextLine();
			for (int i = 0; i < buyerList.size(); i++){
				if (Util.ID.equals(buyerList.get(i).getBuyerID())){
					Buyer buyer = buyerList.get(i);
					buyer.setPassword(newPassword);
					buyerList.set(i, buyer);
				}
			}
		}
		else if (option == 2){
			System.out.println("What is the new email?");
			String newEmail = newInfo.nextLine();
			for (int i = 0; i < buyerList.size(); i++){
				if (Util.ID.equals(buyerList.get(i).getBuyerID())){
					Buyer buyer = buyerList.get(i);
					buyer.setEmail(newEmail);
					buyerList.set(i, buyer);
				}
			}
		}
	}
	//allows admin to see buyer info
	public String getBuyerInfo(String email){
		for(int i = 0; i < this.buyerList.size(); i++){
			if (email.equals(this.buyerList.get(i).getEmail())){
				return "Buyer ID: " + this.buyerList.get(i).getBuyerID() + "\n" + "Password: " + this.buyerList.get(i).getPassword() + "\n" + "Email: " + this.buyerList.get(i).getEmail();
			}
		}
		return "INVALID EMAIL";
	}
	//return the arraylist of buyer
	public ArrayList<Buyer> getBuyerAll(){
		return this.buyerList;
	}
	//register a seller
	public void registerSeller(){
		String newSellerID;
		Scanner sell = new Scanner(System.in);
		do{
			System.out.println("SellerID:");
			newSellerID = sell.nextLine();
		}while (existSeller(newSellerID));
	
		System.out.println("Password:");
		String newPassword = sell.nextLine();
		
		System.out.println("Email Address:");
		String newEmail = sell.nextLine();
		
		Util.ID = newSellerID;
		Util.pass = newPassword;
		Util.email = newEmail;
		sellerList.add(new Seller(newSellerID, newPassword, newEmail));
	}
	//for testing in main
	public void registerSellerTester(String newSellerID, String newPassword, String newEmail){
		sellerList.add(new Seller(newSellerID, newPassword, newEmail));
	}
	//add seller from csv
	public void addSeller(String sellerID, String password, String email){
		sellerList.add(new Seller(sellerID, password, email));
	}
	//information for an admin
	public void getAS(){
		if (this.buyerList.isEmpty()){
			System.out.println("empty");
		}
		else{
			for (int i = 0; i < this.sellerList.size(); i++){
				System.out.println(this.sellerList.get(i).toString());
			}
		}
	}
	//see if a username is already taken
	public boolean existSeller(String sID){
 		for (int i = 0; i < sellerList.size(); i++){
			if (sID == sellerList.get(i).getSellerID()){
 				return true;
			}
 		}
 		return false;
 	}
	//log in a seller
	public boolean logInSeller(String sellerID, String password){
		for (int i = 0; i < sellerList.size(); i++){
			if (sellerID.equals(sellerList.get(i).getSellerID())){
				if (password.equals(sellerList.get(i).getPassword())){
					return false;
				}	
			}
		}
		System.out.println("Your sellerID or password is incorrect");
		return true;
	}
	//update seller info
	public void updateSeller(){
		Scanner information = new Scanner(System.in);
		int option;
		do {
			System.out.println("What would you like to update?");
			System.out.println("1: password");
			System.out.println("2: email");
			option = information.nextInt();
		}while(option != 1 && option != 2);
		Scanner newInfo = new Scanner(System.in);
		if (option == 1){
			System.out.println("What is the new password?");
			String newPassword = newInfo.nextLine();
			System.out.println("SellerList " + sellerList.size());
			for (int i = 0; i < sellerList.size(); i++){
				if (Util.ID.equals(sellerList.get(i).getSellerID())){
					Seller seller = sellerList.get(i);
					seller.setPassword(newPassword);
					sellerList.set(i, seller);
				}
			}
		}
		else if (option == 2){
			System.out.println("What is the new email?");
			String newEmail = newInfo.nextLine();
			for (int i = 0; i < sellerList.size(); i++){
				if (Util.ID.equals(sellerList.get(i).getSellerID())){
					Seller seller = sellerList.get(i);
					seller.setEmail(newEmail);
					sellerList.set(i, seller);
				}
			}
		}
	}
	//allow admin to see seller info
	public String getSellerInfo(String email){
		for(int i = 0; i < this.sellerList.size(); i++){
			if (email.equals(this.sellerList.get(i).getEmail())){
				return "Seller ID: " + this.sellerList.get(i).getSellerID() + "\n" + "Password: " + this.sellerList.get(i).getPassword() + "\n" + "Email: " + this.sellerList.get(i).getEmail();
			}
		}
		return "INVALID EMAIL";
	}
	//return the arraylist of seller
	public ArrayList<Seller> getSellerAll(){
		return this.sellerList;
	}
	
	public boolean logInAdmin(String admin, String password){
		for (int i = 0; i < this.adminList.size(); i++){
			if (admin.equals(this.adminList.get(i).getAdmin())){
				if (password.equals(this.adminList.get(i).getPassword())){
					return false;
				}
			}
		}
		System.out.println("Your buyerID or password is incorrect");
		return true;
	}
	//add admin from csv
	public void addAdmin(String iD, String password) {
		adminList.add(new Admin(iD, password));
	}
	
	public static void main(String[] args){
		Account tester = new Account();
		
		// registerBuyerTester testing
		tester.registerBuyerTester("sjuddha", "hello", "some@yahoo.com");
		tester.registerBuyerTester("kbaiche", "Yelwe", "thing@yahoo.com");
		tester.registerBuyerTester("kriley", "aghe", "sohing@yahoo.com");
		tester.registerBuyerTester("tmcleland", "sdfd", "smething@yahoo.com");
		
		// existBuyer testing
		System.out.println(tester.existBuyer("kbaiche"));
		System.out.println(tester.existBuyer("caltic"));
		
		// logInBuyer testing
		System.out.println(tester.logInBuyer("sjuddha", "hello"));
		System.out.println(tester.logInBuyer("kriley", "aghe"));
		System.out.println(tester.logInBuyer("tmcleland", "fake password"));
		
		// getBuyerInfo testing
		System.out.println(tester.getBuyerInfo("thing@yahoo.com") + "\n");
		System.out.println(tester.getBuyerInfo("smething@yahoo.com"));
		System.out.println(tester.getBuyerInfo(".com"));
		
		// registerSellerTester testing
		tester.registerSellerTester("irobinson", "doggs", "rom@something.net");
		tester.registerSellerTester("awilliams", "heiek", "ranom@something.net");
		tester.registerSellerTester("republic", "eyr", "random@something.net");
		
		// existSeller testing
		System.out.println(tester.existSeller("irobinson"));
		System.out.println(tester.existSeller("sdfdf"));
		
		// loginSeller testing
		System.out.println(tester.logInSeller("awilliams", "heiek"));
		
		//
	}
}
