
public class Employee {
	int id;
	String name;
	int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	void addEmployee()
	{
		MysqlCon.add(this);
	}
	static void deleteEmployee(int id)
	{
		MysqlCon.delete(id);
	}
	public static void displayEmployee() {
		MysqlCon.display();
		
	}

}
