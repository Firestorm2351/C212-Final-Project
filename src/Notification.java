import java.util.*;

public class Notification {
	private ArrayList<String> notifySeller = new ArrayList<String>();
	
	public void addNotify(String sellerID){
		notifySeller.add(sellerID);
	}
	
	public boolean isStockEmpty(String sellerID){
		for(int i = 0; i < notifySeller.size(); i++){
			if (sellerID.equals(notifySeller.get(i))){
				return true;
			}
		}
		return false;
	} 
}
