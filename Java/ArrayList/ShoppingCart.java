import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	
	public static void main(String[] args) {
	
	int choice;
	String pName;
	Scanner sc=new Scanner(System.in);
	List productList=new ArrayList<>();
	start:
	do
	{
		System.out.println("Press");
		System.out.println("1:Add Product to cart");
		System.out.println("2:Remove Product from Cart");
		System.out.println("3:Display products in Cart");
		System.out.println("4:Exit");
		System.out.print("Enter your choice:");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
			case 1:
					System.out.println("Enter product name");
					pName=sc.nextLine();
					if(productList.contains(pName))
					{
						System.out.println("Product already exists in the cart!");
					}
					else
					{
						productList.add(pName);
						System.out.println("Product successfully added!");
					}
				
					break;
			case 2:
					if(productList.isEmpty())
					{
						System.out.println("The cart is empty!");
						continue start;
					}
					System.out.println("Enter product name");
					pName=sc.nextLine();
					if(productList.contains(pName))
					{
						productList.remove(pName);
						System.out.println("Product successfully removed!");
					}
					else
					{
						System.out.println("No such product exists!");
					}
					break;
			case 3:
					for(Object product :productList)
						System.out.println(product);
					break;
			case 4:
					System.exit(1);
					break;
			default:
					System.out.println("Invalid Choice!");
					continue start;
					
		}
	}while(choice!=4);
	
	sc.close();

	}
	
}
