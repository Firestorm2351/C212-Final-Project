public class Admin{
	private String adminName;
	private String password;
	
	public Admin(String admin, String pass){
		this.adminName = admin;
		this.password = pass;
	}
	
	public Admin() {}

	public String getAdmin(){
		return this.adminName;
	}
	public String getPassword(){
		return this.password;
	}
	
	public void getBuyerInfo(Account ac){
		//buyers
		ac.getAB();
    }
	public void getSellerInfo(Account seller){
		//sellers
		seller.getAS();
    
	}
	public void getItemInfo(Inventory inv){
		//items
		inv.getAllItem();
	}
  
	public void specificSellHistory(String sellID, SaleHistory a){
		a.saleSeller(sellID);
	}
	public void specificBuyHistory(String buyID, SaleHistory a){
		a.saleBuyer(buyID);
	}
  
  
  
  
  
  
  

}

