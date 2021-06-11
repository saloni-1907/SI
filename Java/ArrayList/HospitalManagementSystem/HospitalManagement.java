package management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HospitalManagement {
	public static void main(String[] args)
	{
		int choice;
		int deleteId,updateId;
		int updateChoice;
		Scanner sc=new Scanner(System.in);
		ArrayList<Patient> al=new ArrayList<Patient>();
		do
		{
			System.out.println("Press");
			System.out.println("1:Add Patients");
			System.out.println("2:Update Patients");
			System.out.println("3:Delete Patients");
			System.out.println("4:Display Patients");
			System.out.println("5:Exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
					Patient p =new Patient();
					al.add(p);
					System.out.println("Patient registered successfully");
					break;
			case 2:
					System.out.println("Enter the ID of the patient that you want to update");
					updateId=sc.nextInt();
					System.out.println("Press");
					System.out.println("1:Update Name");
					System.out.println("2:Update Contact");
					System.out.println("3:Update Age");
					System.out.println("4:Update Fees");
					System.out.println("5:Update Illness");
					System.out.println("6:Update Gender");
					System.out.println("Enter your choice:");
					updateChoice=sc.nextInt();
					sc.nextLine();
					switch(updateChoice)
					{
						case 1:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated name");
							    	String name=sc.nextLine();
							    	patient.setName(name);
							    	System.out.println("Patient's name updated successfully!");
							    }
							}
							break;
						case 2:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated contact");
							    	String contact=sc.nextLine();
							    	patient.setContactNo(contact);
							    	System.out.println("Patient's contact updated successfully!");
							    }
							}
							break;
						case 3:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated age");
							    	int age=sc.nextInt();
							    	patient.setAge(age);
							    	System.out.println("Patient's age updated successfully!");
							    }
							}
							break;
						case 4:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated fees");
							    	float fees=sc.nextFloat();
							    	patient.setFees(fees);
							    	System.out.println("Patient's fees updated successfully!");
							    }
							}
							break;
						case 5:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated illness");
							    	String illness=sc.nextLine();
							    	patient.setIllness(illness);
							    	System.out.println("Patient's illness updated successfully!");
							    }
							}
							break;
						case 6:
							for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
							{
								Patient patient= iterator.next();
							    if (patient.getId()==updateId) 
							    {
							    	System.out.println("Enter updated gender");
							    	String gender=sc.nextLine();
							    	patient.setGender(gender);
							    	System.out.println("Patient's gender updated successfully!");
							    }
							}
							break;
						default:
							System.out.println("Please enter valid choice");
							
					}
					break;
					
			case 3:
					
					System.out.println("Enter the ID of the patient that you want to remove");
					deleteId=sc.nextInt();
						for (Iterator<Patient> iterator = al.iterator(); iterator.hasNext();)
						{
						  Patient patient= iterator.next();
						    if (patient.getId()==deleteId) 
						    {
						       iterator.remove();
						       System.out.println("Patient deleted successfully!");
						    }
						}
					break;
			
			case 4:
					System.out.println("Id"+"\t"+"Name"+"\t"+"Contact"+"\t\t"+"Age"+"\t"+"Fees"+"\t"+"Illness"+"\t"+"Gender");
					for(Patient pat : al)
			            System.out.println(pat);
					break;
					
			
			case 5:
					System.exit(0);
			}
			
		}while(choice!=5);
	
	}

}

