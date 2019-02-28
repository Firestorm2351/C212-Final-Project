import java.util.*;
public class SaleHistory {
	private Account acc = new Account();
	private String it;
	private ArrayList<SaleHistory> sale  = new ArrayList<SaleHistory>();
	private String buyerID;
	private String sellerID;
	//default constructor
	public SaleHistory(){}
	//constructor
	public SaleHistory(String bID, String sID, String itID){
		this.buyerID = bID;
		this.sellerID = sID;
		this.it = itID;
	}
	//add to the arraylist
	public void addSale(String bID, String itemID, String sellerID){
		sale.add(new SaleHistory(bID, itemID, sellerID));
	}
	
	//get all sale history
	public void getAllSH(){
		if (sale.isEmpty()){
			System.out.println("No sale has been made");
		}
		else {
			for (int i = 0; i < sale.size(); i++){
				System.out.println(sale.get(i).toString());
			}
		}
	}
	public ArrayList<SaleHistory> get(){
		return this.sale;
	}
	 //display a seller history by taking in a seller ID
	 public void saleSeller(String sellerID){
	   for(int i = 0; i < sale.size(); i++){
	     if(sellerID.equals(sale.get(i).getSellerFromSale())){
	       System.out.println(sale.get(i).toString()); //TODO NOT FROM THE ORIGINAL
	     }
	    }
	 }
	  //display a seller history by taking in a buy ID
	  public void saleBuyer(String buyID){
	   for(int i = 0; i < sale.size(); i++){
	     if(buyID.equals(sale.get(i).getBuyerFromSale())){
	       System.out.println(sale.get(i).toString()); //TODO NOT FROM THE ORIGINAL
	     }
	    }
	 }
	
	//getter
	public String getBuyerFromSale(){
		return this.buyerID;
	}
	public String getSellerFromSale(){
		return this.sellerID;
	}
	public String getItemID(){
		return this.it;
	}
	//toString
	public String toString(){
		String nL = "\n";
		String item = it.toString();
		return "Buyer: " + getBuyerFromSale() + nL + "Seller: " + getSellerFromSale() + nL + item;
	}
	public void updateSale(){}//TODO csv file
}
