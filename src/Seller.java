public class Seller{
	//instance variable 
 	private String sellerID;
 	private String password;
 	private String email;
 	//default constructor
 	public Seller(){}
 	//seller constructor
 	public Seller(String sellerID, String password, String email){
 		this.sellerID = sellerID;
 		this.password = password;
 		this.email = email;
 	}
 	//setter 
 	public void setPassword(String password) {
 		this.password = password;
 	}
 	public void setEmail(String email) {
 		this.email = email;
 	}
 	//getter
 	public String getSellerID(){
 		return this.sellerID;
 	}
 	public String getPassword(){
 		return this.password;
 	}
 	public String getEmail(){
 		return this.email;
 	}
 	public String toString(){
 		String result;
 		    
	    result = "SellerID: " + this.getSellerID() + "\n" + "Password: " + this.getPassword() + "\n" + "Email: " + this.getEmail() + "\n";
	    return result; //complete
  	}
}