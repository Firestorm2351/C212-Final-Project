import java.io.*;
import java.util.*;

public class CSVReader {
	private Account account = new Account();
	// constructor
	public CSVReader(){}
	// counts the number of collums in the input file
	public int numberOfCol(String inputFile){
		int count = 0;
		try {
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String line = scan.readLine();
			String splitLine [] = line.split(",");// the split is by a comma
			count += splitLine.length;
		}catch(Exception e){}
		return count;
	}
	public int numberOfRows(String inputFile){
		int count = 0;// count is initialised at 0
		try {
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			while (scan.readLine() != null){
				count++;// add one to count everytime
			}
		}catch(Exception e){}
		return count; // return count
	}
	
	public void addItems(Inventory inventory, String inputFile){
		int col = numberOfCol(inputFile);
		int rows = numberOfRows(inputFile);
		String itemName; // initialize variables
		String itemID;
		String itemDes;
		String sellerID;
		int quantity;
		double price;
		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String[][] csv = new String [rows][col];// create a 2d array of the same length
			for (int i = 0; i < rows; i++){
				csv[i] = scan.readLine().split(",");
			}
			for (int i = 0; i < rows; i++){
				itemName = csv[i][0];
				itemID = csv[i][1];
				sellerID = csv[i][2];
				price = Double.parseDouble(csv[i][3]);// parse it to a double
				quantity = Integer.parseInt(csv[i][4]);// parse it to an int
				itemDes = csv[i][5];
				inventory.addItemCSV(itemName, itemID, sellerID, quantity, price, itemDes);
			}
		}catch(Exception e){}
	}
	
	public void addAccountBuyer(Account account, String inputFile){
		int col = numberOfCol(inputFile);
		int rows = numberOfRows(inputFile);
		String ID;
		String password;
		String eMail;

		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String[][] csv = new String [rows][col];
			for (int i = 0; i < rows; i++){
				csv[i] = scan.readLine().split(",");
			}
			for (int i = 0; i < rows; i++){
				ID = csv[i][0];
				password = csv[i][1]; // password is always in 1st collumn
				eMail = csv[i][2];// eMail is the i row and 2nd collum
				account.addBuyer(ID, password, eMail);
			}
		}catch(Exception e){}
	}
	
	public void addAccountSeller(Account account, String inputFile){
		int col = numberOfCol(inputFile);
		int rows = numberOfRows(inputFile);
		String ID;
		String password;
		String eMail;

		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String[][] csv = new String [rows][col];
			for (int i = 0; i < rows; i++){
				csv[i] = scan.readLine().split(",");
			}
			for (int i = 0; i < rows; i++){
				ID = csv[i][0];
				password = csv[i][1]; // password is always in 1st collumn
				eMail = csv[i][2]; // eMail is the i row and 2nd collum
				account.addBuyer(ID, password, eMail);
			}
		}catch(Exception e){}
	}
	public void addAccountAdmin(Account account, String inputFile){
		int col = numberOfCol(inputFile);
		int rows = numberOfRows(inputFile);
		String ID;
		String password;

		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String[][] csv = new String [rows][col];
			for (int i = 0; i < rows; i++){
				csv[i] = scan.readLine().split(",");
			}
			for (int i = 0; i < rows; i++){
				ID = csv[i][0];
				password = csv[i][1]; // password is always in 1st collumn
				account.addAdmin(ID, password);
			}
		}catch(Exception e){}
	}
	public void addSale(SaleHistory sale, String inputFile){
		int col = numberOfCol(inputFile);
		int rows = numberOfRows(inputFile);
		String BuyerID;
		String sellerID;
		String itemID;

		try{
			BufferedReader scan = new BufferedReader(new FileReader(inputFile));
			String[][] csv = new String [rows][col];
			for (int i = 0; i < rows; i++){
				csv[i] = scan.readLine().split(",");
			}
			for (int i = 0; i < rows; i++){
				BuyerID = csv[i][0];
				sellerID = csv[i][1]; // password is always in 1st collumn
				itemID = csv[i][2]; // eMail is the i row and 2nd collum
				sale.addSale(BuyerID, itemID, sellerID);
			}
		}catch(Exception e){}
	}
	
	
	public void updateItems(ArrayList<Item> out){
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter("Item.csv"));
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < out.size(); i++){
				build.append(out.get(i).getItemName());
				build.append(",");
				build.append(out.get(i).getItemID());
				build.append(",");
				build.append(out.get(i).getSellerID());
				build.append(",");
				build.append(out.get(i).getPrice());
				build.append(",");
				build.append(out.get(i).getQuantity());
				build.append(",");
				build.append(out.get(i).getDescription());
				write.write(build.toString());
			}
		}catch (Exception e){}
	}
	
	public void updateBuyer(ArrayList<Buyer> out){
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter("Buyer.csv"));
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < out.size(); i++){
				build.append(out.get(i).getBuyerID());
				build.append(",");
				build.append(out.get(i).getPassword());
				build.append(",");
				build.append(out.get(i).getEmail());
				write.write(build.toString());
			}
		}catch (Exception e){}
	}
	
	public void updateSeller(ArrayList<Seller> out){
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter("Seller.csv"));
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < out.size(); i++){
				build.append(out.get(i).getSellerID());
				build.append(",");
				build.append(out.get(i).getPassword());
				build.append(",");
				build.append(out.get(i).getEmail());
				write.write(build.toString());
			}
		}catch (Exception e){}
	}
	public void updateSale(ArrayList<SaleHistory> out){
		try{
			BufferedWriter write = new BufferedWriter(new FileWriter("sale.csv"));
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < out.size(); i++){
				build.append(out.get(i).getBuyerFromSale());
				build.append(",");
				build.append(out.get(i).getSellerFromSale());
				build.append(",");
				build.append(out.get(i).getItemID());
				write.write(build.toString());
			}
		}catch (Exception e){}
	}
}
