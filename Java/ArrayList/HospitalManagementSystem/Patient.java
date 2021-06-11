package management;

import java.util.Scanner;

public class Patient {

	int id;
	String name;
	int age;
	String gender;
	String contactNo;
	String illness;
	float fees;
	Scanner sc=new Scanner(System.in);
	
	Patient()
	{
		this.id=(int)(Math.random()*10)+1;
		System.out.println("Enter patient's name");
		this.name=sc.nextLine();
		System.out.println("Enter patient's age");
		this.age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter patient's gender");
		this.gender= sc.nextLine();
		System.out.println("Enter patient's contact number");
		this.contactNo= sc.nextLine();
		System.out.println("Enter patient's illness");
		this.illness= sc.nextLine();
		System.out.println("Enter patient's fees");
		this.fees= sc.nextFloat();
		
	}
	
	Patient(int id,String name,String address,int age,String gender,String contactNo,String illness,float fees,String joinDate)
	{
		this.id=id;
		this.name=name;
		
		this.age=age;
		this.gender=gender;
		this.contactNo=contactNo;
		this.illness=illness;
		this.fees=fees;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public String toString(){
        return getId()+"\t"+getName() + "\t" + getContactNo() +"\t"+getAge()+"\t"+getFees()+"\t"+getIllness()+" "+getGender() ;
    }
    

}
