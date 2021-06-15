import java.util.Scanner;

public class ManageEmployees {

	public static void main(String[] args) {
		int choice;
		int id;
		Scanner sc=new Scanner(System.in);
		do
		{
		System.out.println("Press:");
		System.out.println("1:Add Employee");
		System.out.println("2:Delete Employee");
		System.out.println("3:Display Employee");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
				System.out.println("Enter employee ID");
				id=sc.nextInt();
				System.out.println("Enter employee name");
				sc.nextLine();//escaping
				String name=sc.nextLine();
				System.out.println("Enter employee age");
				int age=sc.nextInt();
				Employee e=new Employee();
				e.setId(id);
				e.setName(name);e.setAge(age);
				e.addEmployee();
				break;
		case 2:
				System.out.println("Enter employee ID");
				id=sc.nextInt();
				Employee.deleteEmployee(id);
				break;
		case 3:
				Employee.displayEmployee();
				break;
		case 5:
				System.exit(0);
				break;
				
		}
		}while(choice!=5);
		
		sc.close();
	}
	

}
