import java.util.ArrayList;
import java.util.Scanner;
public class AllPurchase {
		private ArrayList<Purchase>allPurchase;
		private int limit;
		
		public AllPurchase(int limit) {
			this.limit = limit;
			this.allPurchase = new ArrayList<Purchase>();
		}
		
		public ArrayList<Purchase> getList(){
			return allPurchase;
		}
		
		public int getLimit() {
			return limit;
		}
		
		public void add(String name, int price, Scanner sc) {
			System.out.println("1. cash, 2. on credit");
			int check = sc.nextInt();
			if(check ==1) {
				Purchase pur = new Purchase(name, price);
				allPurchase.add(pur);
			}else {
				Purchase credit = new Credit(name, price);
				allPurchase.add(credit);
			}
			System.out.println("Success!");
		}
		
		public int getTotal() {
			int total = 0;
			for(Purchase p: allPurchase) {
				total += p.getPrice();
			}
			return total;
		}
		
		public String detail() {
			String detail = "";
			for(Purchase p: allPurchase) {
				detail = detail + p.getName() + " " + p.getPrice() + "\n";
			}
			detail = "總覽: \n" + detail + "\nTotal: " + this.getTotal() + "\n";
			return detail;
		}
}