import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPurchase all = new AllPurchase(20000);
		Scanner sc = new Scanner(System.in);
		int check = 0;
		
		String prompt = "1. 記帳, 2. 查看總覽, 3. 信用貸款查看: ";
		
		System.out.print(prompt);
		while(sc.hasNextInt()) {
			check = sc.nextInt();
			if(check == 1) {
				System.out.print("名稱: ");
				String name = sc.next();
				System.out.print("金額: ");
				int price = sc.nextInt();
				
				all.add(name, price, sc);

			}else if(check == 2){
				System.out.println(all.detail());
			}else if(check == 3) {
				double total = 0;
				for(Purchase p: all.getList()) {
					if(p instanceof Credit) {
						total += ((Credit) p).getPayment(0);
					}
				}
				System.out.printf("信用貸款目前累積: %.2f\n", total);	
			}	
			System.out.println("-".repeat(40));
			System.out.print(prompt);
		}
		System.out.print("Thank you~");
	}
}
