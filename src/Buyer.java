public class Buyer{
	//instance variable 
	private String buyerID;
	private String password;
	private String email;
	//default constructor
	public Buyer(){}
	//seller constructor
 	public Buyer(String buyerID, String password, String email){
 		this.buyerID = buyerID;
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
 	public String getBuyerID(){
 		return this.buyerID;
 	}
 	public String getPassword(){
 		return this.password;
 	}
 	public String getEmail(){
	  return this.email;
  	}
 	public String toString(){
 		String result;
 		    
	    result = "BuyerID: " + this.getBuyerID() + "\n" + "Password: " + this.getPassword() + "\n" + "Email: " + this.getEmail() + "\n";
	    return result; //complete
  	}
}